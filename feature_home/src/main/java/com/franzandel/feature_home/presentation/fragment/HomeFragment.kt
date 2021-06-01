package com.franzandel.feature_home.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.extension.hide
import com.franzandel.core.extension.observe
import com.franzandel.core.extension.show
import com.franzandel.core.extension.showShareMessage
import com.franzandel.core.presentation.fragment.BaseFragmentVM
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.feature_home.R
import com.franzandel.feature_home.databinding.FragmentHomeBinding
import com.franzandel.feature_home.di.DaggerHomeComponent
import com.franzandel.feature_home.presentation.adapter.HomeAdapter
import com.franzandel.feature_home.presentation.vm.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.franzandel.dicodingexpertsubmission.R as AppR

class HomeFragment : BaseFragmentVM<HomeViewModel, FragmentHomeBinding>() {

    companion object {
        private const val GRID_SPAN_COUNT = 2
    }

    @Inject
    lateinit var thread: CoroutineThread

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    private val adapter get() = viewBinding.rvHome.adapter as HomeAdapter

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun onFragmentCreated() {
        showBottomNavigation()
        setupRV()
        setupObservers()
        setupListeners()
    }

    private fun showBottomNavigation() {
        val bottomNavigation =
            requireActivity().findViewById<BottomNavigationView>(AppR.id.nav_view)
        bottomNavigation.show()
    }

    private fun setupObservers() {
        with(viewLifecycleOwner) {
            getAllGames()

            observe(viewModel.errorResult) {
                showErrorPage()
            }

            adapter.addLoadStateListener { loadState ->
                if (loadState.refresh is LoadState.Loading) {
                    if (!loadState.prepend.endOfPaginationReached)
                        loadingDialog.get()?.show(requireActivity().supportFragmentManager)
                } else {
                    loadingDialog.get()?.hide()

                    val errorState = when {
                        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                        else -> null
                    }

                    errorState?.let {
                        showErrorPage()
                    }
                }
            }
        }
    }

    private fun showErrorPage() {
        viewBinding.layoutError.root.show()
        viewBinding.ablHome.hide()
        viewBinding.rvHome.hide()
    }

    private fun setupRV() {
        viewBinding.rvHome.layoutManager = GridLayoutManager(
            requireContext(),
            GRID_SPAN_COUNT
        )
        viewBinding.rvHome.adapter = HomeAdapter()
    }

    private fun setupListeners() {
        viewBinding.mtbHome.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_share -> {
                    requireActivity().showShareMessage(
                        getString(AppR.string.share_message_title),
                        getString(AppR.string.share_message_description)
                    )
                    true
                }
                else -> false
            }
        }

        viewBinding.layoutError.btnTryAgain.setOnClickListener {
            getAllGames()
        }
    }

    private fun getAllGames() {
        viewLifecycleOwner.lifecycleScope.launch(thread.background()) {
            viewModel.getAllGames().collect { gamesResults ->
                withContext(thread.main()) {
                    viewBinding.layoutError.root.hide()
                    viewBinding.ablHome.show()
                    viewBinding.rvHome.show()
                }

                adapter.submitData(gamesResults)
            }
        }
    }

    override fun getVM(): HomeViewModel = viewModel

    override fun injectDependencies() {
        DaggerHomeComponent.builder()
            .context(requireContext())
            .appComponent(
                EntryPointAccessors.fromApplication(
                    requireContext().applicationContext,
                    AppComponent::class.java
                )
            )
            .build()
            .inject(this)
    }
}
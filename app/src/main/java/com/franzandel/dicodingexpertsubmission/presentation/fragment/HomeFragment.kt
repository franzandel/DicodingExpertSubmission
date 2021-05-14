package com.franzandel.dicodingexpertsubmission.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.core.extension.hide
import com.franzandel.dicodingexpertsubmission.core.extension.observe
import com.franzandel.dicodingexpertsubmission.core.extension.show
import com.franzandel.dicodingexpertsubmission.core.extension.showShareMessage
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseFragmentVM
import com.franzandel.dicodingexpertsubmission.databinding.FragmentHomeBinding
import com.franzandel.dicodingexpertsubmission.databinding.LayoutErrorBinding
import com.franzandel.dicodingexpertsubmission.presentation.adapter.HomeAdapter
import com.franzandel.dicodingexpertsubmission.presentation.vm.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragmentVM<HomeViewModel, FragmentHomeBinding>() {

    companion object {
        private const val GRID_SPAN_COUNT = 2
    }

    @Inject
    lateinit var thread: CoroutineThread

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var errorViewBinding: LayoutErrorBinding

    private val adapter by lazy {
        HomeAdapter()
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun onFragmentCreated() {
        errorViewBinding = viewBinding.layoutError
        showBottomNavigation()
        setupRV()
        setupObservers()
        setupListeners()
    }

    private fun showBottomNavigation() {
        val bottomNavigation = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigation.show()
    }

    private fun setupObservers() {
        with(viewLifecycleOwner) {
            getAllGames()

            observe(viewModel.errorResult) {
                viewBinding.layoutError.root.show()
                viewBinding.ablHome.hide()
                viewBinding.rvHome.hide()
            }

            adapter.addLoadStateListener { loadState ->
                if (loadState.refresh is LoadState.Loading) {
                    if (!loadState.prepend.endOfPaginationReached)
                        loadingDialog.show(requireActivity().supportFragmentManager)
                } else {
                    loadingDialog.hide()

                    val errorState = when {
                        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                        else -> null
                    }

                    errorState?.let {
                        viewBinding.layoutError.root.show()
                        viewBinding.ablHome.hide()
                        viewBinding.rvHome.hide()
                    }
                }
            }
        }
    }

    private fun setupRV() {
        viewBinding.rvHome.layoutManager = GridLayoutManager(
            requireContext(),
            GRID_SPAN_COUNT
        )
        viewBinding.rvHome.adapter = adapter
    }

    private fun setupListeners() {
        viewBinding.mtbHome.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_share -> {
                    requireActivity().showShareMessage()
                    true
                }
                else -> false
            }
        }

        errorViewBinding.btnTryAgain.setOnClickListener {
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
}
package com.franzandel.feature_favorite.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.extension.observe
import com.franzandel.core.extension.show
import com.franzandel.core.extension.showShareMessage
import com.franzandel.core.presentation.fragment.BaseFragmentVM
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.feature_favorite.R
import com.franzandel.feature_favorite.databinding.FragmentFavoriteBinding
import com.franzandel.feature_favorite.di.DaggerFavoriteComponent
import com.franzandel.feature_favorite.presentation.adapter.FavoriteAdapter
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import com.franzandel.feature_favorite.presentation.vm.FavoriteViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.franzandel.dicodingexpertsubmission.R as AppR

class FavoriteFragment : BaseFragmentVM<FavoriteViewModel, FragmentFavoriteBinding>() {

    @Inject
    lateinit var thread: CoroutineThread

    private val viewModel: FavoriteViewModel by viewModels { viewModelFactory }

    private val adapter =
        FavoriteAdapter { gamesResult ->
            showDeleteConfirmationDialog(gamesResult)
        }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding =
        FragmentFavoriteBinding.inflate(layoutInflater, container, false)

    override fun onFragmentCreated() {
        showBottomNavigation()
        setupAdapter()
        setupListeners()
        setupObservers()
    }

    private fun showBottomNavigation() {
        val bottomNavigation =
            requireActivity().findViewById<BottomNavigationView>(AppR.id.nav_view)
        bottomNavigation.show()
    }

    private fun setupAdapter() {
        viewBinding.rvFavorite.adapter = adapter
    }

    private fun setupListeners() {
        viewBinding.mtbFavorite.setOnMenuItemClickListener { menuItem ->
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
    }

    private fun setupObservers() {
        with(viewLifecycleOwner) {
            lifecycleScope.launch(thread.background()) {
                viewModel.getFavoriteGames().collect {
                    adapter.submitData(it)
                }
            }

            observe(viewModel.deleteGamesResults) { gamesResult ->
                val snackbar = Snackbar.make(
                    requireView(),
                    getString(R.string.favorite_delete_success),
                    Snackbar.LENGTH_LONG
                )
                snackbar.setAction(getString(R.string.favorite_delete_undo)) {
                    viewModel.insertGamesResults(gamesResult)
                }
                snackbar.show()
            }

            observe(viewModel.insertGamesResults) {
                Snackbar.make(
                    requireView(),
                    getString(R.string.favorite_delete_undo_success),
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun showDeleteConfirmationDialog(gamesResult: GamesResultUI) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.favorite_confirmation_delete_title))
            .setMessage(getString(R.string.favorite_confirmation_delete_description))
            .setNegativeButton(getString(R.string.favorite_confirmation_negative_button), null)
            .setPositiveButton(getString(R.string.favorite_confirmation_positive_button)) { _, _ ->
                viewModel.deleteGamesResults(gamesResult)
            }
            .show()
    }


    override fun getVM(): FavoriteViewModel = viewModel

    override fun injectDependencies() {
        DaggerFavoriteComponent.builder()
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
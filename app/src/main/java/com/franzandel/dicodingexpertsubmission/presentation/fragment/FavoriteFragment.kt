package com.franzandel.dicodingexpertsubmission.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.core.extension.observe
import com.franzandel.dicodingexpertsubmission.core.extension.show
import com.franzandel.dicodingexpertsubmission.core.extension.showShareMessage
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseFragmentVM
import com.franzandel.dicodingexpertsubmission.databinding.FragmentFavoriteBinding
import com.franzandel.dicodingexpertsubmission.presentation.adapter.FavoriteAdapter
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import com.franzandel.dicodingexpertsubmission.presentation.vm.FavoriteViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteFragment : BaseFragmentVM<FavoriteViewModel, FragmentFavoriteBinding>() {

    private val viewModel: FavoriteViewModel by viewModels()

    @Inject
    lateinit var thread: CoroutineThread

    private val adapter = FavoriteAdapter { gamesResult ->
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
        val bottomNavigation = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigation.show()
    }

    private fun setupAdapter() {
        viewBinding.rvFavorite.adapter = adapter
    }

    private fun setupListeners() {
        viewBinding.mtbFavorite.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_share -> {
                    requireActivity().showShareMessage()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupObservers() {
        with(viewLifecycleOwner) {
            // TODO: 13/05/21 QUERY IS STILL IN MAIN THREAD
            lifecycleScope.launch(thread.main()) {
                observe(viewModel.getFavoriteGames()) {
                    lifecycleScope.launch(thread.main()) {
                        adapter.submitData(it)
                    }
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
}
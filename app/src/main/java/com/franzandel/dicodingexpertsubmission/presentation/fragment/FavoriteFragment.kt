package com.franzandel.dicodingexpertsubmission.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.core.extension.observe
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseFragmentVM
import com.franzandel.dicodingexpertsubmission.databinding.FragmentFavoriteBinding
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.presentation.adapter.FavoriteAdapter
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import com.franzandel.dicodingexpertsubmission.presentation.vm.FavoriteViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteFragment : BaseFragmentVM<FavoriteViewModel, FragmentFavoriteBinding>() {

    private val viewModel: FavoriteViewModel by viewModels()

    @Inject
    lateinit var thread: CoroutineThread

    @Inject
    lateinit var mapper: BaseMapper<GamesResultRequest, GamesResultUI>

    private val adapter = FavoriteAdapter { gamesResult ->
        showDeleteConfirmationDialog(gamesResult)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding =
        FragmentFavoriteBinding.inflate(layoutInflater, container, false)

    override fun onFragmentCreated() {
        setupAdapter()
        setupObservers()
    }

    private fun setupAdapter() {
        viewBinding.rvBookmarkMovies.adapter = adapter
    }

    private fun setupObservers() = with(viewLifecycleOwner) {
        lifecycleScope.launch(thread.main()) {
            observe(viewModel.getFavoriteGames()) {
                lifecycleScope.launch(thread.main()) {
                    val pagedGamesResultUI = it.map { gamesResultRequest ->
                        mapper.map(gamesResultRequest)
                    }

                    adapter.submitData(pagedGamesResultUI)
                }
            }
        }

//        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
//            viewModel.getFavoriteGames().collectLatest {
//                withContext(Dispatchers.Main) {
//                    adapter.submitData(it)
//                }
//            }
//        }
    }

    private fun showDeleteConfirmationDialog(gamesResult: GamesResultUI) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.favorite_confirmation_delete_title))
            .setMessage(getString(R.string.favorite_confirmation_delete_description))
            .setNegativeButton(getString(R.string.favorite_confirmation_negative_button), null)
            .setPositiveButton(getString(R.string.favorite_confirmation_positive_button)) { _, _ ->
//                deletedBookmarkMovieResponse = bookmarkMovieResponse
//                bookmarkMoviesVM.deleteMovieFromBookmark(bookmarkMovieResponse.id)
                Toast.makeText(requireContext(), "Delete Yes clicked", Toast.LENGTH_SHORT).show()
            }
            .show()
    }


    override fun getVM(): FavoriteViewModel = viewModel
}
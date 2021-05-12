package com.franzandel.dicodingexpertsubmission.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.core.extension.observe
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseFragmentVM
import com.franzandel.dicodingexpertsubmission.databinding.FragmentFavoriteBinding
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.presentation.adapter.FavoriteAdapter
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import com.franzandel.dicodingexpertsubmission.presentation.vm.FavoriteViewModel
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

    private val adapter = FavoriteAdapter()

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


    override fun getVM(): FavoriteViewModel = viewModel
}
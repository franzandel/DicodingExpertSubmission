package com.franzandel.dicodingexpertsubmission.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.extension.hide
import com.franzandel.dicodingexpertsubmission.core.extension.observe
import com.franzandel.dicodingexpertsubmission.core.extension.show
import com.franzandel.dicodingexpertsubmission.core.extension.showShareMessage
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseFragmentVM
import com.franzandel.dicodingexpertsubmission.databinding.FragmentHomeBinding
import com.franzandel.dicodingexpertsubmission.databinding.LayoutErrorBinding
import com.franzandel.dicodingexpertsubmission.presentation.vm.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragmentVM<HomeViewModel, FragmentHomeBinding>() {

    companion object {
        private const val GRID_SPAN_COUNT = 2
    }

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var errorViewBinding: LayoutErrorBinding

//    private val adapter by lazy {
//        MoviesAdapter(requireContext())
//    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun onFragmentCreated() {
        errorViewBinding = viewBinding.layoutError
        showBottomNavigation()
        setupObservers()
        setupListeners()
        viewModel.getAllGames()
    }

    private fun showBottomNavigation() {
        val bottomNavigation = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigation.show()
    }

    private fun setupObservers() {
        viewLifecycleOwner.observe(viewModel.games) {
            viewBinding.layoutError.root.hide()
            viewBinding.ablMovies.show()
            viewBinding.rvMovies.show()
            Toast.makeText(requireContext(), "SHOWN", Toast.LENGTH_SHORT).show()
//            setupRV(movies)
        }

        viewLifecycleOwner.observe(viewModel.gameError) {
            viewBinding.layoutError.root.show()
            viewBinding.ablMovies.hide()
            viewBinding.rvMovies.hide()
        }
    }

//    private fun setupRV(movies: List<Movie>) {
//        viewBinding.rvMovies.layoutManager = GridLayoutManager(
//            requireContext(),
//            GRID_SPAN_COUNT
//        )
//        viewBinding.rvMovies.adapter = adapter
//        adapter.submitList(movies)
//    }

    private fun setupListeners() {
        viewBinding.mtbMovies.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_share -> {
                    requireActivity().showShareMessage()
                    true
                }
                else -> false
            }
        }

        errorViewBinding.btnTryAgain.setOnClickListener {
            viewModel.getAllGames()
        }
    }

    override fun getVM(): HomeViewModel = viewModel
}
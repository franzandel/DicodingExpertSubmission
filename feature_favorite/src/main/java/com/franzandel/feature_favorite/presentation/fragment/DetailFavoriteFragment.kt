package com.franzandel.feature_favorite.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.franzandel.core.extension.hide
import com.franzandel.core.extension.observe
import com.franzandel.core.extension.toMultiLineString
import com.franzandel.core.presentation.fragment.BaseFragmentVM
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.feature_favorite.R
import com.franzandel.feature_favorite.databinding.FragmentDetailFavoriteBinding
import com.franzandel.feature_favorite.di.DaggerFavoriteComponent
import com.franzandel.feature_favorite.presentation.adapter.DetailFavoriteAdapter
import com.franzandel.feature_favorite.presentation.vm.DetailFavoriteViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.EntryPointAccessors
import com.franzandel.dicodingexpertsubmission.R as AppR

class DetailFavoriteFragment :
    BaseFragmentVM<DetailFavoriteViewModel, FragmentDetailFavoriteBinding>() {

    private val viewModel: DetailFavoriteViewModel by viewModels { viewModelFactory }

    private val detailFavoriteFragmentArgs: DetailFavoriteFragmentArgs by navArgs()

    private val gamesResult by lazy {
        detailFavoriteFragmentArgs.gamesResult
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailFavoriteBinding =
        FragmentDetailFavoriteBinding.inflate(layoutInflater, container, false)

    override fun onFragmentCreated() {
        setupUI()
        setupViewPager2()
        setupTabLayout()
        hideBottomNavigation()
        setupObservers()
        setupListeners()
        viewModel.getGamesResults(gamesResult.name)
    }

    private fun setupUI() = with(viewBinding) {
        toolbarDetail.title = gamesResult.name
        tvReleased.text = gamesResult.released
        tvPlatforms.text = gamesResult.platforms.toMultiLineString()
        tvGenres.text = gamesResult.genres.toMultiLineString()
        tvStores.text = gamesResult.stores.toMultiLineString()
        tvTags.text = gamesResult.tags.toMultiLineString()
    }

    private fun setupViewPager2() {
        val adapter = DetailFavoriteAdapter()
        viewBinding.vpDetail.adapter = adapter
        adapter.submitList(gamesResult.shortScreenshots)
    }

    private fun setupTabLayout() {
        // To connect ViewPager2 with TabLayout
        // This is required in release mode otherwise causing crash (NPE: Attempt to invoke interface method...)
        TabLayoutMediator(viewBinding.tlDetail, viewBinding.vpDetail) { _, _ -> }.attach()
        TabLayoutMediator(viewBinding.tlDetail, viewBinding.vpDetail) { _, _ -> }.attach()
    }

    private fun hideBottomNavigation() {
        val bottomNavigation =
            requireActivity().findViewById<BottomNavigationView>(AppR.id.nav_view)
        bottomNavigation.hide()
    }

    private fun setupObservers() {
        viewLifecycleOwner.observe(viewModel.isFavoriteGamesResults) {
            if (it)
                viewBinding.fabBookmark.isSelected = !viewBinding.fabBookmark.isSelected
        }

        viewLifecycleOwner.observe(viewModel.insertGamesResults) {
            val snackbar = Snackbar.make(
                requireView(),
                getString(R.string.detail_favorite_added),
                Snackbar.LENGTH_LONG
            )
            snackbar.setAction(getString(R.string.detail_favorite_added_view)) {
                findNavController().navigate(AppR.id.navigation_favorite)
            }
            snackbar.show()
        }

        viewLifecycleOwner.observe(viewModel.deleteGamesResults) {
            val snackbar = Snackbar.make(
                requireView(),
                getString(R.string.detail_favorite_removed),
                Snackbar.LENGTH_LONG
            )
            snackbar.setAction(getString(R.string.detail_favorite_removed_undo)) {
                viewBinding.fabBookmark.isSelected = !viewBinding.fabBookmark.isSelected
                viewModel.insertGamesResults(gamesResult)
            }
            snackbar.show()
        }
    }

    private fun setupListeners() = with(viewBinding) {
        toolbarDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        fabBookmark.setOnClickListener {
            fabBookmark.isSelected = !fabBookmark.isSelected

            if (fabBookmark.isSelected)
                viewModel.insertGamesResults(gamesResult)
            else
                viewModel.deleteGamesResults(gamesResult)
        }
    }

    override fun getVM(): DetailFavoriteViewModel = viewModel

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
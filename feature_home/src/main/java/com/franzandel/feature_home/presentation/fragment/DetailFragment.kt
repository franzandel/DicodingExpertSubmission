package com.franzandel.feature_home.presentation.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.franzandel.core.extension.hide
import com.franzandel.core.extension.observe
import com.franzandel.core.extension.toMultiLineString
import com.franzandel.core.presentation.BaseFragmentVM
import com.franzandel.dicodingexpertsubmission.databinding.FragmentDetailBinding
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.dicodingexpertsubmission.presentation.vm.ViewModelFactory
import com.franzandel.feature_home.di.DaggerHomeComponent
import com.franzandel.feature_home.presentation.adapter.DetailAdapter
import com.franzandel.feature_home.presentation.vm.DetailViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject
import com.franzandel.dicodingexpertsubmission.R as AppR

class DetailFragment : BaseFragmentVM<DetailViewModel, FragmentDetailBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: DetailViewModel by viewModels { viewModelFactory }

    private val detailFragmentArgs: DetailFragmentArgs by navArgs()

    private val gamesResult by lazy {
        detailFragmentArgs.gamesResult
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)

    override fun onAttach(context: Context) {
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
        super.onAttach(context)
    }

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
        val adapter = DetailAdapter()
        viewBinding.vpDetail.adapter = adapter
        adapter.submitList(gamesResult.shortScreenshots)
    }

    private fun setupTabLayout() {
        // To connect ViewPager2 with TabLayout
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
                getString(AppR.string.detail_favorite_added),
                Snackbar.LENGTH_LONG
            )
            snackbar.setAction(getString(AppR.string.detail_favorite_added_view)) {
                findNavController().navigate(AppR.id.navigation_favorite)
            }
            snackbar.show()
        }

        viewLifecycleOwner.observe(viewModel.deleteGamesResults) {
            val snackbar = Snackbar.make(
                requireView(),
                getString(AppR.string.detail_favorite_removed),
                Snackbar.LENGTH_LONG
            )
            snackbar.setAction(getString(AppR.string.detail_favorite_removed_undo)) {
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

    override fun getVM(): DetailViewModel = viewModel
}
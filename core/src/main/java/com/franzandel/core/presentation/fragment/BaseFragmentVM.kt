package com.franzandel.core.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.franzandel.core.extension.observe
import com.franzandel.core.presentation.dialogfragment.LoadingDialog
import com.franzandel.core.presentation.vm.BaseViewModel
import com.franzandel.core.presentation.vm.ViewModelFactory
import javax.inject.Inject

/**
 * Created by Franz Andel on 14/05/21.
 * Android Engineer
 */

abstract class BaseFragmentVM<VM : ViewModel, VB : ViewBinding> : BaseFragment<VB>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected val loadingDialog = LoadingDialog.newInstance()

    abstract fun getVM(): VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupObserver(getVM() as BaseViewModel)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupObserver(viewModel: BaseViewModel) {
        viewLifecycleOwner.observe(viewModel.loadingResult) {
            if (it)
                loadingDialog.show(requireActivity().supportFragmentManager)
            else
                loadingDialog.hide()
        }
    }
}
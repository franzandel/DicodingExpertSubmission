package com.franzandel.dicodingexpertsubmission.core.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.franzandel.dicodingexpertsubmission.core.extension.observe
import com.franzandel.dicodingexpertsubmission.presentation.dialogfragment.LoadingDialog

/**
 * Created by Franz Andel on 14/03/21.
 * Android Engineer
 */

abstract class BaseFragmentVM<VM : ViewModel, VB : ViewBinding> : BaseFragment<VB>() {

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
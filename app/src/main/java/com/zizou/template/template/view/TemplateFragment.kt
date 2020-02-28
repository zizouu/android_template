package com.zizou.template.template.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.zizou.template.R
import com.zizou.template.common.view.BaseFragment
import com.zizou.template.common.viewmodel.BaseViewModel
import com.zizou.template.template.viewmodel.TemplateViewModel
import com.zizou.template.template.viewmodel.TemplateViewModelFactory
import javax.inject.Inject

class TemplateFragment : BaseFragment() {
    companion object {
        const val TAG = "TamplateFragment"
    }

    @Inject
    lateinit var viewModelFactory: TemplateViewModelFactory
    private lateinit var viewModel: TemplateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[TemplateViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_template, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUi()
        subscribeUi()
        subscribeViewModel(viewModel)
    }

    override fun initializeUi() {
        super.initializeUi()
    }

    override fun subscribeUi() {
        super.subscribeUi()
    }

    override fun subscribeViewModel(baseViewModel: BaseViewModel) {
        super.subscribeViewModel(baseViewModel)

        disposables.add(
            viewModel.template
                .subscribe({
                    // do something
                }) {
                    viewModel.error.onNext("${it.message}")
                }
        )

        disposables.add(
            viewModel.saveSuccess
                .subscribe({
                    // do something
                }) {
                    viewModel.error.onNext("${it.message}")
                }
        )
    }
}
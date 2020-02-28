package com.zizou.template.motion.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.zizou.template.R
import com.zizou.template.common.viewmodel.BaseViewModel
import com.zizou.template.main.view.MainBaseFragment
import com.zizou.template.motion.viewmodel.MotionViewModel
import com.zizou.template.motion.viewmodel.MotionViewModelFactory
import javax.inject.Inject

class MotionFragment : MainBaseFragment() {
    companion object {
        const val TAG = "MotionFragment"
    }

    @Inject
    lateinit var viewModelFactory: MotionViewModelFactory
    private lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[MotionViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_motion, container, false)
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
    }
}
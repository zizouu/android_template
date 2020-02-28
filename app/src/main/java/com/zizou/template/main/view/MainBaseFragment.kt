package com.zizou.template.main.view

import android.content.Context
import com.zizou.template.common.view.BaseFragment
import com.zizou.template.main.view.listener.OnRequestView

open class MainBaseFragment : BaseFragment() {
    var onRequestViewListener: OnRequestView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            onRequestViewListener = context
        }
    }
}
package com.zizou.template.motion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MotionViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECED_CAST")
        return MotionViewModel() as T
    }
}
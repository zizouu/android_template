package com.zizou.template.common.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.subjects.PublishSubject

open class BaseViewModel : ViewModel() {
    val message = PublishSubject.create<String>()
    val error = PublishSubject.create<String>()

}
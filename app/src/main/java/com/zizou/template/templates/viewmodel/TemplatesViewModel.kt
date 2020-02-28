package com.zizou.template.templates.viewmodel

import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.zizou.template.common.viewmodel.BaseViewModel
import com.zizou.template.template.model.TemplateModel
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

class TemplatesViewModel(

) : BaseViewModel() {
    val templates = PublishSubject.create<List<TemplateModel>>()

    fun getTemplates() {
        val templates = listOf(
            TemplateModel(title = "타이틀1", index = 1),
            TemplateModel(title = "타이틀2", index = 2),
            TemplateModel(title = "타이틀3", index = 3)
        )

        this.templates.onNext(templates)
    }

}
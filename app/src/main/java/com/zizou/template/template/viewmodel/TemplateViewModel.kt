package com.zizou.template.template.viewmodel

import com.zizou.template.common.model.RepositoryResult
import com.zizou.template.common.viewmodel.BaseViewModel
import com.zizou.template.template.model.TemplateModel
import com.zizou.template.template.repository.TemplateRepository
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

class TemplateViewModel(
    val templateRepository: TemplateRepository
) : BaseViewModel() {
    val saveSuccess = PublishSubject.create<Boolean>()
    val modifySuccess = PublishSubject.create<Boolean>()
    val deleteSuccess = PublishSubject.create<Boolean>()
    val template = BehaviorSubject.create<TemplateModel>()

    fun saveTemplate(templateModel: TemplateModel) =
        templateRepository.saveTemplate(templateModel)
            .subscribeOn(Schedulers.io())
            .subscribe({
                when (it.resultCode) {
                    RepositoryResult.RESULT_SUCCESS -> saveSuccess.onNext(true)
                    else -> saveSuccess.onNext(false)
                }
            }) {
                error.onNext("${it.message}")
            }

    fun modifyTemplate(templateModel: TemplateModel) =
        templateRepository.updateTemplate(templateModel)
            .subscribeOn(Schedulers.io())
            .subscribe({
                when (it.resultCode) {
                    RepositoryResult.RESULT_SUCCESS -> modifySuccess.onNext(true)
                    else -> modifySuccess.onNext(false)
                }
            }) {
                error.onNext("${it.message}")
            }

    fun getTemplate(index: Int) =
        templateRepository.getTemplate(index)
            .subscribeOn(Schedulers.io())
            .subscribe({
                when (it.resultCode) {
                    RepositoryResult.RESULT_SUCCESS -> template.onNext(it.resultData!!)
                    else -> error.onNext("get result fail..")
                }
            }) {
                error.onNext("${it.message}")
            }

    fun deleteTemplate(index: Int) =
        templateRepository.deleteTemplate(index)
            .subscribeOn(Schedulers.io())
            .subscribe({
                when (it.resultCode) {
                    RepositoryResult.RESULT_SUCCESS -> deleteSuccess.onNext(true)
                    else -> deleteSuccess.onNext(false)
                }
            }) {
                error.onNext("${it.message}")
            }
}
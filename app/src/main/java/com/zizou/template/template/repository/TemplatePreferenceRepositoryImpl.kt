package com.zizou.template.template.repository

import com.zizou.template.common.model.RepositoryResult
import com.zizou.template.common.preference.TemplateSharedPreference
import com.zizou.template.template.model.TemplateModel
import io.reactivex.Flowable

class TemplatePreferenceRepositoryImpl(
    val preference: TemplateSharedPreference
) : TemplateRepository {
    override fun saveTemplate(template: TemplateModel): Flowable<RepositoryResult<Any>> {
        return Flowable.fromCallable { preference.updateTemplateModel(template) }
            .map {
                RepositoryResult<Any>().apply {
                    resultCode = RepositoryResult.RESULT_SUCCESS
                }
            }
    }

    override fun updateTemplate(template: TemplateModel): Flowable<RepositoryResult<Any>> {
        return Flowable.fromCallable { preference.updateTemplateModel(template) }
            .map {
                RepositoryResult<Any>().apply {
                    resultCode = RepositoryResult.RESULT_SUCCESS
                }
            }
    }

    // share preference 에 리스트 형식으로 저장하지 않는다. 단일 데이터/객체 저장 용도
    // 그래서 index 를 사용하지 않음 (다수 데이터 저장 필요시 room 사용)
    override fun getTemplate(index: Int): Flowable<RepositoryResult<TemplateModel>> {
        return Flowable.fromCallable { preference.templateModel }
            .map {
                RepositoryResult<TemplateModel>().apply {
                    resultCode = RepositoryResult.RESULT_SUCCESS
                    resultData = it
                }
            }
    }

    // share preference 에 리스트 형식으로 저장하지 않는다. 단일 데이터/객체 저장 용도
    // 그래서 index 를 사용하지 않음 (다수 데이터 저장 필요시 room 사용)
    override fun deleteTemplate(index: Int): Flowable<RepositoryResult<Any>> {
        return Flowable.fromCallable { preference.removeTemplateModel() }
            .map {
                RepositoryResult<Any>().apply {
                    resultCode = RepositoryResult.RESULT_SUCCESS
                }
            }
    }
}
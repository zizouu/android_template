package com.zizou.template.template.repository

import com.zizou.template.common.model.RepositoryResult
import com.zizou.template.template.api.TemplateApi
import com.zizou.template.template.model.TemplateModel
import io.reactivex.Flowable

class TemplateHttpRepositoryImpl(
    val templateApi: TemplateApi
) : TemplateRepository {
    override fun saveTemplate(template: TemplateModel): Flowable<RepositoryResult<Any>> {
        return templateApi.postTemplate(template)
    }

    override fun updateTemplate(template: TemplateModel): Flowable<RepositoryResult<Any>> {
        return templateApi.putTemplate(template)
    }

    override fun getTemplate(index: Int): Flowable<RepositoryResult<TemplateModel>> {
        return templateApi.getTemplate(index)
    }

    override fun deleteTemplate(index: Int): Flowable<RepositoryResult<Any>> {
        return templateApi.deleteTemplate(index)
    }
}
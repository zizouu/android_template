package com.zizou.template.template.repository

import com.zizou.template.common.model.RepositoryResult
import com.zizou.template.template.model.TemplateModel
import io.reactivex.Flowable

interface TemplateRepository {
    fun saveTemplate(template: TemplateModel): Flowable<RepositoryResult<Any>>
    fun updateTemplate(template: TemplateModel): Flowable<RepositoryResult<Any>>
    fun getTemplate(index: Int): Flowable<RepositoryResult<TemplateModel>>
    fun deleteTemplate(index: Int): Flowable<RepositoryResult<Any>>
}
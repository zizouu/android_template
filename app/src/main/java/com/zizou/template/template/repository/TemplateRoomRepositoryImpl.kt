package com.zizou.template.template.repository

import com.zizou.template.common.model.RepositoryResult
import com.zizou.template.template.model.TemplateModel
import com.zizou.template.template.dao.TemplateModelDao
import io.reactivex.Flowable

class TemplateRoomRepositoryImpl(
    val templateRoomRepositoryDao: TemplateModelDao
) : TemplateRepository {
    override fun saveTemplate(template: TemplateModel): Flowable<RepositoryResult<Any>> {
        return templateRoomRepositoryDao.insertOne(template)
            .toFlowable()
            .map {
                RepositoryResult<Any>().apply {
                    resultCode = RepositoryResult.RESULT_SUCCESS
                }
            }
    }

    override fun updateTemplate(template: TemplateModel): Flowable<RepositoryResult<Any>> {
        return templateRoomRepositoryDao.updateOne(template)
            .toFlowable()
            .map {
                RepositoryResult<Any>().apply {
                    resultCode = RepositoryResult.RESULT_SUCCESS
                }
            }
    }

    override fun getTemplate(index: Int): Flowable<RepositoryResult<TemplateModel>> {
        return templateRoomRepositoryDao.findByIndex(index)
            .map {
                RepositoryResult<TemplateModel>().apply {
                    resultCode = RepositoryResult.RESULT_SUCCESS
                    resultData = it
                }
            }
    }

    override fun deleteTemplate(index: Int): Flowable<RepositoryResult<Any>> {
        return templateRoomRepositoryDao.findByIndex(index)
            .map { templateRoomRepositoryDao.deleteOne(it) }
            .map {
                RepositoryResult<Any>().apply {
                    resultCode = RepositoryResult.RESULT_SUCCESS
                }
            }
    }
}
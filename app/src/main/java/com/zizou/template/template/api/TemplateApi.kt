package com.zizou.template.template.api

import com.zizou.template.common.model.RepositoryResult
import com.zizou.template.template.model.TemplateModel
import io.reactivex.Flowable
import retrofit2.http.*

interface TemplateApi {
    @GET("template/{index}")
    fun getTemplate(@Path("index") index: Int): Flowable<RepositoryResult<TemplateModel>>

    @POST("template")
    fun postTemplate(@Body template: TemplateModel): Flowable<RepositoryResult<Any>>

    @PUT("template")
    fun putTemplate(@Body template: TemplateModel): Flowable<RepositoryResult<Any>>

    @DELETE("template/{index}")
    fun deleteTemplate(@Path("index") index: Int): Flowable<RepositoryResult<Any>>

}
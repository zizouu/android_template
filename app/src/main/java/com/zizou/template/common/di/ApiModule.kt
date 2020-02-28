package com.zizou.template.common.di

import com.zizou.template.template.api.TemplateApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideTemplateApi(@Named("nif") retrofit: Retrofit): TemplateApi = retrofit.create(
        TemplateApi::class.java)
}
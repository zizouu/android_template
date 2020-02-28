package com.zizou.template.common.di

import com.zizou.template.common.preference.TemplateSharedPreference
import com.zizou.template.template.api.TemplateApi
import com.zizou.template.template.dao.TemplateModelDao
import com.zizou.template.template.repository.TemplateHttpRepositoryImpl
import com.zizou.template.template.repository.TemplatePreferenceRepositoryImpl
import com.zizou.template.template.repository.TemplateRepository
import com.zizou.template.template.repository.TemplateRoomRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    @Named("roomRepository")
    fun provideTemplateRoomRepository(templateModelDao: TemplateModelDao): TemplateRepository =
        TemplateRoomRepositoryImpl(templateModelDao)

    @Provides
    @Singleton
    @Named("httpRepository")
    fun provideTemplateHttpRepository(templateApi: TemplateApi): TemplateRepository =
        TemplateHttpRepositoryImpl(templateApi)

    @Provides
    @Singleton
    @Named("preferenceRepository")
    fun provideTemplatePreferenceRepository(preference: TemplateSharedPreference): TemplateRepository =
        TemplatePreferenceRepositoryImpl(preference)
}
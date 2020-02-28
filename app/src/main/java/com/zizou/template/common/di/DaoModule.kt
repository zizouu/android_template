package com.zizou.template.common.di

import com.zizou.template.common.database.AppDatabase
import com.zizou.template.template.dao.TemplateModelDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {
    @Provides
    @Singleton
    fun provideTemplateDao(dataBase: AppDatabase): TemplateModelDao =
        dataBase.templateModelDao()
}
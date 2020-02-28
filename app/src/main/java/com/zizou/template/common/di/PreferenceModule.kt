package com.zizou.template.common.di

import android.content.Context
import com.zizou.template.common.preference.TemplateSharedPreference
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class PreferenceModule {
    @Provides
    @Singleton
    fun provideTemplatePreference(@Named("appContext") context: Context) : TemplateSharedPreference =
        TemplateSharedPreference(context)
}
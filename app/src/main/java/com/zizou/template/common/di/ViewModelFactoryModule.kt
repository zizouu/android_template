package com.zizou.template.common.di

import com.zizou.template.main.viewmodel.MainViewModelFactory
import com.zizou.template.motion.viewmodel.MotionViewModelFactory
import com.zizou.template.template.repository.TemplateRepository
import com.zizou.template.template.viewmodel.TemplateViewModelFactory
import com.zizou.template.templates.viewmodel.TemplatesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ViewModelFactoryModule {
    @Provides
    fun provideMainViewModelFactory(

    ): MainViewModelFactory =
        MainViewModelFactory()

    @Provides
    fun provideTemplateViewModelFactory(
        @Named("roomRepository") templateRepository: TemplateRepository
    ): TemplateViewModelFactory =
        TemplateViewModelFactory(templateRepository)

    @Provides
    fun provideTemplatesViewModelFactory(

    ): TemplatesViewModelFactory =
        TemplatesViewModelFactory()

    @Provides
    fun provideMotionViewModelFactory(

    ): MotionViewModelFactory =
        MotionViewModelFactory()
}
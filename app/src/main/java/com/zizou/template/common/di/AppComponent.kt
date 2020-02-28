package com.zizou.template.common.di

import android.app.Application
import com.zizou.template.TemplateApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewBinderModule::class,
        ViewModelFactoryModule::class,
        RepositoryModule::class,
        DatabaseModule::class,
        NetworkModule::class,
        PreferenceModule::class,
        ApiModule::class,
        DaoModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<TemplateApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}
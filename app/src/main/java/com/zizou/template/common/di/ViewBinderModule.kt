package com.zizou.template.common.di

import com.zizou.template.launch.LaunchActivity
import com.zizou.template.launch.SplashActivity
import com.zizou.template.main.view.MainActivity
import com.zizou.template.template.view.TemplateFragment
import com.zizou.template.templates.view.TemplatesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBinderModule {
    @ContributesAndroidInjector
    abstract fun bindLaunchActivity(): LaunchActivity

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindTemplateFragment(): TemplateFragment

    @ContributesAndroidInjector
    abstract fun bindTemplatesFragment(): TemplatesFragment
}
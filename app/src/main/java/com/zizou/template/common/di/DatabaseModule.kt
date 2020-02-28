package com.zizou.template.common.di

import android.content.Context
import androidx.room.Room
import com.zizou.template.R
import com.zizou.template.common.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@Named("appContext") context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            context.getString(R.string.database_name)
        ).build()
}
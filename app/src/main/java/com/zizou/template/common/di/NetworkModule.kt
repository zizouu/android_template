package com.zizou.template.common.di

import com.zizou.template.common.network.AuthInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Named("nif")
    @Singleton
    fun provideNifOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

    @Provides
    @Named("oif")
    @Singleton
    fun provideOifOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideLogginInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

    /*@Provides
    @Singleton
    fun provideAuthInterceptor(preference: LuckyInsideSharedPreference): AuthInterceptor {
        return AuthInterceptor(preference.accessToken)
    }*/

    @Provides
    @Named("nif")
    @Singleton
    fun provideNifRetrofit(
        @Named("nif") okHttpClient: OkHttpClient,
        callAdapter: CallAdapter.Factory,
        converter: Converter.Factory
    ) : Retrofit =
        Retrofit.Builder()
            .baseUrl("base url")
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converter)
            .build()

    @Provides
    @Named("oif")
    @Singleton
    fun provideOifRetrofit(
        @Named("oif") okHttpClient: OkHttpClient,
        callAdapter: CallAdapter.Factory,
        converter: Converter.Factory
    ) : Retrofit =
        Retrofit.Builder()
            .baseUrl("base url")
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converter)
            .build()

    @Provides
    @Singleton
    fun provideCallAdapterFactory() : CallAdapter.Factory = RxJava2CallAdapterFactory.createAsync()

    @Provides
    @Singleton
    fun provideConverterFactory() : Converter.Factory = GsonConverterFactory.create()
}
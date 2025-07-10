package com.top.sample.di

import com.top.sample.domain.AccountRestService
import com.top.sample.domain.BaseApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier


@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule {

    @LoggingInterceptorOkHttpClient
    @Provides
    fun provideOkhttpClient(): OkHttpClient = OkHttpClient().newBuilder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()


    @Provides
    fun provideAccountRestService(@LoggingInterceptorOkHttpClient okHttpClient: OkHttpClient): AccountRestService =
        Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(BaseApi.OFFICIAL_HOST)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AccountRestService::class.java)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoggingInterceptorOkHttpClient
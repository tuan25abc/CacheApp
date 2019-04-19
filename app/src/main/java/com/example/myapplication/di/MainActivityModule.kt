package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.gateway.CacheGateway
import com.example.myapplication.gateway.FileCacheGateway
import com.example.myapplication.helper.Constant.BASE_URL
import com.example.myapplication.helper.CustomTypeAdapterFactory
import com.example.myapplication.service.APIService
import com.example.myapplication.ui.main.MainActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class MainActivityModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideDisposable(): CompositeDisposable = CompositeDisposable()

        @JvmStatic
        @Provides
        fun provideAPIService(): APIService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().registerTypeAdapterFactory(
                        CustomTypeAdapterFactory()
                    ).create()
                )
            )
            .build().create(APIService::class.java)

        @JvmStatic
        @Provides
        fun provideCacheGateway(cacheGateway: FileCacheGateway): CacheGateway {
            return cacheGateway
        }

        @JvmStatic
        @Provides
        fun provideContext(activity: MainActivity): Context = activity

        @JvmStatic
        @Provides
        fun provideGson(): Gson = Gson()
    }
}
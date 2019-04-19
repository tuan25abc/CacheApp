package com.example.myapplication.di

import com.example.myapplication.helper.Constant.BASE_URL
import com.example.myapplication.helper.CustomTypeAdapterFactory
import com.example.myapplication.service.APIService
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
    }
}
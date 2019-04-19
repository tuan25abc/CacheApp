package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.gateway.CacheGateway
import com.example.myapplication.gateway.DatabaseCacheGateway
import com.example.myapplication.gateway.FileCacheGateway
import com.example.myapplication.helper.Constant.BASE_URL
import com.example.myapplication.helper.CustomTypeAdapterFactory
import com.example.myapplication.model.AppDatabase
import com.example.myapplication.service.APIService
import com.example.myapplication.ui.main.MainActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun provideCacheGateway(cacheGateway: DatabaseCacheGateway): CacheGateway

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
        fun provideContext(activity: MainActivity): Context = activity

        @JvmStatic
        @Provides
        fun provideGson(): Gson = Gson()

        @JvmStatic
        @Provides
        fun provideDatabase(activity: MainActivity): AppDatabase {
            return Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "app-db").allowMainThreadQueries().build()
        }

        @JvmStatic
        @Provides
        fun providesToDoDao(database: AppDatabase) = database.repoCacheEntityDao()
    }
}
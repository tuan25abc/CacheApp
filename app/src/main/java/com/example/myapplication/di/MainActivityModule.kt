package com.example.myapplication.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
abstract class MainActivityModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideDisposable(): CompositeDisposable = CompositeDisposable()
    }
}
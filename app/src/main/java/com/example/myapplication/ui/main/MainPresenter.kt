package com.example.myapplication.ui.main

import com.example.myapplication.model.Repo
import com.example.myapplication.service.APIService
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainPresenter @Inject constructor() : MainContract.Presenter() {
    override fun getListRepo(user: String): Single<List<Repo>> {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIService::class.java)
            .listRepos(user)
    }
}
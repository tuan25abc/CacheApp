package com.example.myapplication.service

import com.example.myapplication.model.Repo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Single<List<Repo>>
}
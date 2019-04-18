package com.example.myapplication.gateway

import com.example.myapplication.model.Repo
import com.example.myapplication.service.APIService
import io.reactivex.Single
import javax.inject.Inject

class APIGateway @Inject constructor(
    private val apiService: APIService
) {
    fun getListRepo(user: String): Single<List<Repo>> {
        return apiService.listRepos(user)
    }
}
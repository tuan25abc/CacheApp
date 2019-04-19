package com.example.myapplication.repository

import com.example.myapplication.gateway.APIGateway
import com.example.myapplication.gateway.CacheGateway
import com.example.myapplication.model.Repo
import com.google.gson.JsonElement
import io.reactivex.Single
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiGateway: APIGateway,
    private val cacheGateway: CacheGateway
) {
    fun getListRepo(user: String): Single<List<Repo>> {
        return apiGateway.getListRepo(user)
            .doOnSuccess {
                cacheGateway.put(user, it)
            }
            .onErrorResumeNext {
                Single.just(cacheGateway.get(user))
            }
    }

    fun getJsonRepo(user: String): Single<JsonElement> {
        return apiGateway.getJsonRepo(user)
    }
}
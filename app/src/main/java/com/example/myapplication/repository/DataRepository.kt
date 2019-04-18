package com.example.myapplication.repository

import com.example.myapplication.gateway.APIGateway
import com.example.myapplication.gateway.MemoryCacheGateway
import com.example.myapplication.model.Repo
import com.google.gson.JsonElement
import io.reactivex.Single
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiGateway: APIGateway,
    private val memoryCacheGateway: MemoryCacheGateway
) {
    fun getListRepo(user: String): Single<List<Repo>> {
        return apiGateway.getListRepo(user)
            .doOnSuccess {
                memoryCacheGateway.put(user, it)
            }
            .onErrorResumeNext {
                val cacheResult = memoryCacheGateway.get(user)
                Single.just(cacheResult)
            }
    }

    fun getJsonRepo(user: String): Single<JsonElement> {
        return apiGateway.getJsonRepo(user)
    }
}
package com.example.myapplication.repository

import android.util.Log
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
        val start = System.currentTimeMillis()
        Log.e("tuan", "user=$user, startTime=$start")
        return apiGateway.getListRepo(user)
            .doOnSuccess {
                cacheGateway.put(user, it)
            }
            .onErrorResumeNext {
                val end = System.currentTimeMillis()
                Log.e("tuan", "user=$user, endTimeee=$end")
                Log.e("tuan", "user=$user, value=${end-start}")
                Single.just(cacheGateway.get(user))
            }
    }

    fun getJsonRepo(user: String): Single<JsonElement> {
        return apiGateway.getJsonRepo(user)
    }
}
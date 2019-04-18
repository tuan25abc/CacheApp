package com.example.myapplication.repository

import com.example.myapplication.gateway.APIGateway
import com.example.myapplication.model.Repo
import io.reactivex.Single
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiGateway: APIGateway
) {
    fun getListRepo(user: String): Single<List<Repo>> {
        return apiGateway.getListRepo(user)
            .onErrorResumeNext {
                Single.just(ArrayList<Repo>().apply {
                    add(Repo(1, "1", "123"))
                })
            }
    }
}
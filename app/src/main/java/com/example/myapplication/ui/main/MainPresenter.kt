package com.example.myapplication.ui.main

import com.example.myapplication.model.Repo
import com.example.myapplication.repository.DataRepository
import io.reactivex.Single
import javax.inject.Inject

class MainPresenter
@Inject constructor(
    private val dataRepository: DataRepository
) : MainContract.Presenter() {
    override fun getListRepo(user: String): Single<List<Repo>> {
        return dataRepository.getListRepo(user)
    }
}
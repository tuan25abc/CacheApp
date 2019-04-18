package com.example.myapplication.ui.main

import com.example.myapplication.model.Repo
import com.example.myapplication.ui.base.BasePresenter
import com.example.myapplication.ui.base.BaseView
import io.reactivex.Single

class MainContract {
    interface View : BaseView

    abstract class Presenter : BasePresenter() {
        abstract fun getListRepo(user: String): Single<List<Repo>>
    }
}
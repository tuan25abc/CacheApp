package com.example.myapplication.ui.base

abstract class BasePresenter {
    private var view: BaseView? = null
    fun attachView(view: BaseView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }
}
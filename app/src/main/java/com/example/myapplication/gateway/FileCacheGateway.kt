package com.example.myapplication.gateway

import com.example.myapplication.helper.FileHelper
import com.example.myapplication.model.Repo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class FileCacheGateway @Inject constructor(
    private val fileHelper: FileHelper,
    private val gson: Gson
) : CacheGateway {
    override fun get(key: String): List<Repo> {
        val data = fileHelper.getDataFromFile(key)
        return if (data.isEmpty()) {
            arrayListOf(Repo(1, name = "file dummy"))
        } else {
            val listType = object : TypeToken<List<Repo>>() {}.type
            val result: List<Repo> = gson.fromJson(data, listType)
            result[0].name = "file cache"
            result
        }
    }

    override fun put(key: String, value: List<Repo>) {
        fileHelper.putDataToFile(key, gson.toJson(value).toString())
    }
}
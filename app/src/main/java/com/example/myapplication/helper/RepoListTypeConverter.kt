package com.example.myapplication.helper

import androidx.room.TypeConverter
import com.example.myapplication.model.Repo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object RepoListTypeConverter {
    @TypeConverter
    @JvmStatic
    fun fromString(value: String): List<Repo> {
        val listType = object : TypeToken<List<Repo>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromList(list: List<Repo>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
package com.example.myapplication.helper

import androidx.room.TypeConverter
import com.example.myapplication.model.Owner
import com.google.gson.Gson

object OwnerTypeConverter {
    @TypeConverter
    @JvmStatic
    fun fromString(value: String): Owner {
        return Gson().fromJson(value, Owner::class.java)
    }

    @TypeConverter
    @JvmStatic
    fun fromList(value: Owner): String {
        return Gson().toJson(value)
    }
}
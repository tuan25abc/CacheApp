package com.example.myapplication.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.helper.OwnerTypeConverter
import com.example.myapplication.helper.RepoListTypeConverter
import com.example.myapplication.model.dao.RepoCacheEntityDAO


@Database(entities = [RepoCacheEntity::class], version = 1, exportSchema = false)
@TypeConverters(value = [RepoListTypeConverter::class, OwnerTypeConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoCacheEntityDao(): RepoCacheEntityDAO
}
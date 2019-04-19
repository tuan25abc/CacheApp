package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repo_cache_entity")
data class RepoCacheEntity (
    @PrimaryKey
    @ColumnInfo(name = "cache_key")
    var key: String = "",

    @ColumnInfo(name = "cache_value")
    var value: List<Repo> = emptyList()
)
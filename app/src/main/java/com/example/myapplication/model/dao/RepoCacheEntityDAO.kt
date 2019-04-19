package com.example.myapplication.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.myapplication.model.RepoCacheEntity

@Dao
interface RepoCacheEntityDAO {
    @Query("SELECT * FROM repo_cache_entity WHERE cache_key = :key")
    fun getRepoListByKey(key: String): RepoCacheEntity?

    @Insert(onConflict = REPLACE)
    fun insertRepoCacheEntity(repoCacheEntity: RepoCacheEntity)
}
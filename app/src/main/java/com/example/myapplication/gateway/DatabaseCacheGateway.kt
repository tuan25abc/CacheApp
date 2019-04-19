package com.example.myapplication.gateway

import com.example.myapplication.model.Repo
import com.example.myapplication.model.RepoCacheEntity
import com.example.myapplication.model.dao.RepoCacheEntityDAO
import javax.inject.Inject

class DatabaseCacheGateway @Inject constructor(
    private val repoCacheEntityDAO: RepoCacheEntityDAO
) : CacheGateway {
    override fun get(key: String): List<Repo> {
        val entity = repoCacheEntityDAO.getRepoListByKey(key)
        return if (entity == null || entity.value.isEmpty()) {
            arrayListOf(Repo(1, name = "database dummy"))
        } else {
            entity.value[0].name = "database cache"
            entity.value
        }
    }

    override fun put(key: String, value: List<Repo>) {
        repoCacheEntityDAO.insertRepoCacheEntity(RepoCacheEntity(key, value))
    }
}
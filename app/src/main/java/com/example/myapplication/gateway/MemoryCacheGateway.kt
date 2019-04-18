package com.example.myapplication.gateway

import com.example.myapplication.model.Repo
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

class MemoryCacheGateway @Inject constructor() : CacheGateway {

    private val cache: ConcurrentHashMap<String, List<Repo>> by lazy {
        ConcurrentHashMap<String, List<Repo>>()
    }

    override fun get(key: String): List<Repo> {
        val result = cache[key]
        result?.get(0)?.name = "cache"
        return result ?: arrayListOf(Repo(1, name = "dummy"))
    }

    override fun put(key: String, value: List<Repo>) {
        cache[key] = value
    }
}
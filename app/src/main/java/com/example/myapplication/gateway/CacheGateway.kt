package com.example.myapplication.gateway

import com.example.myapplication.model.Repo

interface CacheGateway {
    fun get(key: String): List<Repo>
    fun put(key: String, value: List<Repo>)
}
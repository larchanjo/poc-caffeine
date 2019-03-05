package com.example.poccaffeine

import com.github.benmanes.caffeine.cache.Caffeine
import java.util.concurrent.TimeUnit

class LoadingCache {

    private val loadingCache = Caffeine.newBuilder()
            .expireAfterWrite(1, TimeUnit.SECONDS)
            .maximumSize(5)
            .build<String, String> { createValue(it) }

    private fun createValue(key: String) = key

    fun putToCache(key: String, value: String) = loadingCache.put(key, value)

    fun get(key: String) = loadingCache.get(key)

    fun invalidate(key: String) = loadingCache.invalidate(key)

}
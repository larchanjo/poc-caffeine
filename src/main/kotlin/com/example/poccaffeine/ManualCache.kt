package com.example.poccaffeine

import com.github.benmanes.caffeine.cache.Caffeine
import java.util.concurrent.TimeUnit

class ManualCache {

    private val manualCache = Caffeine.newBuilder()
            .expireAfterWrite(1, TimeUnit.SECONDS)
            .maximumSize(10)
            .build<String, String>()

    fun putToCache(key: String, value: String) = manualCache.put(key, value)

    fun get(key: String) = manualCache.getIfPresent(key)

    fun invalidate(key: String) = manualCache.invalidate(key)

}
package com.example.poccaffeine

import org.junit.Assert
import org.junit.Test
import java.util.*
import java.util.concurrent.TimeUnit

class LoadingCacheTest {

    private val key = UUID.randomUUID().toString()
    private val value = UUID.randomUUID().toString()
    private val loadingCache = LoadingCache()

    @Test
    fun testePutAndGet() {
        loadingCache.putToCache(key, value)
        val valueFromCache = loadingCache.get(key)
        Assert.assertEquals(value, valueFromCache)
    }

    @Test
    fun testExpire() {
        loadingCache.putToCache(key, value)
        val valueFromCache = loadingCache.get(key)
        Assert.assertEquals(value, valueFromCache)
        TimeUnit.SECONDS.sleep(2)
        Assert.assertNotNull(loadingCache.get(key))
        Assert.assertEquals(key, loadingCache.get(key))
    }

    @Test
    fun testInvalidate() {
        loadingCache.putToCache(key, value)
        val valueFromCache = loadingCache.get(key)
        Assert.assertEquals(value, valueFromCache)
        loadingCache.invalidate(key)
        Assert.assertNotNull(loadingCache.get(key))
        Assert.assertEquals(key, loadingCache.get(key))
    }

}
package com.example.poccaffeine

import org.junit.Assert
import org.junit.Test
import java.util.*
import java.util.concurrent.TimeUnit

class ManualCacheTest {

    private val key = UUID.randomUUID().toString()
    private val value = UUID.randomUUID().toString()
    private val manualCache = ManualCache()

    @Test
    fun testePutAndGet() {
        manualCache.putToCache(key, value)
        val valueFromCache = manualCache.get(key)
        Assert.assertEquals(value, valueFromCache)
    }

    @Test
    fun testExpire() {
        manualCache.putToCache(key, value)
        val valueFromCache = manualCache.get(key)
        Assert.assertEquals(value, valueFromCache)
        TimeUnit.SECONDS.sleep(2)
        Assert.assertNull(manualCache.get(key))
    }

    @Test
    fun testInvalidate() {
        manualCache.putToCache(key, value)
        val valueFromCache = manualCache.get(key)
        Assert.assertEquals(value, valueFromCache)
        manualCache.invalidate(key)
        Assert.assertNull(manualCache.get(key))
    }

}
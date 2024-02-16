package com.herbalife;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheKey;
import io.quarkus.cache.CacheResult;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TemperatureService {
    @CacheResult(cacheName = "temperature-cache")
    public double getTemperature(@CacheKey String city) {
        //Imagine this method calls a weather API to get the temperature
        //So there may be some latency in this method
        //Let's generate a latency of 5 seconds
        System.out.println("*************Getting temperature for " + city);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double temperature = Math.random() * 100;
        return temperature;
    }

    @CacheInvalidate(cacheName = "temperature-cache")
    public void clearCache(@CacheKey String city) {
        System.out.println("*************Clearing cache for " + city);
    }

    @CacheInvalidateAll(cacheName = "temperature-cache")
    public void clearAllCache() {
        System.out.println("*************Clearing all caches");
    }

    @Scheduled(every = "10s")
    public void clearAllCacheEvery10Seconds() {
        //Not recommended in production; Usually we set up TTL in the cache configuration
        //Add your logic to clear all cache or specific cache every 10 seconds
        clearAllCache();
    }
}

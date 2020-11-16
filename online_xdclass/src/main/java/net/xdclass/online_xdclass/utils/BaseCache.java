package net.xdclass.online_xdclass.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName BaseCache
 * @Description TODO
 * @Author LD
 * @Date 2020/8/23 20:20
 * @Version 1.0
 **/
@Component
public class BaseCache {

    /**
     * 10分钟缓存
     */
    private Cache<String, Object> tenMinuteCache = CacheBuilder.newBuilder()
            //设置缓存初始数据，应该合理设置，后续会扩容
            .initialCapacity(10)
            //最大值
            .maximumSize(100)
            //并发数设置
            .concurrencyLevel(5)
            //缓存过期时间，写入后10分钟过期
            .expireAfterWrite(600, TimeUnit.SECONDS)
            //统计缓存命中率
            .recordStats()
            .build();

    private Cache<String, Object> OneHourCache = CacheBuilder.newBuilder()
            //设置缓存初始数据，应该合理设置，后续会扩容
            .initialCapacity(30)
            //最大值
            .maximumSize(100)
            //并发数设置
            .concurrencyLevel(5)
            //缓存过期时间，写入后1小时过期
            .expireAfterWrite(3600, TimeUnit.SECONDS)
            //统计缓存命中率
            .recordStats()
            .build();

    public Cache<String, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<String, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }

    public Cache<String, Object> getOneHourCache() {
        return OneHourCache;
    }

    public void setOneHourCache(Cache<String, Object> oneHourCache) {
        OneHourCache = oneHourCache;
    }
}

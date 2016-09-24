package com.epam.cache;

import com.epam.cache.util.BestCache;
import com.epam.cache.util.Cache;
import com.epam.cache.util.CacheMonitor;

public class Application {

    public static void main(String[] args) {
    	BestCache<String> stringCache = new BestCache<String>();
        use(stringCache);
        monitor(stringCache);
    }

    private static void monitor(CacheMonitor stringCache) {
        Monitor stringCacheMonitor = new Monitor(stringCache);
        stringCacheMonitor.printInfo();
    }

    private static void use(Cache<String> stringCache) {
        CacheUser cacheUser = new CacheUser(stringCache);
        cacheUser.use();
    }

}

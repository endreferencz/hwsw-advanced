package com.epam.cache.util;

import java.util.Date;

public interface CacheMonitor {

    public Iterable<String> getKeys();

    public Date getLastAccess(String key);

    public long getNumHits(String key);

}

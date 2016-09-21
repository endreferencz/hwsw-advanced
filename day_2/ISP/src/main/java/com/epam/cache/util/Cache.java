package com.epam.cache.util;

import java.util.Date;

public interface Cache<T> {

    // Basic cache operations
    public void put(String key, T value);

    public T get(String key);

    public void clear(String key);

    public void clearAll();

    // Monitor cache usage
    public Iterable<String> getKeys();

    public Date getLastAccess(String key);

    public long getNumHits(String key);

}

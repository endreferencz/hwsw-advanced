package com.epam.cache.util;

public interface Cache<T> {

    public void put(String key, T value);

    public T get(String key);

    public void clear(String key);

    public void clearAll();

}

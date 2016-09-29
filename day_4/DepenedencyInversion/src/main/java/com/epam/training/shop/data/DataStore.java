package com.epam.training.shop.data;

public interface DataStore<T> {

    void add(T t);

    Iterable<T> list();

}
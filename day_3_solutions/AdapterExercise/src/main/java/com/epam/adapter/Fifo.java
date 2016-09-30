package com.epam.adapter;

public interface Fifo<T> {

    void push(T t);

    T pop();

}

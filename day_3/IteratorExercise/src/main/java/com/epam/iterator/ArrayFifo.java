package com.epam.iterator;

import java.util.Arrays;

public class ArrayFifo<T> {

    private int size;
    private Object[] elements = new Object[0];

    public ArrayFifo() {
    }

    public void push(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
        elements[size++] = t;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Empty!");
        }
        T t = (T) elements[size - 1];
        elements[size - 1] = null;
        size--;
        return t;
    }

    public static void main(String[] args) {
        ArrayFifo<String> fifo = new ArrayFifo<>();
        fifo.push("a");
        System.out.println(fifo.pop());
        fifo.push("b");
        fifo.push("c");
        fifo.push("d");
        fifo.push("e");
        System.out.println(fifo.pop());
        System.out.println(fifo.pop());
        System.out.println(fifo.pop());
        System.out.println(fifo.pop());
    }

}

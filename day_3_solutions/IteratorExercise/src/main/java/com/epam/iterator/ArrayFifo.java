package com.epam.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayFifo<T> implements Iterable<T> {

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
    
	@Override
	public Iterator<T> iterator() {
		return new FifoIterator();
	}
	
	private class FifoIterator implements Iterator<T> {
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return index < size;
		}

        @Override
        @SuppressWarnings("unchecked")
		public T next() {
			return (T) elements[index++];
		}
	}

    public static void main(String[] args) {
        ArrayFifo<String> fifo = new ArrayFifo<>();
        fifo.push("a");
        System.out.println(fifo.pop());
        fifo.push("b");
        fifo.push("c");
        fifo.push("d");
        fifo.push("e");
        for (String text : fifo) {
        	System.out.println(text);
        }
        for (String text : fifo) {
        	System.out.println(text);
        }
    }

}

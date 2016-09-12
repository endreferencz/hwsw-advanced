package com.epam.measure;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class ArrayListRemoveBenchmark {

    private static final int NUMBER_OF_ELEMENTS = 1_000_000;
    private List<Integer> list = new ArrayList<>();

    @Setup(Level.Invocation)
    public void init() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            list.add(i);
        }
    }

    @Benchmark
    public void remove() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            list.remove(list.size() - 1);
        }
    }

}

package com.epam.measure;

import java.util.LinkedList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
public class LinkedListAddBenchmark {

    private static final int NUMBER_OF_ELEMENTS = 1_000_000;
    private List<Integer> list = new LinkedList<>();
            
    @Setup(Level.Trial)
    public void init() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            list.add(i);
        }
    }
    
    @Benchmark
    public void add() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            list.add(1);
        }
    }
    
    @TearDown(Level.Invocation)
    public void tearDown() throws InterruptedException {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            list.remove(list.size() - 1);
        }
    }
    

}

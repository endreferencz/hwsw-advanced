package com.epam.measure;

import java.util.Arrays;
import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.epam.SortBenchmark;

@State(Scope.Thread)
public class PrimitiveArraySortBenchmark {

    private int[] primitiveNumbersArray = new int[SortBenchmark.COUNT_OF_NUMBERS];
    private int[] workArray;
    private int[] sortedPrimitiveNumbersArray;
    
    public PrimitiveArraySortBenchmark() {
        Random random = new Random();
        for (int i = 0; i < SortBenchmark.COUNT_OF_NUMBERS; i++) {
            int number = random.nextInt();
            primitiveNumbersArray[i] = number;
        }
        sortedPrimitiveNumbersArray = primitiveNumbersArray.clone();
        Arrays.sort(sortedPrimitiveNumbersArray);
    }

    @Setup(Level.Invocation)
    public void setup() {
        workArray = primitiveNumbersArray.clone();
    }

    @Benchmark
    public void sortPrimitiveArray() {
        Arrays.sort(workArray);
    }
    
    @Benchmark
    public void sortPrimitiveSortedArray() {
        Arrays.sort(sortedPrimitiveNumbersArray);
    }

}

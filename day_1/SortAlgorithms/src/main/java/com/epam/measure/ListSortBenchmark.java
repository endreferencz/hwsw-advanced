package com.epam.measure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.epam.SortBenchmark;

@State(Scope.Thread)
public class ListSortBenchmark {

    private List<Integer> numbersList = new ArrayList<>();
    private List<Integer> sortedList = new ArrayList<>();

    public ListSortBenchmark() {
        Random random = new Random();
        for (int i = 0; i < SortBenchmark.COUNT_OF_NUMBERS; i++) {
            int number = random.nextInt();
            numbersList.add(number);
        }
        sortedList = new ArrayList<>(numbersList);
        Collections.sort(sortedList);
    }

    @Setup(Level.Invocation)
    public void setup() {
        Collections.shuffle(numbersList);
    }

    @Benchmark
    public void sortList() {
        Collections.sort(numbersList);
    }
    
    @Benchmark
    public void sortSortedList() {
        Collections.sort(sortedList);
    }

}

package com.epam;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.epam.measure.PrimitiveArraySortBenchmark;
import com.epam.measure.QuickSortObjectBenchmark;
import com.epam.measure.ListSortBenchmark;

public class SortBenchmark {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(PrimitiveArraySortBenchmark.class.getSimpleName())
                .include(ListSortBenchmark.class.getSimpleName())
                .include(QuickSortObjectBenchmark.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(5)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS)
                .forks(1).build();
        new Runner(opt).run();
    }

    public static final int COUNT_OF_NUMBERS = 1_000_000;

}

package com.epam;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.epam.measure.ArrayListAddBenchmark;
import com.epam.measure.ArrayListRemoveBenchmark;
import com.epam.measure.LinkedListAddBenchmark;
import com.epam.measure.LinkedListRemoveBenchmark;

public class SortBenchmark {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ArrayListAddBenchmark.class.getSimpleName())
                .include(LinkedListAddBenchmark.class.getSimpleName())
                .include(ArrayListRemoveBenchmark.class.getSimpleName())
                .include(LinkedListRemoveBenchmark.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(5)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS)
                .forks(1).build();
        new Runner(opt).run();
    }

    public static final int COUNT_OF_NUMBERS = 1_000_000;

}

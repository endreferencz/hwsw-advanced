package com.epam;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class ConcatBenchmark {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ConcatBenchmark.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(5)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS)
                .forks(1).build();
        new Runner(opt).run();
    }
    
    public static final int ITERATIONS = 10_000;
    
    @Benchmark
    public String testConcat() {
        String concat = "";
        for (int i = 0; i < ITERATIONS; i++) {
            concat += i;
        }
        return concat;
    }

    @Benchmark
    public String testBuilder() {
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            concat.append(i);
        }
        return concat.toString();
    }

}

package com.epam.training;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Benchmark {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ContendedObject.class.getSimpleName())
                .include(FalseSharingArray.class.getSimpleName())
                .include(FalseSharingObject.class.getSimpleName())
                .jvmArgs("-XX:-RestrictContended")
                .warmupIterations(10)
                .measurementIterations(6)
                .timeUnit(TimeUnit.NANOSECONDS)
                .mode(Mode.AverageTime)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}

package com.epam.training;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class EscapeBenchmark {

	private static class Result {
		private int value;
	}

	@Benchmark
	public Result escape() {
		Result result = new Result();
		result.value = 5;
		return result;
	}

	@Benchmark
	public long notEscape() {
		Result result = new Result();
		result.value = 5;
		return result.value;
	}
	
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(EscapeBenchmark.class.getSimpleName())
                .jvmArgs("-XX:+DoEscapeAnalysis")
                .warmupIterations(5)
                .measurementIterations(3)
                .timeUnit(TimeUnit.NANOSECONDS)
                .mode(Mode.AverageTime)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
	
}

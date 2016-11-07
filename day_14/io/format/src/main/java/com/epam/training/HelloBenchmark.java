
package com.epam.training;

import java.io.IOException;
import java.text.MessageFormat;
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
public class HelloBenchmark {

	private String hello = "Hello";
	private String world = "world";
	private String exclamation = "!";

	@Benchmark
	public String baseline() throws IOException {
		return "Hello world!";
	}

	@Benchmark
	public String writeConstant() throws IOException {
		return "Hello" + " world" + "!";
	}

	@Benchmark
	public String writeConcat() throws IOException {
		return hello + world + exclamation;
	}

	@Benchmark
	public String writeFormat() throws IOException {
		return MessageFormat.format("{0} {1}{2}", hello, world, exclamation);
	}
	
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(HelloBenchmark.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(3)
                .timeUnit(TimeUnit.NANOSECONDS)
                .mode(Mode.AverageTime)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}

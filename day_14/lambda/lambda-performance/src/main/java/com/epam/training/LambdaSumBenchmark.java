
package com.epam.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class LambdaSumBenchmark {

	private List<Double> list = new ArrayList<>();

	private static final int NUMBER_COUNT = 1;

	public LambdaSumBenchmark() {
		Random random = new Random();
		for (int i = 0; i < NUMBER_COUNT; i++) {
			list.add(random.nextDouble());
		}
	}

	@Benchmark
	public double baseline() {
		double sum = 0;
		for (double current : list) {
			sum += current;
		}
		return sum;
	}

	@Benchmark
	public double lambda() {
		return list.stream().reduce(0D, (a, b) -> a + b);
	}

	@Benchmark
	public double lambdaParallel() {
		return list.parallelStream().reduce(0D, (a, b) -> a + b);
	}

}

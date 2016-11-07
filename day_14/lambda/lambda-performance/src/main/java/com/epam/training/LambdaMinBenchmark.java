
package com.epam.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class LambdaMinBenchmark {

	private List<Double> list = new ArrayList<>();

	private static final int NUMBER_COUNT = 1;

	public LambdaMinBenchmark() {
		Random random = new Random();
		for (int i = 0; i < NUMBER_COUNT; i++) {
			list.add(random.nextDouble());
		}
	}

	@Benchmark
	public double baseline() {
		double min = list.get(0);
		for (double current : list) {
			if (current < min) {
				min = current;
			}
		}
		return min;
	}

	@Benchmark
	public double lambda() {
		return list.stream().min(Double::compareTo).get();
	}
	
	@Benchmark
	public double lambdaParallel() {
		return list.parallelStream().min(Double::compareTo).get();
	}


}

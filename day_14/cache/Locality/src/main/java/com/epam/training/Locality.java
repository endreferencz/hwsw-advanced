package com.epam.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class Locality {

	private static final int NUMBER_OF_POINTS = 1000000;

	private List<Integer> order = new ArrayList<>();

	private Point[] points = new Point[NUMBER_OF_POINTS];

	private double[] xPoints = new double[NUMBER_OF_POINTS];
	private double[] yPoints = new double[NUMBER_OF_POINTS];
	private double[] zPoints = new double[NUMBER_OF_POINTS];
	private double[] wPoints = new double[NUMBER_OF_POINTS];

	@Setup
	public void init() {
		Random random = new Random();
		for (int i = 0; i < NUMBER_OF_POINTS; i++) {
			points[i] = new Point(random.nextDouble(), random.nextDouble(), random.nextDouble(), random.nextDouble());
			xPoints[i] = points[i].getX();
			yPoints[i] = points[i].getY();
			zPoints[i] = points[i].getZ();
			wPoints[i] = points[i].getZ();
		}
		for (int i = 0; i < NUMBER_OF_POINTS; i++) {
			order.add(i);
		}
		Collections.shuffle(order);
	}

	@Benchmark
	public double testObject() {
		double sum = 0;
		for (Integer i : order) {
			sum += points[i].getX() + points[i].getY() + points[i].getZ() + points[i].getW();
		}
		return sum;
	}

	@Benchmark
	public double testPrimitive() {
		double sum = 0;
		for (Integer i : order) {
			sum += xPoints[i] + yPoints[i] + zPoints[i] + wPoints[i];
		}
		return sum;
	}
	
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Locality.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(10)
                .timeUnit(TimeUnit.MILLISECONDS)
                .mode(Mode.AverageTime)
                .forks(1)
                .build();
        new Runner(opt).run();
    }

}

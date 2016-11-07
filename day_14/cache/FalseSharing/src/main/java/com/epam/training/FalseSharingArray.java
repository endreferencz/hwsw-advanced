package com.epam.training;

import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Group)
public class FalseSharingArray {

	private static final int NUMBER_OF_POINTS = 1000;
	private short[] points = new short[NUMBER_OF_POINTS];

	@Setup
	public void init() {
		Random random = new Random();
		for (int i = 0; i < NUMBER_OF_POINTS; i++) {
			points[i] = (short) random.nextInt();
		}
	}

	@Group("Adjacent")
	@Benchmark
	public void testAdjacent1() {
		points[0]++;
	}

	@Group("Adjacent")
	@Benchmark
	public void testAdjacent2() {
		points[1]++;
	}
	
	@Group("Adjacent")
	@Benchmark
	public void testAdjacent3() {
		points[2]++;
	}

	@Group("Adjacent")
	@Benchmark
	public void testAdjacent4() {
		points[3]++;
	}
	
	@Group("Distant")
	@Benchmark
	public void testDistant1() {
		points[0]++;
	}

	@Group("Distant")
	@Benchmark
	public void testDistant2() {
		points[100]++;
	}
	
	@Group("Distant")
	@Benchmark
	public void testDistant3() {
		points[200]++;
	}

	@Group("Distant")
	@Benchmark
	public void testDistant4() {
		points[300]++;
	}

}

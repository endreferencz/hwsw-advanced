package com.epam.training;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;


/**
 * Use with: -XX:-RestrictContended
 */
@State(Scope.Group)
public class ContendedObject {

	static class SharingObject {
		short a = 0;
		short b = 0;
	}
	
	static class PaddedObject {
		short a = 0;
		@SuppressWarnings("restriction")
		@sun.misc.Contended
		short b = 0;
	}

	private SharingObject sharingObject = new SharingObject();
	private PaddedObject paddedObject = new PaddedObject();

	@Group("Adjacent")
	@Benchmark
	public void testAdjacent1() {
		sharingObject.a++;
	}

	@Group("Adjacent")
	@Benchmark
	public void testAdjacent2() {
		sharingObject.b++;
	}

	@Group("Distant")
	@Benchmark
	public void testDistant1() {
		paddedObject.a++;
	}

	@Group("Distant")
	@Benchmark
	public void testDistant2() {
		paddedObject.b++;
	}

}

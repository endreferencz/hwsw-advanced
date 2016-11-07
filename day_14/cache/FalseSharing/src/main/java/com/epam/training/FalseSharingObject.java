package com.epam.training;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Group)
public class FalseSharingObject {

	static class SharingObject {
		short a = 0;
		short b = 0;
	}

	static class PaddedObject {
		short a = 0;
		short padding1 = 0;
		short padding2 = 0;
		short padding3 = 0;
		short padding4 = 0;
		short padding5 = 0;
		short padding6 = 0;
		short padding7 = 0;
		short padding8 = 0;
		short padding9 = 0;
		short padding10 = 0;
		short padding11 = 0;
		short padding12 = 0;
		short padding13 = 0;
		short padding14 = 0;
		short padding15 = 0;
		short padding16 = 0;
		short padding17 = 0;
		short padding18 = 0;
		short padding19 = 0;
		short padding20 = 0;
		short padding21 = 0;
		short padding22 = 0;
		short padding23 = 0;
		short padding24 = 0;
		short padding25 = 0;
		short padding26 = 0;
		short padding27 = 0;
		short padding28 = 0;
		short padding29 = 0;
		short padding30 = 0;
		short padding31 = 0;
		short padding32 = 0;
		short padding33 = 0;
		short padding34 = 0;
		short padding35 = 0;
		short padding36 = 0;
		short padding37 = 0;
		short padding38 = 0;
		short padding39 = 0;
		short padding40 = 0;
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

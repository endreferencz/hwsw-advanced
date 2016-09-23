package com.epam.training.proxy;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static Fifo<String> createFifo() {
		return new FifoUsingLotsOfMemory<String>();
	}

	public static void main(String[] args) {
		List<Fifo<String>> usedLists = new ArrayList<Fifo<String>>();
		for (int i = 0; i < 100000; i++) {
			usedLists.add(createFifo());
		}

		System.out.println("Used memory (MB): " + getUsedMemory());
	}

	private static long getUsedMemory() {
		return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / 1000000;
	}
	
}

package com.epam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Counters {

    private static final int THREAD_COUNT = 4;
    private static final int ITERATIONS = 100_000_000;

    private static AtomicLong atomicLongCounter = new AtomicLong();

    private static volatile long longCounter = 0L;
    private static Object lock = new Object();

    private static LongAdder longAccumulator = new LongAdder();

    private static class AtomicLongCounterThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS / THREAD_COUNT; i++) {
                atomicLongCounter.incrementAndGet();
            }
        }
    }

    private static class SimpleLongCounterThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS / THREAD_COUNT; i++) {
                synchronized (lock) {
                    longCounter++;
                }
            }
        }
    }

    private static class LongAdderCounterThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS / THREAD_COUNT; i++) {
                longAccumulator.increment();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new LongAdderCounterThread());
//            Thread thread = new Thread(new AtomicLongCounterThread());
//            Thread thread = new Thread(new SimpleLongCounterThread());
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");
        System.out.println("Accumulator: " + longAccumulator);
//        System.out.println("AtomicLong: " + atomicLongCounter);
//        System.out.println("Long counter: " + longCounter);
    }

}

package com.epam.training;

import java.io.IOException;


public class CpuBurner {

    private static final long ITERATIONS = 10_000_000L;

    public static void testPrimitive() {
        long count = 0L;
        for (long i = 0; i < ITERATIONS; i++) {
            count++;
        }
        System.out.println(count);
    }

    public static void testReference() {
        Long count = 0L;
        for (long i = 0; i < ITERATIONS; i++) {
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Press ENTER to start");
        System.in.read();
        testPrimitive();
        testReference();
    }

}

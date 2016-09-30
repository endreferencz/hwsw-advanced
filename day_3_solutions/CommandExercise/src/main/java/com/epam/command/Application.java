package com.epam.command;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    public static final List<BigInteger> LARGE_NUMBERS = Arrays.asList(BigInteger.valueOf(141651127L * 941083981L),
            BigInteger.valueOf(159618707L * 941083981L), BigInteger.valueOf(156005249L), BigInteger.valueOf(2L * 159618707L));

    public static void main(String[] args) throws InterruptedException {
        Map<BigInteger, List<BigInteger>> factors = new ConcurrentHashMap<>();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (BigInteger number : LARGE_NUMBERS) {
            newCachedThreadPool.submit(new FactorizeCommand(number, factors));
        }
        newCachedThreadPool.shutdown();
        newCachedThreadPool.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println(factors);
    }

}

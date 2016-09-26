package com.epam.command;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static final List<BigInteger> LARGE_NUMBERS = Arrays.asList(BigInteger.valueOf(141651127L * 941083981L), BigInteger.valueOf(159618707L * 941083981L),
            BigInteger.valueOf(156005249L), BigInteger.valueOf(2L * 159618707L));

    public static void main(String[] args) {
        Map<BigInteger, List<BigInteger>> factors = new HashMap<>();
        for (BigInteger number : LARGE_NUMBERS) {
            factors.put(number, new PrimeFactorizer().calculateFactors(number));
        }
        System.out.println(factors);
    }

}

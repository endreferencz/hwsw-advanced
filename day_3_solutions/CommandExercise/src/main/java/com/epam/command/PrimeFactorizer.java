package com.epam.command;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizer {

    public List<BigInteger> calculateFactors(BigInteger number) {
        List<BigInteger> factors = new ArrayList<BigInteger>();
        for (BigInteger i = BigInteger.valueOf(2); i.pow(2).compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
            while (number.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                number = number.divide(i);
            }
        }
        if (!number.equals(BigInteger.ONE)) {
            factors.add(number);
        }
        return factors;
    }

}

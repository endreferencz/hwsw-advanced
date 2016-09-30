package com.epam.command;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class FactorizeCommand implements Runnable {

	private BigInteger number;
	private Map<BigInteger, List<BigInteger>> factors;

	public FactorizeCommand(BigInteger number, Map<BigInteger, List<BigInteger>> factors) {
		this.number = number;
		this.factors = factors;
	}

	@Override
	public void run() {
		factors.put(number, new PrimeFactorizer().calculateFactors(number));
	}

}

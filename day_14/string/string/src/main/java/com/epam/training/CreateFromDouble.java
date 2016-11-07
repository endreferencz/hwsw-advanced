
package com.epam.training;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class CreateFromDouble {

	private double number = 3.1415;

	@Benchmark
	public String add() {
		return "" + number;
	}

	@Benchmark
	public String withDouble() {
		return Double.toString(number);
	}

	@Benchmark
	public String withNewDouble() {
		return Double.valueOf(number).toString();
	}

	@Benchmark
	public String valueOf() {
		return String.valueOf(number);
	}

	@Benchmark
	public String builder() {
		return new StringBuilder().append(number).toString();
	}

	@Benchmark
	public String buffer() {
		return new StringBuffer().append(number).toString();
	}
}

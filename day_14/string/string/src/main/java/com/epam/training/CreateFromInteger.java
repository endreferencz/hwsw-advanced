
package com.epam.training;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class CreateFromInteger {

	private int number = 42;

	@Benchmark
	public String add() {
		return "" + number;
	}

	@Benchmark
	public String withInteger() {
		return Integer.toString(number);
	}

	@Benchmark
	public String withNewInteger() {
		return Integer.valueOf(number).toString();
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


package com.epam.training;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class CreateString {

	private String hello = "Hello world!";

	@Benchmark
	public String constant() {
		return "Hello world!";
	}

	@Benchmark
	public String newInstance() {
		return new String(hello);
	}

	@Benchmark
	public String valueOf() {
		return String.valueOf(hello);
	}

	@Benchmark
	public String builder() {
		return new StringBuilder().append(hello).toString();
	}

	@Benchmark
	public String buffer() {
		return new StringBuffer().append(hello).toString();
	}
}

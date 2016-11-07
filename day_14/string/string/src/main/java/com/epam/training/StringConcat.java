package com.epam.training;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class StringConcat {

	private String a = "Hello A!";
	private String b = "Hello B!";
	private String c = "Hello C!";

	@Benchmark
	public String add() {
		return a + b + c;
	}

	@Benchmark
	public String concat() {
		return a.concat(b).concat(c);
	}

	@Benchmark
	public String builder() {
		return new StringBuilder().append(a).append(b).append(c).toString();
	}

	@Benchmark
	public String buffer() {
		return new StringBuffer().append(a).append(b).append(c).toString();
	}

}

package com.epam.testing.calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] { { 0, 0, 0 }, { 1, 2, 3 }, { 7, 8, 15 }, { 1, -2, -1 }, { 1, 0, 1 }, { 2, 2, 4 }, });
	}

	private Calculator calculator = new Calculator();

	private int a;
	private int b;
	private int expected;

	public CalculatorTest(int a, int b, int result) {
		this.a = a;
		this.b = b;
		this.expected = result;
	}

	@Test
	public void testAdd() {
		// Given

		// When
		int actual = calculator.add(a, b);

		// Then
		assertEquals("The add method returned invalid value.", expected, actual);
	}

}

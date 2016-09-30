package com.epam.training.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSequence {

    public interface Calculcator {
        long nextNumber(List<Long> numbers);
    }

    private List<Long> numbers;
    private Calculcator calulcator;

    public NumberSequence(Calculcator calculator, Long... numbers) {
        this.calulcator = calculator;
        this.numbers = new ArrayList<Long>(Arrays.asList(numbers));
    }

    public long next() {
        long nextNumber = calulcator.nextNumber(numbers);
        numbers.add(nextNumber);
        return nextNumber;
    }

    public static void main(String[] args) {
        NumberSequence fibonacci = createFibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci.next());
        }
    }

	public static NumberSequence createFibonacci() {
		return new NumberSequence(new Calculcator() {
            @Override
            public long nextNumber(List<Long> numbers) {
                return numbers.get(numbers.size() - 2) + numbers.get(numbers.size() - 1);
            }
        }, 1L, 1L);
	}
}

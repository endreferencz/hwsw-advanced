package com.epam.training;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class DevirtBenchmark {

	private List<Calc> monomorphic = Arrays.asList(new Calc1(), new Calc1(), new Calc1());
	private List<Calc> bimorphic = Arrays.asList(new Calc1(), new Calc2(), new Calc2());
	private List<Calc> megamorphic = Arrays.asList(new Calc1(), new Calc2(), new Calc3());

	private int x = 7;

	@Benchmark
	public int measureMonomorphic() {
		int sum = 0;
		for (Calc b : monomorphic) {
			sum += b.calc(x);
		}
		return sum;
	}

	@Benchmark
	public int measureBimorphic() {
		int sum = 0;
		for (Calc b : bimorphic) {
			sum += b.calc(x);
		}
		return sum;
	}

	@Benchmark
	public int measureMegamorphic() {
		int sum = 0;
		for (Calc b : megamorphic) {
			sum += b.calc(x);
		}
		return sum;
	}
	
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DevirtBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(3)
                .timeUnit(TimeUnit.NANOSECONDS)
                .mode(Mode.AverageTime)
                .forks(1)
                .build();
        new Runner(opt).run();
    }

}

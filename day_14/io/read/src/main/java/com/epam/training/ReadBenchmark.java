
package com.epam.training;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
public class ReadBenchmark {

	private File file = new File("image.jpg");

	@Benchmark
	public void read() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		while (fis.read() != -1) {
		}
		fis.close();
	}

	@Benchmark
	public void readBuffered() throws IOException {
		BufferedInputStream bfis = new BufferedInputStream(new FileInputStream(file));
		while (bfis.read() != -1) {
		}
		bfis.close();
	}

	@Benchmark
	public void readDirectBuffer() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		while (fis.read(buffer) != -1) {
		}
		fis.close();
	}
	
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ReadBenchmark.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(3)
                .timeUnit(TimeUnit.MILLISECONDS)
                .mode(Mode.AverageTime)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}

package com.linux.test.enums;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class MonthEnumBenchmark {

	@Test
	public void benchmarkStreamFindVsMapGetFromEnum() throws RunnerException {
		Options opt = new OptionsBuilder()
				// Specify which benchmarks to run. 
				// You can be more specific if you'd like to run only one benchmark per test.
				.include(this.getClass().getName() + ".*")
				// Set the following options as needed
				.mode(Mode.AverageTime)
				.timeUnit(TimeUnit.MICROSECONDS)
				.warmupTime(TimeValue.nanoseconds(100))
				.warmupIterations(1)
				.measurementTime(TimeValue.nanoseconds(100))
				.measurementIterations(10)
				.threads(4)
				.forks(1)
				.shouldFailOnError(true)
				.shouldDoGC(true)
				//.jvmArgs("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintInlining")
				//.addProfiler(WinPerfAsmProfiler.class)
				.build();

		new Runner(opt).run();

	}

	@State(Scope.Thread)
	public static class BenchmarkState {
		String monthAbbrevation;

		@Setup(Level.Trial)
		public void initialize() {
			monthAbbrevation = Month.DECEMBER.getAbbreviation();
		}
	}

	@Benchmark
	public void initializeOnUseMapInEnum(BenchmarkState state, Blackhole bh) {

			bh.consume(Month.getMonth(state.monthAbbrevation));
	}


	@Benchmark
	public void simpleStreamInEnum(BenchmarkState state, Blackhole bh) {
		bh.consume(Month.getMonthStream(state.monthAbbrevation));
	}
}

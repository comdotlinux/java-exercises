package com.linux.test.strings;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;


@Fork(10) // The entire suite is run this many times
@OutputTimeUnit(TimeUnit.NANOSECONDS) // the result displayed in this time unit
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, timeUnit = TimeUnit.NANOSECONDS, time = 1000)
@Measurement(iterations = 50, timeUnit = TimeUnit.NANOSECONDS, time = 1000)
public class StringFormatVsConcatBenchmark {

	@Test
	public void benchmarkRunner() throws RunnerException {

		Options opt = new OptionsBuilder()
				.include(StringFormatVsConcatBenchmark.class.getSimpleName())
				.threads(Runtime.getRuntime().availableProcessors() + 1) // makes runs faster in multiple threads
				.build();

		new Runner(opt).run();

	}

	@State(Scope.Thread)
	public static class BenchmarkState {
		@Param(rhs_const)
		String rhs;


		@Param(lhs_const)
		String lhs;

		@Param("%s%s")
		String formatString;

		static final String lhs_const = "lhs";
		static final String rhs_const = "rhs";
	}

	@Benchmark
	public void stringConcatinationInstanceVariable(StringFormatVsConcatBenchmark.BenchmarkState state, Blackhole bh) {

		bh.consume(state.lhs + state.rhs);
	}


	@Benchmark
	public void stringFormatInstanceVariable(StringFormatVsConcatBenchmark.BenchmarkState state, Blackhole bh) {
		bh.consume(String.format(state.formatString, state.lhs, state.rhs));
	}

	@Benchmark
	public void stringConcatinationConstantVariable(StringFormatVsConcatBenchmark.BenchmarkState state, Blackhole bh) {

		bh.consume(BenchmarkState.lhs_const + BenchmarkState.rhs_const);
	}

	@Benchmark
	public void stringFormatConstantVariable(StringFormatVsConcatBenchmark.BenchmarkState state, Blackhole bh) {
		bh.consume(String.format(state.formatString, BenchmarkState.lhs_const, BenchmarkState.rhs_const));
	}
}



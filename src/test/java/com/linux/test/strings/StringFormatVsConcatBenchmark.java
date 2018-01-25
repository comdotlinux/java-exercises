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


/**
 * JMH version: 1.20<br>
 * VM version: JDK 9.0.4, VM 9.0.4+11<br>
 * VM invoker: /usr/lib/jvm/java-9-oracle/bin/java<br>
 * VM options: -Dvisualvm.id=556241303924935 -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:/home/guru/IDEs/idea-IU-173.3727.127/lib/idea_rt.jar=36417:/home/guru/IDEs/idea-IU-173.3727.127/bin -Dfile.encoding=UTF-8<br>
 * Warmup: 10 iterations, 1000 ns each<br>
 * Measurement: 50 iterations, 1000 ns each<br>
 * Timeout: 10 min per iteration<br>
 * Threads: 5 threads, will synchronize iterations<br>
 * Benchmark mode: Average time, time/op<br>
 * Benchmark: com.linux.test.strings.StringFormatVsConcatBenchmark<br>
 * Parameters: (formatString = %s%s, lhs = lhs, rhs = rhs)<br>
 *<br>
 *<br>
 * Run complete. Total time: 00:01:27<br>
 *<br>
 *Benchmark                                                          (formatString)  (lhs)  (rhs)  Mode  Cnt      Score       Error  Units<br>
 *StringFormatVsConcatBenchmark.stringConcatinationConstantVariable            %s%s    lhs    rhs  avgt  500    388.391 ±   532.895  ns/op<br>
 *StringFormatVsConcatBenchmark.stringConcatinationInstanceVariable            %s%s    lhs    rhs  avgt  500  35217.389 ± 58563.208  ns/op<br>
 *StringFormatVsConcatBenchmark.stringFormatConstantVariable                   %s%s    lhs    rhs  avgt  500  60062.523 ± 70754.144  ns/op<br>
 *StringFormatVsConcatBenchmark.stringFormatInstanceVariable                   %s%s    lhs    rhs  avgt  500  79941.244 ± 65650.460  ns/op<br>
 *<br>
 *Process finished with exit code 0<br>
 *<br>
 *<br>
 * Run complete. Total time: 00:01:23<br>
 *<br>
 *Benchmark                                                          (formatString)  (lhs)  (rhs)  Mode  Cnt       Score        Error  Units<br>
 *StringFormatVsConcatBenchmark.stringConcatinationConstantVariable            %s%s    lhs    rhs  avgt  500     328.110 ±    147.617  ns/op<br>
 *StringFormatVsConcatBenchmark.stringConcatinationInstanceVariable            %s%s    lhs    rhs  avgt  500   25392.440 ±  34154.686  ns/op<br>
 *StringFormatVsConcatBenchmark.stringFormatConstantVariable                   %s%s    lhs    rhs  avgt  500  111080.760 ± 110650.381  ns/op<br>
 *StringFormatVsConcatBenchmark.stringFormatInstanceVariable                   %s%s    lhs    rhs  avgt  500  124862.550 ± 131435.440  ns/op<br>
 */
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



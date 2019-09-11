package com.linux.test.enums;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

public class MonthEnumTest {

	@Test
	public void initializeOnDemandEnumMapTest() {
		Month expected = Month.MARCH;

		Month actual = Month.getMonth("mar");
		Month actualStream = Month.getMonthStream("mar");


		assertThat(actual, is(expected));
		assertThat(actualStream, is(expected));


		Month.getMonthStream("dec");
	}


	@Test
	public void initializeOnDemandEnumMapPerformanceTest() {
		Month expected = Month.DECEMBER;

		long start = System.nanoTime();
		Month actual = Month.getMonth("dec");
		long durationInMillis = System.nanoTime() - start;


		assertThat(actual, is(expected));
		System.out.println("Took : " + durationInMillis);
	}

	@Test
	public void enumWithStreamPerformanceTest() {
		Month expected = Month.DECEMBER;

		long start = System.nanoTime();
		Month actual = Month.getMonthStream("dec");
		long durationInMillis = System.nanoTime() - start;


		assertThat(actual, is(expected));
		System.out.println("Took : " + durationInMillis);
	}

}

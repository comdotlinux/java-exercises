package com.linux.test.strings;

import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.Test;

@SuppressWarnings(value = {"StringEquality", "RedundantStringConstructorCall"})
public class StringsTest {
	private static final String direct = "test the String Class";

	@Test
	public void testStringConstructor() {
		String constructor = new String("test the String Class");

		assertThat(direct.equals(constructor), is(true));
		assertThat(direct == constructor, is(false));

	}

	@Test
	public void testStringInterning() {
//		String direct = "test the String Class";
		String constructor = new String("test the String Class").intern();

		assertThat(direct.equals(constructor), is(true));
		assertThat(direct == constructor, is(true));
	}

	@Test
	public void substringTest() {
		String inputTimeStamp = "2017-02-27-07.57.31.015910";
		String actual = inputTimeStamp.substring(20, 26);
		System.out.printf("com.linux.test.strings.StringsTest.substringTest() actual : %s%n", actual);
		assertThat(actual, is("015910"));

		int lastDotPos = inputTimeStamp.lastIndexOf(".");
		assertThat(lastDotPos, is(19));

		actual = inputTimeStamp.substring(0, lastDotPos);
		System.out.printf("com.linux.test.strings.StringsTest.substringTest() lhs = %s%n", actual);
		assertThat(actual, is("2017-02-27-07.57.31"));
	}

	@Test
	public void randomTest() {
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			String nextInt = String.format("%06d", Math.abs(r.nextInt(999999)));
			System.out.printf("com.linux.test.strings.StringsTest.random() : %s%n", nextInt);
		}
	}


	@Test
	public void stringSplitTest() {
//        String timestampInput = "2016-12-31-11.10.09.77777"
		char a = "1234".charAt(3);
		int a_int = Integer.parseInt(String.valueOf(a));
		System.out.printf("com.linux.test.strings.StringsTest.stringSplitTest() a : %s%n", a);
		System.out.printf("com.linux.test.strings.StringsTest.stringSplitTest() a : %s int is %d%n", a, a_int);

		assertThat(4, is(a_int));

		String actual = StringUtils.overlay("1234", String.valueOf(a_int++), 1, 2);

		assertThat(actual, is("1434"));

		actual = StringUtils.overlay("1234", "00", 0, 2);

		assertThat(actual, is("0034"));
	}


}

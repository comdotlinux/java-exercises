package com.linux.test.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum Month {
	JANUARY("jan"),
	FEBRUARY("feb"),
	MARCH("mar"),
	APRIL("apr"),
	MAY("may"),
	JUNE("jun"),
	JULY("jul"),
	AUGUST("aug"),
	SEPTEMBER("sep"),
	OCTOBER("oct"),
	NOVEMBER("nov"),
	DECEMBER("dec");


	/**
	 * Initialize on Demand class from : https://stackoverflow.com/questions/27703119/convert-from-string-to-a-java-enum-with-large-amount-of-values/27703839#27703839
	 *
	 */
	private static final class Holder{
//		static {
//			System.out.println("Initializing map");
//		}
		private static final Map<String, Month> abbreviationToMonth = new HashMap<>();
	}

	private final String abbreviation;

	Month(String abbreviation) {
		this.abbreviation = abbreviation;
//		System.out.println("adding values to map");
		Holder.abbreviationToMonth.put(abbreviation, this);
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * execution performance is O(1)  -- constant time regardless of number of constants
	 */
	public static Month getMonth(String abbrevation) {
		return Holder.abbreviationToMonth.get(abbrevation);
	}

	/**
	 * execution performance is
	 */
	public static Month getMonthStream(String abbrevation) {
		return Stream.of(values())
//				.peek(System.out::println)
				.filter(m -> m.abbreviation.equals(abbrevation)).findFirst()
				.orElse(null);
	}



}

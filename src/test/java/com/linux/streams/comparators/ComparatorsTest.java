package com.linux.streams.comparators;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class ComparatorsTest {

	private List<User> userList;
	@Before
	public void setUp() {
		userList = IntStream.range(0, 100).mapToObj(i -> new User(i, Objects.toString(i), Timestamp.from(Instant.from(LocalDate.of(2000 - i, i / 10, i / 20))))).collect(toList());
	}

	@Test
	public void SimpleComparatorTestNoNulls() {
		Optional<User> last = userList.stream().max(comparing(User::getId));
		
	}
}

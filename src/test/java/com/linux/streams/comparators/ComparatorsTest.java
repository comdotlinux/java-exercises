package com.linux.streams.comparators;

import java.sql.Timestamp;
import java.time.Instant;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class ComparatorsTest {

	private List<User> userList;
	@org.junit.jupiter.api.BeforeEach
	public void setUp() {
		userList = IntStream.range(0, 100).
                        mapToObj(i -> new User(i, Objects.toString(i), Timestamp.from(Instant.now()))).
                        collect(toList());
	}

	@Test
	public void SimpleComparatorTestNoNulls() {
		Optional<User> last = userList.stream().max(comparing(User::getId));
		
	}
}

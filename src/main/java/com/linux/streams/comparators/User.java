package com.linux.streams.comparators;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

import static java.sql.Timestamp.from;
import static java.time.Instant.now;

public class User {

	private final long id;
	private final String name;
	private final Timestamp birthdate;
	private final Timestamp creationdate;
	private final Timestamp modificationdate;


	public User(long id, String name, Timestamp birthdate) {
		this(id, name, birthdate, from(now()), from(now()));
	}

	public User(long id, String name, Timestamp birthdate, Timestamp creationdate, Timestamp modificationdate) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.creationdate = creationdate;
		this.modificationdate = modificationdate;
	}


	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Timestamp getBirthdate() {
		return birthdate;
	}

	public Timestamp getCreationdate() {
		return creationdate;
	}

	public Timestamp getModificationdate() {
		return modificationdate;
	}
}

package com.rhcloud.test.strings;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringsTest {

	@Test
	public void testStringConstructor() {
		String direct = "test the String Class";
		String constructor = new String("test the String Class");
		
		assertThat("Strings are not equal using equals", direct.equals(constructor), is(true));
		assertThat(direct == constructor, is(false));
		
	}
	
	@Test
	public void testStringInterning() {
		String direct = "test the String Class".intern();
		String constructor = new String("test the String Class").intern();
		
		assertThat("Strings are not equal", direct.equals(constructor), is(true));
		assertThat(direct == constructor, is(true));
	}
	

}

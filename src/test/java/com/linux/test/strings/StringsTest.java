package com.linux.test.strings;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings(value = {"StringEquality"})
public class StringsTest {

	@Test
	public void testStringConstructor() {
		String direct = "test the String Class";
		String constructor = new String("test the String Class");
		
		assertThat(direct.equals(constructor), is(true));
		assertThat(direct == constructor, is(false));
		
	}
	
	@Test
         
	public void testStringInterning() {
		String direct = "test the String Class".intern();
		String constructor = new String("test the String Class").intern();
		
		assertThat(direct.equals(constructor), is(true));
		assertThat(direct == constructor, is(true));
	}
	

}

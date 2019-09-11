package com.linux.test.exception;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;


public class ThrowErrorsOrExceptions {

	@Test @Ignore
	public void systemExitZeroInTryCatch() {
		try{
			System.out.println("In try before System.exit");
			System.exit(0);
			System.out.println("In try after System.exit -- should not print");
		} finally{
			System.out.println("In Finally -- does it print?");
		}
	}
	
	@Test
	public void returnInTryFinallyDoesRun() {
		
		String input = "input";
		String value = getValue(input);
		
		assertThat(value, is(equalTo(input)));
		
	}

	private String getValue(String value) {
		try {
			return value;	
		} finally {
			System.out.println("Value is " + value + " after return");
		}
		
	}
	
}

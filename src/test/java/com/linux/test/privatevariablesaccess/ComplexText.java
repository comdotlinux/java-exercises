package com.linux.test.privatevariablesaccess;

import com.linux.test.privatevariablesaccess.Complex;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ComplexText {

	@Test
	public void test_you_Can_Use_Private_Variables_In_Instances_Of_Same_Object_Types() {
		Complex expected = new Complex(6, 2);
		Complex one = new Complex(8, 0);
		Complex two = new Complex(-2, 2);
		
		assertThat(expected, is(equalTo(one.add(two))));
	}
	
	

}

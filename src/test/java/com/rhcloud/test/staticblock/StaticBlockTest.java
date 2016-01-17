package com.rhcloud.test.staticblock;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StaticBlockTest {

	@Test
	public void test() {
		B b = new B();
		A a = new B();
		A aa = new A();
		
		b.sayTheWord("Hummingbird");
		a.sayTheWord("Hummingbird");
		aa.sayTheWord("Hummingbird");
		
	}

}

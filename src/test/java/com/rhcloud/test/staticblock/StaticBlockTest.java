package com.rhcloud.test.staticblock;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StaticBlockTest {

	@Test
	public void testStaticBlocksRunOnlyOnceBeforeClassInstantiation() {
		A a = new A();
		B b = new B();
                
                assertThat(a, is(notNullValue()));
                assertThat(b, is(notNullValue()));
	}
        
        @Test
	public void testPolymophism_whichMethodGetsCalled() {
		B b = new B();
		A a = new B();
		A aa = new A();
		
		b.sayTheWord("Hummingbird");
		a.sayTheWord("Hummingbird");
		aa.sayTheWord("Hummingbird");
                
                assertThat(b, is(notNullValue()));
                assertTrue(b instanceof A);
                
                assertThat(a, is(notNullValue()));
                assertTrue(a instanceof B);
                assertTrue(a instanceof A);
                
                assertThat(aa, is(notNullValue()));
                assertFalse(aa instanceof B);
		
	}

}

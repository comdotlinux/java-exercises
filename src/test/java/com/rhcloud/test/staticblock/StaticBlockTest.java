package com.rhcloud.test.staticblock;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StaticBlockTest {

	@Test
	public void testStaticBlocksRunOnlyOnceBeforeClassInstantiation() {
		ClassOne a = new ClassOne();
		ClassOther b = new ClassOther();
                
                assertThat(a, is(notNullValue()));
                assertThat(b, is(notNullValue()));
	}
        
        @Test
	public void testPolymophism_whichMethodGetsCalled() {
		ClassOther b = new ClassOther();
		ClassOne a = new ClassOther();
		ClassOne aa = new ClassOne();
		
		b.sayTheWord("Hummingbird");
		a.sayTheWord("Hummingbird");
		aa.sayTheWord("Hummingbird");
                
                assertThat(b, is(notNullValue()));
                assertThat(b, isA(ClassOne.class));
                
                assertThat(a, is(notNullValue()));
                assertThat(b, isA(ClassOther.class));
                assertThat(b, isA(ClassOne.class));
                
                assertThat(aa, is(notNullValue()));
                assertFalse(aa instanceof ClassOther);
		
	}

}

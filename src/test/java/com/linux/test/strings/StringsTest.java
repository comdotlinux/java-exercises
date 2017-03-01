package com.linux.test.strings;

import java.util.Random;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings(value = {"StringEquality", "RedundantStringConstructorCall"})
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
    
    @Test
    public void substringTest() {
        String inputTimeStamp = "2017-02-27-07.57.31.015910";
        String actual = inputTimeStamp.substring(20,26);
        System.out.println("com.linux.test.strings.StringsTest.substringTest()" + actual);
        assertThat(actual, is("015910"));
        
        int lastDotPos = inputTimeStamp.lastIndexOf(".");
        assertThat(lastDotPos, is(19));
        
        actual = inputTimeStamp.substring(0, lastDotPos);
        System.out.println("com.linux.test.strings.StringsTest.substringTest() lhs = " + actual);
        assertThat(actual, is("2017-02-27-07.57.31"));
    }
    
    @Test
    public void randomTest() {
        Random r = new Random(System.nanoTime());
        for (int i = 0; i < 100; i++) {
            String nextInt = String.format("%06d",Math.abs(r.nextInt(999999)));
            System.out.println("com.linux.test.strings.StringsTest.random()" + nextInt);
        }
    }
    
    
}

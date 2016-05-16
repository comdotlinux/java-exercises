package com.rhcloud.test.forloop;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * These tests show that the post increment OR pre increment operators do not make a difference in for loops when added in the third statement.
 * This is because the increment part (third statement in for loop -- after second semicolon) is run after the loop is run first.
 * 
 * 1. So First Initialize {@code i}
 * 2. Check if Condition matches {@code (i < 10)}
 * 3. Run For loop body 
 * 4. Increment
 * 5. Run from 2 to 4 till 2 return false.
 * 
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class ForLoop {
    
    @Test
    public void testPostIncrement() {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("com.rhcloud.test.forloop.ForLoop.testPostIncrement() counter value :: " + counter);
            assertThat(i, is(counter++));
            System.out.println("com.rhcloud.test.forloop.ForLoop.testPostIncrement() :: " + i);
        }
        
        assertThat(counter, is(10));
    }
    
    @Test
    public void testPreIncrement() {
        int counter = 0;
        for (int i = 0; i < 10; ++i) {
            System.out.println("com.rhcloud.test.forloop.ForLoop.testPreIncrement() counter value :: " + counter);
            assertThat(i, is(counter));
            assertThat(i, is(not((++counter))));
            System.out.println("com.rhcloud.test.forloop.ForLoop.testPreIncrement() :: " + i);
        }
        assertThat(counter, is(10));
    }
     
}
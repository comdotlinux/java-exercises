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
 * <ol>
 * <li>So First Initialize {@code int i}</li>
 * <li>Check Condition {@code if (i < 10)} then proceed </li>
 * <li>Run For loop body </li>
 * <li>Increment {@code i++ OR ++i} no difference as value is not currently assigned.</li>
 * <li>Run from 2 to 4 till 2 returns {@code false}.</li>
 * </ol>
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
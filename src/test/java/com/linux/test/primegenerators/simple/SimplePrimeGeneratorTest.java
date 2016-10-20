package com.linux.test.primegenerators.simple;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsCollectionContaining.*;
import static org.hamcrest.MatcherAssert.*;

/**
 *
 * @author guru.a.kulkarni
 */
public class SimplePrimeGeneratorTest {

    /**
     * Test of primes method, of class SimplePrimeGenerator.
     */
    @Test
    public void testPrimes() {
        System.out.println("primes");
        SimplePrimeChecker instance = new SimplePrimeChecker(100L);
        System.out.println("com.linux.test.primegenerators.simple.SimplePrimeGeneratorTest.testPrimes()" + instance.primes(10));
    }
    
    @Test
    public void sieveOfEratosthnesTest() {
        SieveOfEratosthenes soe = new SieveOfEratosthenes(100);
        Integer[] primes = soe.getPrimes();
        System.out.println("sieveOfEratosthnesTest()" + Arrays.toString(primes));
    }

}
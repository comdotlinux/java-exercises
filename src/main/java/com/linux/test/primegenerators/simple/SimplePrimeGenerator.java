package com.linux.test.primegenerators.simple;

/**
 *
 * @author guru.a.kulkarni
 */
public class SimplePrimeGenerator {
    
    private final long maxNumber;
    
    public SimplePrimeGenerator(long maxNumber) {
        this.maxNumber = maxNumber;
    }
    
    public static float primes(long start, long end) {
        if (start == 1) {
            return 1;
        } else if ( end%start == 0 ) {
            return 0;
        } else {
            return primes(start - 1, end);
        }
    }
    
    public float primes(long start) {
        return primes(start, maxNumber);
    }
}

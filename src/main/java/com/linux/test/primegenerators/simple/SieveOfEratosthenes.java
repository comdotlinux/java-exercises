package com.linux.test.primegenerators.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created based upon <a href="http://www.geeksforgeeks.org/sieve-of-eratosthenes/">Sieve Of Eratosthenes</a><br>
 * For a visual explanation <a href="https://upload.wikimedia.org/wikipedia/commons/b/b9/Sieve_of_Eratosthenes_animation.gif">here</a> is a nice GIF.
 * @author guru.a.kulkarni
 */
public class SieveOfEratosthenes {
    
    private static final Logger LOG = getLogger(SieveOfEratosthenes.class);
    
    private final int maxNumber;
    private final boolean[] primes;

    public SieveOfEratosthenes(int maxNumber) {
        this.maxNumber = maxNumber;
        primes = new boolean[maxNumber + 1];
        for(int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
    }
    
    public int[] getPrimes() {
        for(int p = 2; p*p <= maxNumber; p++) {
            LOG.info("p is {}", p);
            if(primes[p]) {
                LOG.info("{} is prime", p);
                for (int i = p*2; i <= maxNumber; i += p) {
                    primes[i] = false;
                    LOG.info("i is {} and is prime? {}.", primes[i]);
                }
            }
        }
        
        LOG.info("Printing all primes");
        for(int i = 2; i <= maxNumber; i++) {
            if(primes[i]) {
                LOG.info("{},{i}");
            }
        }
        return new int[]{0};
    }
    
}

package com.linux.test.primegenerators.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created based upon <a href="http://www.geeksforgeeks.org/sieve-of-eratosthenes/">Sieve Of Eratosthenes</a><br>
 * For a visual explanation <a href="https://upload.wikimedia.org/wikipedia/commons/b/b9/Sieve_of_Eratosthenes_animation.gif">here</a> is a nice GIF.
 * @author guru.a.kulkarni
 */
public class SieveOfEratosthenes {

    private static final Logger LOG = getLogger(SieveOfEratosthenes.class);

    private final int maxNumber;
    private final boolean[] prime;

    public SieveOfEratosthenes(int maxNumber) {
        this.maxNumber = maxNumber;
        prime = new boolean[maxNumber + 1];
        for(int i = 0; i < prime.length; i++) {
            prime[i] = true;
        }
    }

    public Integer[] getPrimes() {
        int counter = 0;
        for(int p = 2; p*p <= maxNumber; p++) {
            if(prime[p]) {
                for (int i = p*2; i <= maxNumber; i += p) {
                    prime[i] = false;
                    counter++;
                }
            } else {
                counter++;
            }
            LOG.info("Current state when p is {} is {}", p, Arrays.toString(getStateOfArray()));
        }



        LOG.info("Getting all primes, took {} for loops", counter);
        return getStateOfArray();
    }

    private Integer[] getStateOfArray() {
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= maxNumber; i++) {
            if(prime[i]) {
                primes.add(i);
            }
        }
        return primes.toArray(new Integer[0]);
    }

}

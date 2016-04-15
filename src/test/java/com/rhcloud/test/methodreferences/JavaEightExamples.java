package com.rhcloud.test.methodreferences;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class JavaEightExamples {
   
    @Test
    public void threadWithoutLambdas() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("threadWithoutLambdas : " + Thread.currentThread().getName());
            }
        };
        
        Thread thread = new Thread(r);
        thread.setName("preJava8 Thread");
        thread.start();
        
        System.out.println("threadWithoutLambdas outside runnable: " + Thread.currentThread().getName());
    }
   
}

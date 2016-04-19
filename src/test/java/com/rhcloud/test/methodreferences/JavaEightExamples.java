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
    
    @Test
    public void threadWithLambdas() {
        Runnable r = () -> {
            System.out.println("threadWithLambdas()" + Thread.currentThread().getName());  
        };
        
        Thread thread = new Thread(r);
        thread.setName("Java8 Thread");
        thread.start();
        
        System.out.println("threadWithLambdas outside runnable: " + Thread.currentThread().getName());
    }
    
    @Test
    public void threadWithLambdasConsise() {
        Runnable r = () -> System.out.println("threadWithLambdasConsise()" + Thread.currentThread().getName());
        
        Thread thread = new Thread(r);
        thread.setName("Java8 Thread Consise");
        thread.start();
        
        System.out.println("threadWithLambdasConsise outside runnable: " + Thread.currentThread().getName());
    }
    
    @Test
    public void threadWithMethodreferences() {
        Runnable r = this::runInSeperateThread;  // implementing runnable#run method by a method with same signature. -- Awesome.
        
        Thread thread = new Thread(r);
        thread.setName("Java8 Thread Method reference");
        thread.start();
        
        System.out.println("Method reference outside runnable: " + Thread.currentThread().getName());
    }
    
    public void runInSeperateThread() {
        System.out.println("runInSeperateThread()" + Thread.currentThread().getName());
    }
   
}

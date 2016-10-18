package com.linux.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Abusing Unit tests for {@linkplain CompletableFutures}
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class CompletableFuturesTest {

    private static final int SUPPLIER_WAIT_TIME_IN_MILLIS = 20;
    private static final int WAIT_TIME_1000_IN_MILLIS = 10;
    
//    @Before
//    public void setUp() {
//    }
    
    @Test
    public void simplePipeline() throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(this::stringSupplier).thenAccept(this::consumer).get();
    }
     
    String stringSupplier() {
        try {
            Thread.sleep(SUPPLIER_WAIT_TIME_IN_MILLIS);
        } catch (InterruptedException ex) {
            Logger.getLogger(CompletableFuturesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Java rocks " + System.currentTimeMillis();
    }
    
    void consumer(String accept) {
        System.out.println("com.rhcloud.futures.CompletableFuturesTest.consumer() :: " + accept);
    }
    
    @Test
    public void simplePipelineWithApply() throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(this::stringSupplier).thenApply(this::beautifyOutput).thenAccept(this::consumer).get();
    }

    String beautifyOutput(String input){
        return "--> " + input + " <--";
    }
    
    String beautifyOutputSlow(String input){
        StringBuilder beautifiedOutput = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(i * WAIT_TIME_1000_IN_MILLIS);
            } catch (InterruptedException ex) {
                Logger.getLogger(CompletableFuturesTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            beautifiedOutput.append("*").append(i).append("*");
        }
        beautifiedOutput.append("|> ").append(input).append(" <|");
        for (int i = 10; i < 20; i++) {
            try {
                Thread.sleep(i * WAIT_TIME_1000_IN_MILLIS);
            } catch (InterruptedException ex) {
                Logger.getLogger(CompletableFuturesTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            beautifiedOutput.append("*").append(i).append("*");
        }
        
        return beautifiedOutput.toString();
//        return "+=+=+=+= --> " + input + " <-- =+=+=+=+";
    }

    @Test
    public void simplePipelineWithBeautifySlow() throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(this::stringSupplier).thenApply(this::beautifyOutputSlow).thenAccept(this::consumer).get();
    }
    
    @Test
    public void simplePipelineWithBeautifySlowAsync() throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(this::stringSupplier).thenApplyAsync(this::beautifyOutputSlow).thenAccept(this::consumer).get();
    }
}
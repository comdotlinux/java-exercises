package com.linux.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abusing Unit tests for {@linkplain CompletableFutures}
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class CompletableFuturesTest {
    private static final Logger log = LoggerFactory.getLogger(CompletableFuturesTest.class);

    private static final int SUPPLIER_WAIT_TIME_IN_MILLIS = 20;
    private static final int WAIT_TIME_1000_IN_MILLIS = 10;
    
//    @org.junit.jupiter.api.BeforeEach
//    public void setUp() {
//    }
    
    @Test
    public void simplePipeline() throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(this::stringSupplier).thenAccept(log::info).get();
    }
     
    String stringSupplier() {
        try {
            Thread.sleep(SUPPLIER_WAIT_TIME_IN_MILLIS);
        } catch (InterruptedException ex) {
            log.error("", ex);
        }
        return "Java rocks " + System.currentTimeMillis();
    }
    
    @Test
    public void simplePipelineWithApply() throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(this::stringSupplier).thenApply(this::beautifyOutput).thenAccept(log::info).get();
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
                log.error("", ex);
            }
            beautifiedOutput.append("*").append(i).append("*");
        }
        beautifiedOutput.append("|> ").append(input).append(" <|");
        for (int i = 10; i < 20; i++) {
            try {
                Thread.sleep(i * WAIT_TIME_1000_IN_MILLIS);
            } catch (InterruptedException ex) {
                log.error("", ex);
            }
            beautifiedOutput.append("*").append(i).append("*");
        }
        
        return beautifiedOutput.toString();
//        return "+=+=+=+= --> " + input + " <-- =+=+=+=+";
    }

    @Test
    public void simplePipelineWithBeautifySlow() throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(this::stringSupplier).thenApply(this::beautifyOutputSlow).thenAccept(log::info).get();
    }
    
    @Test
    public void simplePipelineWithBeautifySlowAsync() throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(this::stringSupplier).thenApplyAsync(this::beautifyOutputSlow).thenAccept(log::info).get();
    }
}
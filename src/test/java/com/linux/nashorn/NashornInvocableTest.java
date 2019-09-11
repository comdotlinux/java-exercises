/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linux.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class NashornInvocableTest {

    private ScriptEngine engine;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        ScriptEngineManager sem = new ScriptEngineManager();
        this.engine = sem.getEngineByName("javascript");
        assertThat(engine, is(notNullValue()));
        final String engineName = engine.getClass().getName();
        System.out.println("NashornInvocableTest.checkEngineName() -> " + engineName);
        assumeThat("Skipping test since script engine is not nashorn", engineName, containsString("nashorn"));

    }

    @Test
    public void usefulInterfaces() throws ScriptException {
        Runnable runnable = getRunnable();
        assertThat(runnable, notNullValue());
        runnable.run();
    }

    private Runnable getRunnable() throws ScriptException {
        Invocable invocable = (Invocable) engine;
        engine.eval("function run(){print('Running asynchronusly with javascript');}");
        return invocable.getInterface(Runnable.class);
    }
}

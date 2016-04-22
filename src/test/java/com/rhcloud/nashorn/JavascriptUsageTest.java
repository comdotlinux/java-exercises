/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhcloud.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class JavascriptUsageTest {

    private ScriptEngine engine;

    @Before
    public void setUp() {
        ScriptEngineManager sem = new ScriptEngineManager();
        this.engine = sem.getEngineByName("javascript");
    }

    @Test
    public void testJavascript() {
        Object eval = null;
        try {
            Path file = Paths.get("src/test/resources", "com/rhcloud/nashorn/test.js");
            eval = engine.eval(new FileReader(file.toFile()));
        } catch (ScriptException | FileNotFoundException ex) {
            throw new IllegalStateException(ex);
        }

        String actual = null;
        if (eval instanceof String) {
            actual = (String) eval;
        }

        assertThat(actual, is("42"));
    }

    @Test
    public void testJavascriptFunctions_add() {
        Object eval = null;
        try {
            Path file = Paths.get("src/test/resources", "com/rhcloud/nashorn/calculator.js");
            engine.eval(new FileReader(file.toFile()));
            eval = engine.eval("add(10,10);");
        } catch (ScriptException | FileNotFoundException ex) {
            throw new IllegalStateException(ex);
        }

        Long actual = null;
        if (eval instanceof Long) {
            actual = (Long) eval;
        }

        assertThat(actual, is(20L));
    }
    
    @Test
    public void testJavascriptFunctions_subtract() {
        Object eval = null;
        try {
            Path file = Paths.get("src/test/resources", "com/rhcloud/nashorn/calculator.js");
            engine.eval(new FileReader(file.toFile()));
            eval = engine.eval("subtract(50,25);");
        } catch (ScriptException | FileNotFoundException ex) {
            throw new IllegalStateException(ex);
        }

        Long actual = null;
        if (eval instanceof Long) {
            actual = (Long) eval;
        }

        assertThat(actual, is(25L));
    }

}

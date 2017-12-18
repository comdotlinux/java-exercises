package com.linux.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
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
        assertThat(this.engine, is(notNullValue()));
        assertThat(this.engine.getClass().getName(), containsString("nashorn"));
    }

    @Test
    public void testJavascript() throws FileNotFoundException, ScriptException {
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/test.js");
        Object eval = engine.eval(new FileReader(file.toFile()));

        String actual = null;
        if (eval instanceof String) {
            actual = (String) eval;
        }

        assertThat(actual, is("42"));
    }

    @Test
    public void testJavascriptFunctions_add() throws FileNotFoundException, ScriptException {
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/calculator.js");
        engine.eval(new FileReader(file.toFile()));
        Object eval = engine.eval("add(10,10);");

        Double actual = null;
        if (eval instanceof Double) {
            actual = (Double) eval;
        }

        assertThat(actual, is(20D));
    }

    @Test
    public void testJavascriptFunctions_subtract() throws FileNotFoundException, ScriptException {
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/calculator.js");
        engine.eval(new FileReader(file.toFile()));
        Object eval = engine.eval("subtract(50,25);");

        Double actual = null;
        if (eval instanceof Double) {
            actual = (Double) eval;
        }

        assertThat(actual, is(25D));
    }

    @Test
    public void javascriptFunctions_variables_input() throws FileNotFoundException, ScriptException {
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/calculator.js");
        engine.eval(new FileReader(file.toFile()));
        engine.put("opr1", 125);
        engine.put("opr2", 5);
        engine.put("opr3", 5);
        Object eval = engine.eval("multiply(divide(opr1,opr2), opr3);");

        assertThat(eval, instanceOf(Double.class));
        Double actual = null;
        if (eval instanceof Double) {
            actual = (Double) eval;
        }

        assertThat(actual, is(125D));
    }

    @Test
    public void usingJavaObjectsInNashorn() throws ScriptException {
        final Date date = new Date();
        
        engine.put("date", date.getTime());
        engine.put("nanoTime", System.nanoTime());
        
        Object eval = engine.eval("date === nanoTime");
        Boolean actual = Boolean.valueOf(eval.toString());
        assertThat(actual, is(false));
    }
    
    
}

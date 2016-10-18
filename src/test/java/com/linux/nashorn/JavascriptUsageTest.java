package com.linux.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import static org.hamcrest.CoreMatchers.containsString;
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
        Object eval = null;
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/test.js");
        eval = engine.eval(new FileReader(file.toFile()));

        String actual = null;
        if (eval instanceof String) {
            actual = (String) eval;
        }

        assertThat(actual, is("42"));
    }

    @Test
    public void testJavascriptFunctions_add() throws FileNotFoundException, ScriptException {
        Object eval = null;
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/calculator.js");
        engine.eval(new FileReader(file.toFile()));
        eval = engine.eval("add(10,10);");

        Double actual = null;
        if (eval instanceof Double) {
            actual = (Double) eval;
        }

        assertThat(actual, is(20D));
    }

    @Test
    public void testJavascriptFunctions_subtract() throws FileNotFoundException, ScriptException {
        Object eval = null;
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/calculator.js");
        engine.eval(new FileReader(file.toFile()));
        eval = engine.eval("subtract(50,25);");

        Double actual = null;
        if (eval instanceof Double) {
            actual = (Double) eval;
        }

        assertThat(actual, is(25D));
    }

    @Test
    public void javascriptFunctions_variables_input() throws FileNotFoundException, ScriptException {
        Object eval = null;
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/calculator.js");
        engine.eval(new FileReader(file.toFile()));
        engine.put("opr1", 125);
        engine.put("opr2", 5);
        engine.put("opr3", 5);
        eval = engine.eval("multiply(divide(opr1,opr2), opr3);");

        assertThat(eval.getClass().getName(), is(Double.class.getName()));
        Double actual = null;
        if (eval instanceof Double) {
            actual = (Double) eval;
        }

        assertThat(actual, is(125D));
    }

}

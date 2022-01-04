package com.linux.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assumptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class JavascriptUsageTest {

    private ScriptEngine engine;

    @BeforeEach
    public void setUp() {
        ScriptEngineManager sem = new ScriptEngineManager();
        this.engine = sem.getEngineByName("javascript");
        assertThat(this.engine).isNotNull();
        assumeThat(this.engine.getClass().getName()).contains("nashorn");
    }

    @Test
    public void testJavascript() throws FileNotFoundException, ScriptException {
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/test.js");
        Object eval = engine.eval(new FileReader(file.toFile()));

        String actual = null;
        if (eval instanceof String) {
            actual = (String) eval;
        }

        assertThat(actual).isEqualTo("42");
    }

    @Test
    public void testJavascriptFunctions_add() throws FileNotFoundException, ScriptException {
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/calculator.js");
        engine.eval(new FileReader(file.toFile()));
        Object eval = engine.eval("add(10,10);");

        Integer actual = null;
        if (eval instanceof Integer) {
            actual = (Integer) eval;
        }

        assertThat(actual).isEqualTo(20);
    }

    @Test
    public void testJavascriptFunctions_subtract() throws FileNotFoundException, ScriptException {
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/calculator.js");
        engine.eval(new FileReader(file.toFile()));
        Object eval = engine.eval("subtract(50,25);");

        assertThat(eval).isInstanceOf(Integer.class);

        Integer actual = (Integer) eval;
        assertThat(actual).isEqualTo(25);
    }

    @Test
    public void javascriptFunctions_variables_input() throws FileNotFoundException, ScriptException {
        Path file = Paths.get("src/test/resources", "com/linux/nashorn/calculator.js");
        engine.eval(new FileReader(file.toFile()));
        engine.put("opr1", 125);
        engine.put("opr2", 5);
        engine.put("opr3", 5);
        Object eval = engine.eval("multiply(divide(opr1,opr2), opr3);");

        assertThat(eval).isInstanceOf(Integer.class);

        Integer actual = (Integer) eval;

        assertThat(actual).isEqualTo(125);
    }

    @Test
    public void usingJavaObjectsInNashorn() throws ScriptException {
        final Date date = new Date();

        engine.put("date", date.getTime());
        engine.put("nanoTime", System.nanoTime());

        Object eval = engine.eval("date === nanoTime");
        Boolean actual = Boolean.valueOf(eval.toString());
        assertThat(actual).isFalse();
    }


}

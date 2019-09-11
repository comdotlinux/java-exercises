package com.linux.test.panel;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Bytebuddy is not properly setup")
public class MyPanelTest {

    public static class TanPanel {

        public TanPanel() {
            System.out.println("Mocked Tan Panel");
        }
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpBeforeClass() throws NoSuchMethodException, SecurityException {
        new ByteBuddy()
                .subclass(com.linux.test.panel.TanPanel.class)
                .constructor(ElementMatchers.isDefaultConstructor())
                .intercept(FixedValue.value(new com.linux.test.panel.MyPanelTest.TanPanel()))
                .make()
                .load(MyPanelTest.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER);
    }

    @Test
    public void testMyPanel() {
        MyPanel panel = new MyPanel();
        assertThat(panel.toString(), is(notNullValue()));
    }
}

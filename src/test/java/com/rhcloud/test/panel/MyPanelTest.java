package com.rhcloud.test.panel;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class MyPanelTest {

	public static class TanPanel {
		public TanPanel() {
			System.out.println("Mocked Tan Panel");
		}
	}

	@BeforeClass
	public static void setUpBeforeClass() throws NoSuchMethodException, SecurityException {
		new ByteBuddy()
			.subclass(com.rhcloud.test.panel.TanPanel.class)
			.constructor(ElementMatchers.isDefaultConstructor())
			.intercept(FixedValue.value(new com.rhcloud.test.panel.MyPanelTest.TanPanel()))
			.make()
			.load(MyPanelTest.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER);
	}

	@Test
	public void testMyPanel() {
		MyPanel panel = new MyPanel();
		assertThat(panel.toString(), is(notNullValue()));
	}
}

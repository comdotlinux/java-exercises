package com.rhcloud.test.panel;

import static org.junit.Assert.*;

import org.junit.Test;

public class TanPanelTest {

	@Test(expected = NullPointerException.class)
	public void test() {
		new TanPanel();
	}

}

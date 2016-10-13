package com.linux.test.panel;

import com.linux.test.panel.TanPanel;
import static org.junit.Assert.*;

import org.junit.Test;

public class TanPanelTest {

	@Test(expected = NullPointerException.class)
	public void test() {
		new TanPanel();
	}

}

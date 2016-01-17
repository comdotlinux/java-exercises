package com.rhcloud.test.panel;

public class MyPanel {

	public MyPanel() {
		System.out.println("In My Panel before Tan Panel");
		TanPanel tanPanel = new TanPanel();
		System.out.println("In My Panel after Tan Panel");
	}
}

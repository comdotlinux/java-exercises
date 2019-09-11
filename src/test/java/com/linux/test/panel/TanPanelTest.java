package com.linux.test.panel;

import org.junit.jupiter.api.Assertions;

public class TanPanelTest {

    public void test() {
        Assertions.assertThrows(NullPointerException.class, TanPanel::new);
    }

}

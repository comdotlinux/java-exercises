package com.rhcloud.test.jsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guru.a.kulkarni
 */
public class JsoupTest {

    private static final String URL = "www.google.com";
    private static Document document;
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        document = Jsoup.connect(URL).get();
    }
    
    @AfterClass
    public static void tearDownClass() {
        document = null;
    }
    
    @Before
    public void setUp() {
//        document.
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

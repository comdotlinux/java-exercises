package com.linux.test.jsoup;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author guru.a.kulkarni
 */
public class JsoupTest {

    private static final String URL = "http://www.xe.com/currencycharts/";
    private static Document document;

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws IOException {
        document = Jsoup.connect(URL).get();
    }

    @AfterClass
    public static void tearDownClass() {
        document = null;
    }
    private Elements elements;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        assertThat(document.childNodeSize(), is(not(0)));
        elements = document.select("table#crLive.liveCurrencyRates tr td");
    }

    @After
    public void tearDown() {
        elements = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testJsoup() {
        assertThat(document.childNodeSize(), is(not(0)));
        elements.forEach(this::printHtml);
    }

    private void printHtml(Element e) {
        System.out.println("accept() before");
        System.out.println(e.html());
        System.out.println("accept() after");
    }
    
    @Test
    public void getDataInPojo() {
        assertThat(document.childNodeSize(), is(not(0)));
        elements.stream().map(this::get).forEach(c -> System.out.println(c));
    }
    
    private ConversionRates get(Element e) {
        assertThat(e, is(notNullValue()));
        System.out.println("com.linux.test.jsoup.JsoupTest.get()" + e);
        return new ConversionRates(e.data(), "EUR", "USD");
    }
    
    class ConversionRates {
        private String relativeUrl;
        private String currencyFrom;
        private String currencyTo;

        public ConversionRates(String relativeUrl, String currencyFrom, String currencyTo) {
            this.relativeUrl = relativeUrl;
            this.currencyFrom = currencyFrom;
            this.currencyTo = currencyTo;
        }

        @Override
        public String toString() {
            return "ConversionRates{" + "relativeUrl=" + relativeUrl + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo + '}';
        }
        
        public String getRelativeUrl() {
            return relativeUrl;
        }

        public String getCurrencyFrom() {
            return currencyFrom;
        }

        public String getCurrencyTo() {
            return currencyTo;
        }
        
        
    }
}

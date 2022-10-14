package ru.mirea;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestCurrency extends TestCase {
    private static final String TEST_REQUEST = "https://api.apilayer.com/currency_data/historical?apikey=DlfFoDe9TUUhzkH7eSL6OTXSQuDsNlDY&date=2018-02-22&currencies=EUR,GBP,JPY&source=USD";

    @Test
    public void testJsonConverter(){
        Map<String, Object> map = new HashMap<>();
        map.put("123", 123.0);
        String json = "{\"123\":123}";
        assertEquals(map, Converter.toMap(json));
    }

    @Test
    public void testParseAPI() throws IOException {
        assertTrue((Boolean) Currency.parseAPI(TEST_REQUEST).get("success"));
    }

    @Test
    public void testGetCurrencyRate(){
        String json = "{\"success\": true, \"quotes\": {\"2016-02-25\": {\"RUBUSD\": 0.013228}}}";
        Map<String, Object> map = new HashMap<>();
        map.put("2016-02-25", 0.013228);
        assertEquals(map,Currency.getCurrencyRate(Converter.toMap(json), "rub", "usd"));
    }

    @Test
    public void testGetCurrencyRate2(){
        String json = "{\"success\": false, \"quotes\": {\"2016-02-25\": {\"RUBUSD\": 0.013228}}}";
        assertNull(Currency.getCurrencyRate(Converter.toMap(json), "rub", "usd"));

    }

}

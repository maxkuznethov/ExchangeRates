package ru.mirea;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestCurrency extends TestCase {
    private static final String TEST_REQUEST = "https://api.apilayer.com/currency_data/timeframe?start_date=2016-02-25&end_date=2017-02-21&currencies=USD&source=RUB";

    @Test
    public void testJsonConverter(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("123", 123);
        String json = "{\"123\":123}";
        assertEquals(map, Converter.toMap(json));
    }

}

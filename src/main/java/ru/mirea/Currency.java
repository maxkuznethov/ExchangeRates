package ru.mirea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Currency {

    /**
     * Получает данные с API
     *
     * @param request GET запрос
     * @return ответ с API
     */
    public static Map<String, Object> parseAPI(String request) throws IOException {
        StringBuilder result = new StringBuilder();
        URLConnection connection = new URL(request).openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            while (reader.ready()) {
                result.append(reader.readLine());
            }
        }
        return Converter.toMap(result.toString());
    }

    /**
     * Получает данные о курсе
     *
     * @param map ответ с API
     * @param currency1 первая валюта
     * @param currency2 вторая валюта
     * @return курс первой валюты ко второй
     */
    public static Map<String, Double> getCurrencyRate(Map<String, Object> map, String currency1, String currency2){
        if(!(Boolean) map.get("success")) return null;
        String rateKey = currency1.toUpperCase()+currency2.toUpperCase();
        Map<String, Map<String, Double>> quotes= (Map<String, Map<String, Double>>) map.get("quotes");
        Map<String, Double> currencyRate = new HashMap<>();
        quotes.forEach((k,v)-> currencyRate.put(k, v.get(rateKey)));
        return new TreeMap<>(currencyRate);

    }
}

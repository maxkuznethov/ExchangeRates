package ru.mirea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class Currency {

    public static Map<String,Object> parseAPI(String request) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL(request);
        URLConnection connection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null)
            result.append(line);
        reader.close();
        String stringResult = result.toString();
        Map<String, Object> resultMap = Converter.toMap(stringResult);
        return resultMap;
    }
}

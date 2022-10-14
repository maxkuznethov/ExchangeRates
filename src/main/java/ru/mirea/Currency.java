package ru.mirea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class Currency {

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
}

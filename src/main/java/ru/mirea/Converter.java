package ru.mirea;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    /**
     * Конвертирует json строку в слвоврь
     *
     * @param str json строка
     * @return полученный словарь
     */
    public static Map<String, Object> toMap(String str){
        return new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
    }
}

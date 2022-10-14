package ru.mirea;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    public static Map<String, Object> toMap(String str){
        return new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
    }
}

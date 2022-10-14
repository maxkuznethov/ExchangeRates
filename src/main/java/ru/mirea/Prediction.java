package ru.mirea;

import java.util.List;

public class Prediction {

    public static double calculateAvg(List<Double> list){
        double result = 0;
        for (int i = 1; i <list.size() ; i++) {
            result+= list.get(i)-list.get(i-1);
        }
        return result/(list.size()-1);
    }
}

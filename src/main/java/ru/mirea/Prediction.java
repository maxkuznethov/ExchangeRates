package ru.mirea;

import java.util.ArrayList;
import java.util.List;

public class Prediction {

    protected static double calculateAvg(List<Double> list){
        double result = 0;
        for (int i = 1; i <list.size() ; i++) {
            result+= list.get(i)-list.get(i-1);
        }
        return result/(list.size()-1);
    }

    public static List<Double> calculatePrediction(List<Double> currencyRate, int days){
        double avgChange = calculateAvg(currencyRate);
        List<Double> result = new ArrayList<>();
        double lastRate = currencyRate.get(currencyRate.size()-1);
        for (int i = 1; i <= days; i++) {
            result.add(lastRate+avgChange*i);
        }
        return result;
    }
}

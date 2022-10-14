package ru.mirea;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите валюты");
        String cur1 = scanner.nextLine();
        String cur2 = scanner.nextLine();
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(6);
        String request = String.format("https://api.apilayer.com/currency_data/timeframe?apikey=DlfFoDe9TUUhzkH7eSL6OTXSQuDsNlDY&start_date=%s&end_date=%s&currencies=%s&source=%s",
                startDate, endDate, cur1, cur2);
        Map<String, Double> currencyRate = Currency.getCurrencyRate(Currency.parseAPI(request), cur2, cur1);
        if (currencyRate != null) {
            List<Double> currencyRateList = new ArrayList<>();
            System.out.println("История курса:");
            currencyRate.forEach((k, v) -> {
                System.out.println(k + " : " + v);
                currencyRateList.add(v);
            });

            System.out.println("Прогноз будущего курса:");
            List<Double> predictionList = Prediction.calculatePrediction(currencyRateList, 3);
            for (int i = 0; i < predictionList.size(); i++) {
                System.out.println(endDate.plusDays(i+1)+" : "+predictionList.get(i));
            }
        }
        else {
            System.out.println("Некоректные данные");
        }
    }
}

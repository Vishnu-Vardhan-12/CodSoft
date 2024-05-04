package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONObject;

public class CurrencyConverter {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> currencyCodes = new HashMap<>();
        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "INR");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "AED");
        currencyCodes.put(5, "JPY");

        String fromCode, toCode;
        double amount;

        System.out.println("\n\n WELCOME TO CURRENCY CONVERTER");

        System.out.println("Currency converting from?");
        System.out.println("1.USD (US Dollar)\n2.INR (Indian Rupees) \n3.EUR (Euro) \n4.AED (Dubai) \n5.JPY (Japan)");
        fromCode = currencyCodes.get(sc.nextInt());
        System.out.println("Currency converting to?");
        System.out.println("1.USD (US Dollar)\n2.INR (Indian Rupees) \n3.EUR (Euro) \n4.AED (Dubai) \n5.JPY (Japan)");
        toCode = currencyCodes.get(sc.nextInt());

        System.out.println("Amount to be converted?");
        amount = sc.nextDouble();

        sendHttpGETRequest(fromCode, toCode, amount);
        System.out.println("Thanks for using the CURRENCY CONVERTER");
    }

    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {
        String apiKey = "cur_live_BJ5LV8XW4YHRCTg8BvTyqTK1wjeRQ1zhq3riYMhb";
        String encodedFromCode = URLEncoder.encode(fromCode, "UTF-8");
        String encodedToCode = URLEncoder.encode(toCode, "UTF-8");
        String GET_URL = "https://api.currencyapi.com/v3/latest?apikey=" + apiKey + "&currencies=" + encodedToCode + "&base_currency=" + encodedFromCode;

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject obj = new JSONObject(response.toString());
            double exchangeRate = obj.getJSONObject("rates").getDouble(toCode);
            System.out.println(obj.getJSONObject("rates"));
            System.out.println(exchangeRate);
            System.out.println();
            System.out.println(amount + " " + fromCode + " = " + amount * exchangeRate + " " + toCode);
        } else {
            System.out.println("Get request failed");
        }
    }
}

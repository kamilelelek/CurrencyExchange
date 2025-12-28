package org.example;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class NbpApiClient {
    private static final String NBP_URL = "https://api.nbp.pl/api/exchangerates/tables/A?format=json";

    private final HttpClient httpClient;
    private final Gson gson;

    public NbpApiClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    // DO EDYTOWANIA - brakuje danych wejściwocyhc do funkcji
    public  List<ExchangeTable> getExchangeTable() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(NBP_URL))
                .GET()
                .build();

        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("API returned error: " + response.statusCode());
        }

        Type listType = new TypeToken<List<ExchangeTable>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public double getExchangeRate(Currency from, Currency to) {
        double exchangeRate = 0;
        try {
            String urlString = "https://api.exchangerate-api.com/v4/latest/" + from;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            //parser tu nizej
            String jsonResponse = response.toString();
            // odpowiedz typu  "AED":3.6725,
            int startIndex = jsonResponse.indexOf(String.valueOf(to));

            int endIndex = jsonResponse.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = jsonResponse.indexOf("}", startIndex);
            }

            String exchangeRateString = jsonResponse.substring(startIndex + 5, endIndex);
            exchangeRate = Double.parseDouble(exchangeRateString);
            System.out.println("Kurs wymiany " + from + " na " + to + ": " + exchangeRate);

        } catch (Exception e) {
            System.out.println("Błąd podczas pobierania kursu wymiany: " + e.getMessage());
        }
        return exchangeRate;
    }

    }

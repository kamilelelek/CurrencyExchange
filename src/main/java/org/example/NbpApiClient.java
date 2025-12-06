package org.example;

import org.example.ExchangeTable;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.net.URI;
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

    public  List<ExchangeTable> getExchangeRates() throws Exception {

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
}

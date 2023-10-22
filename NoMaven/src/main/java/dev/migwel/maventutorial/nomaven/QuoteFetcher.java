package dev.migwel.maventutorial.nomaven;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

class QuoteFetcher {
    private static final String API_URL = "https://type.fit/api/quotes";
    private final ObjectMapper objectMapper;
    private final HttpClient httpClient;

    public QuoteFetcher() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        this.objectMapper = new ObjectMapper();
    }

    public QuoteFetcher(ObjectMapper objectMapper, HttpClient httpClient) {
        this.objectMapper = objectMapper;
        this.httpClient = httpClient;
    }

    public Quote getRandomQuote() {
        HttpRequest request = HttpRequest.newBuilder(URI.create(API_URL)).build();
        String responseStr;
        try {
            responseStr = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .get(60, TimeUnit.SECONDS);
            List<Quote> quotes = objectMapper.readValue(responseStr, new TypeReference<>() {});
            Random rand = new Random();
            return quotes.get(rand.nextInt(quotes.size()));
        } catch (InterruptedException | ExecutionException | TimeoutException | JsonProcessingException e) {
            return new Quote("Impossible d'obtenir une citation", "Mark Twain");
        }
    }
}
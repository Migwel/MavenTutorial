package dev.migwel.maventutorial.nomaven;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuoteFetcherTests {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient httpClient = mock(HttpClient.class);
    private final QuoteFetcher quoteFetcher = new QuoteFetcher(objectMapper, httpClient);

    @BeforeEach
    void init() {
        final String quotes = "[{\"text\":\"Alea Jacta Est\", \"author\": \"Julius Caesar\"}]";
        HttpResponse<Object> response = createResponse(quotes);
        when(httpClient.sendAsync(any(), any())).thenReturn(CompletableFuture.supplyAsync(() -> response));
    }

    private <T> HttpResponse<T> createResponse(T body) {
        return new HttpResponse<T>() {
            @Override
            public int statusCode() {
                return 2000;
            }

            @Override
            public HttpRequest request() {
                return null;
            }

            @Override
            public Optional<HttpResponse<T>> previousResponse() {
                return Optional.empty();
            }

            @Override
            public HttpHeaders headers() {
                return null;
            }

            @Override
            public T body() {
                return body;
            }

            @Override
            public Optional<SSLSession> sslSession() {
                return Optional.empty();
            }

            @Override
            public URI uri() {
                return null;
            }

            @Override
            public HttpClient.Version version() {
                return null;
            }
        };
    }

    @Test
    public void testRandomQuote() {
        Quote quote = quoteFetcher.getRandomQuote();
        assertEquals("Alea Jacta Est", quote.text());
        assertEquals("Julius Caesar", quote.author());
    }
}

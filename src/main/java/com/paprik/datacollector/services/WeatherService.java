package com.paprik.datacollector.services;

import com.paprik.datacollector.services.url.data.IMGWApiEndpoint;
import lombok.Getter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class WeatherService {
    private final WebClient webClient;

    public WeatherService(WebClient.Builder webClientBuilder , String url) {
        this.webClient = webClientBuilder
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))  // 16 MB
                        .build())
                .baseUrl(url)
                .defaultHeader(HttpHeaders.USER_AGENT, "MyApp/1.0").build();
    }

    protected <T> Mono<ResponseEntity<List<T>>> getDataAsList(IMGWApiEndpoint imgwApiEndpoint, ParameterizedTypeReference<List<T>> responseType) {
        return getData(imgwApiEndpoint, responseType);
    }

    protected  <T>Mono<ResponseEntity<T>> getData(IMGWApiEndpoint imgwApiEndpoint, ParameterizedTypeReference<T> responseType) {
        return webClient.method(imgwApiEndpoint.getRestMethod())
                .uri(imgwApiEndpoint.getUrlPath())
                .retrieve()

                .bodyToMono(responseType)
                .map(ResponseEntity::ok)
                .onErrorResume(error -> Mono.just(ResponseEntity.status(500).body(null)));
    }
}

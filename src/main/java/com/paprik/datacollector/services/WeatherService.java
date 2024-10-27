package com.paprik.datacollector.services;

import com.paprik.datacollector.records.MeteoRecord;
import com.paprik.datacollector.services.url.data.IMGWApiEndpoint;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
@Log4j2
public class WeatherService {
    private final WebClient webClient;

    public WeatherService(WebClient.Builder webClientBuilder , String url) {
        this.webClient = webClientBuilder
//                .exchangeStrategies(ExchangeStrategies.builder()
//                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))  // 16 MB
//                        .build())
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
                .map(ResponseEntity::ok);
    }

    protected <T> Flux<T> getFluxData(IMGWApiEndpoint imgwApiEndpoint, ParameterizedTypeReference<T> responseType) {
        return webClient.method(imgwApiEndpoint.getRestMethod())
                .uri(imgwApiEndpoint.getUrlPath())
                .retrieve()
                .bodyToFlux(responseType)
                .doOnNext(record -> log.info("Received record: {}", record))
                .doOnError(error -> log.error("Error fetching data: ", error));
    }

    public Flux<MeteoRecord> getMeteoDataFlux(){
        IMGWApiEndpoint imgwApiEndpoint =IMGWApiEndpoint.METEO_DATA;
        Flux<MeteoRecord> meteoRecordFlux = getFluxData(imgwApiEndpoint, new ParameterizedTypeReference<>() {});
        return meteoRecordFlux ;
    }
}

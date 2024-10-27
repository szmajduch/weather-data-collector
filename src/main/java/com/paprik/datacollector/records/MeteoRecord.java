package com.paprik.datacollector.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MeteoRecord(@JsonProperty("kod_stacji") String stationCode,
                          @JsonProperty("nazwa_stacji") String stationName,
                          @JsonProperty("lon") Double longitude,
                          @JsonProperty("lat") Double latitude,
                          @JsonProperty("temperatura_gruntu") Double groundTemperature,
                          @JsonProperty("temperatura_gruntu_data") String groundTemperatureDate,
                          @JsonProperty("wiatr_kierunek") Double windDirection,
                          @JsonProperty("wiatr_kierunek_data") String windDirectionDate,
                          @JsonProperty("wiatr_srednia_predkosc") Double averageWindSpeed,
                          @JsonProperty("wiatr_srednia_predkosc_data") String averageWindSpeedDate,
                          @JsonProperty("wiatr_predkosc_maksymalna") Double maxWindSpeed,
                          @JsonProperty("wiatr_predkosc_maksymalna_data") String maxWindSpeedDate,
                          @JsonProperty("wilgotnosc_wzgledna") Double relativeHumidity,
                          @JsonProperty("wilgotnosc_wzgledna_data") String relativeHumidityDate,
                          @JsonProperty("wiatr_poryw_10min") Double windGust10min,
                          @JsonProperty("wiatr_poryw_10min_data") String windGust10minDate,
                          @JsonProperty("opad_10min") Double precipitation10min,
                          @JsonProperty("opad_10min_data") String precipitation10minDate) {
}

package com.paprik.datacollector.records;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
public record WeatherStationRecord(
        @JsonProperty("id_stacji") String stationId,
        @JsonProperty("stacja") String stationName,
        @JsonProperty("data_pomiaru") LocalDate measurementDate,
        @JsonProperty("godzina_pomiaru") Integer measurementHour,
        @JsonProperty("temperatura") Double temperature,
        @JsonProperty("predkosc_wiatru") Double windSpeed,
        @JsonProperty("kierunek_wiatru") Integer windDirection,
        @JsonProperty("wilgotnosc_wzgledna") Double humidity,
        @JsonProperty("suma_opadu") Double precipitation,
        @JsonProperty("cisnienie") Double pressure
) {}
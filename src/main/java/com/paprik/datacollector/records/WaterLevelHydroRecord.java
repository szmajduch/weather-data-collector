package com.paprik.datacollector.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WaterLevelHydroRecord(@JsonProperty("kod_stacji") String stationCode,
                                    @JsonProperty("nazwa_stacji") String stationName,
                                    @JsonProperty("lon") Double longitude,
                                    @JsonProperty("lat") Double latitude,
                                    @JsonProperty("stan") Integer waterLevel,
                                    @JsonProperty("stan_data") String waterLevelDate,
                                    @JsonProperty("przelyw") Double flowRate,
                                    @JsonProperty("przeplyw_data") String flowRateDate) {
}

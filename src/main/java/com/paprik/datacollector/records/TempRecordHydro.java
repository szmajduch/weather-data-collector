package com.paprik.datacollector.records;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paprik.datacollector.mapper.BooleanDeserializer;

public record TempRecordHydro(@JsonProperty("id_stacji") String stationId,
                              @JsonProperty("stacja") String stationName,
                              @JsonProperty("rzeka") String riverName,
                              @JsonProperty("wojew\u00f3dztwo") String province,
                              @JsonProperty("stan_wody") Integer waterLevel,
                              @JsonProperty("stan_wody_data_pomiaru") String waterLevelMeasurementDate,
                              @JsonProperty("temperatura_wody") Double waterTemperature,
                              @JsonProperty("temperatura_wody_data_pomiaru") String waterTemperatureMeasurementDate,
                              @JsonDeserialize(using = BooleanDeserializer.class) @JsonProperty("zjawisko_lodowe") Boolean icePhenomenon,
                              @JsonProperty("zjawisko_lodowe_data_pomiaru") String icePhenomenonMeasurementDate,
                              @JsonDeserialize(using = BooleanDeserializer.class) @JsonProperty("zjawisko_zarastania") Boolean overgrowthPhenomenon,
                              @JsonProperty("zjawisko_zarastania_data_pomiaru") String overgrowthPhenomenonMeasurementDate) {
}

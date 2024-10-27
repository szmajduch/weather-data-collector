package com.paprik.datacollector.services.url.data;

import com.paprik.datacollector.records.WeatherStationRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpMethod;

@Getter
@AllArgsConstructor
public enum IMGWApiEndpoint {
    SYNOP_DATA("Synop Data", "/synop", HttpMethod.GET),
    SYNOP_DATA_BY_FORMAT("Synop Data by format", "/synop/format/{format}", HttpMethod.GET),
    SYNOP_DATA_BY_ID("Synop Data by ID", "/synop/id/{id}", HttpMethod.GET),
    SYNOP_DATA_BY_STATION("Synop Data by Station", "/synop/station/{station}", HttpMethod.GET),
    SYNOP_DATA_BY_ID_AND_FORMAT("Synop Data by ID and format", "/synop/id/{id}/format/{format}", HttpMethod.GET),
    //CHeck id and another things
    HYDRO_DATA("Hydro Data Temperature", "/hydro", HttpMethod.GET),
    HYDRO_DATA_2("Hydro Data 2 water level", "/hydro2", HttpMethod.GET),
    METEO_DATA("Meteo Data", "/meteo", HttpMethod.GET),
    WARNINGS_METEO("Meteo Warnings", "/warningsmeteo", HttpMethod.GET),//TODO: work on that later
    WARNINGS_HYDRO("Hydro Warnings", "/warningshydro", HttpMethod.GET);

    private final String name;
    private final String urlPath;
    private final HttpMethod restMethod;
}

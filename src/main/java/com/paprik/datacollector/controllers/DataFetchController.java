package com.paprik.datacollector.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paprik.datacollector.entities.StationEntity;
import com.paprik.datacollector.mapper.StationMapper;
import com.paprik.datacollector.records.TempRecordHydro;
import com.paprik.datacollector.records.WaterLevelHydroRecord;
import com.paprik.datacollector.records.MeteoRecord;
import com.paprik.datacollector.records.WeatherStationRecord;
import com.paprik.datacollector.services.IMGWWeatherService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Log4j2
public class DataFetchController {

    StationMapper stationMapper;
    IMGWWeatherService IMGWWeatherService;
    @GetMapping("/stations")
    List<StationEntity> getStations() throws JsonProcessingException {
        //weather station working
        List<WeatherStationRecord> stationRecordList = IMGWWeatherService.getStationData().block().getBody();
        //water level working
        List<WaterLevelHydroRecord> waterlevelList = IMGWWeatherService.getWaterLevelData().block().getBody();
        List<TempRecordHydro> hydroTempRecords = IMGWWeatherService.getWaterTempData().block().getBody();
        List<MeteoRecord> blockmeteo = IMGWWeatherService.getMeteoData().block().getBody();

        return null;
    }
}

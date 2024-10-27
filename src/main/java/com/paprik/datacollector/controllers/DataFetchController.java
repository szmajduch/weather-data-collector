package com.paprik.datacollector.controllers;

import com.paprik.datacollector.mapper.StationMapper;
import com.paprik.datacollector.records.TempRecordHydro;
import com.paprik.datacollector.records.WaterLevelHydroRecord;
import com.paprik.datacollector.records.MeteoRecord;
import com.paprik.datacollector.records.WeatherStationRecord;
import com.paprik.datacollector.services.IMGWWeatherService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController()
@RequestMapping("/IMGW/live")
@AllArgsConstructor
@Log4j2
public class DataFetchController {

    StationMapper stationMapper;
    IMGWWeatherService IMGWWeatherService;
    @GetMapping("/stations")
    Flux<WeatherStationRecord> getStations() {
        return IMGWWeatherService.getStationData();
    }
    @GetMapping("/water/level")
    Flux<WaterLevelHydroRecord> getWaterLevel() {
        return IMGWWeatherService.getWaterLevelData();
    }

    @GetMapping("/water/temperature")
    Flux<TempRecordHydro> getWaterTemp() {
        return IMGWWeatherService.getWaterTempData();
    }

    @GetMapping("/meteo")
    Flux<MeteoRecord> getMeteo() {
        return IMGWWeatherService.getMeteoData();
    }

    @GetMapping("/flux")
    Flux<MeteoRecord> getMeteoFlux(){
        return IMGWWeatherService.getMeteoDataFlux();
    }
}

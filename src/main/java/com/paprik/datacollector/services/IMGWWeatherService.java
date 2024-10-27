package com.paprik.datacollector.services;

import com.paprik.datacollector.dao.SynopDao;
import com.paprik.datacollector.entities.StationEntity;
import com.paprik.datacollector.records.TempRecordHydro;
import com.paprik.datacollector.records.WaterLevelHydroRecord;
import com.paprik.datacollector.records.MeteoRecord;
import com.paprik.datacollector.records.WeatherStationRecord;
import com.paprik.datacollector.services.url.data.IMGWApiEndpoint;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Log4j2
@Service
public class IMGWWeatherService extends WeatherService {


    @Autowired
    private SynopDao synopDao;
    public void save(List<StationEntity> entities){
        synopDao.saveAll(entities);
    }
    public IMGWWeatherService(WebClient.Builder webClientBuilder) {
        super(webClientBuilder, "https://danepubliczne.imgw.pl/api/data");
    }


    public Mono<ResponseEntity<List<WeatherStationRecord>>> getStationData() {
        return getDataAsList(IMGWApiEndpoint.SYNOP_DATA, new ParameterizedTypeReference<>() {});
    }

    public Mono<ResponseEntity<List<TempRecordHydro>>> getWaterTempData(){
        return getDataAsList(IMGWApiEndpoint.HYDRO_DATA, new ParameterizedTypeReference<>() {});
    }

    public Mono<ResponseEntity<List<WaterLevelHydroRecord>>> getWaterLevelData(){
        return getDataAsList(IMGWApiEndpoint.HYDRO_DATA_2, new ParameterizedTypeReference<>() {});
    }

    public Mono<ResponseEntity<List<MeteoRecord>>> getMeteoData(){
        return getDataAsList(IMGWApiEndpoint.METEO_DATA, new ParameterizedTypeReference<>() {});
    }
}
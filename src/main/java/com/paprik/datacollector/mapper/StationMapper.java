package com.paprik.datacollector.mapper;

import com.paprik.datacollector.entities.StationEntity;
import com.paprik.datacollector.records.WeatherStationRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper {
    StationEntity dtoToEntity(WeatherStationRecord dto);
    WeatherStationRecord entityToDto(StationEntity entity);
}

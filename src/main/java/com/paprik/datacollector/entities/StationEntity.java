package com.paprik.datacollector.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class StationEntity extends Place {
    @Id
    @GeneratedValue
    long id;
    @Column(name = "station_id")
    private String stationId;

    @Column(name = "station_name", length = 100)
    private String stationName;

    @Column(name = "measurement_date")
    private LocalDate measurementDate;

    @Column(name = "measurement_hour")
    private int measurementHour;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "wind_speed")
    private double windSpeed;

    @Column(name = "wind_direction")
    private int windDirection;

    @Column(name = "humidity")
    private double humidity;

    @Column(name = "precipitation")
    private double precipitation;

    @Column(name = "pressure")
    private double pressure;

    @Version
    private int version;
}

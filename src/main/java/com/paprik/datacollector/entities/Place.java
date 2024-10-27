package com.paprik.datacollector.entities;

import jakarta.persistence.Column;

public abstract class Place {
    String name;
//    @Column(name=)
    long longitude;
    long altitude;
}

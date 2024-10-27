package com.paprik.datacollector.services;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2

class WeatherServiceTest {
    @Test
    public void constructUriFromTemplate() {
        String b = "{\"id_stacji\":\"151140030\",\"stacja\":\"Przewoźniki\",\"rzeka\":\"Skroda\",\"województwo\":\"lubuskie\",\"stan_wody\":\"240\",\"stan_wody_data_pomiaru\":\"2024-10-25 22:10:00\",\"temperatura_wody\":null,\"temperatura_wody_data_pomiaru\":null,\"zjawisko_lodowe\":\"0\",\"zjawisko_lodowe_data_pomiaru\":\"2024-01-09 11:00:00\",\"zjawisko_zarastania\":\"0\",\"zjawisko_zarastania_data_pomiaru\":\"2024-10-15 10:00:00\"}";

//        String uriString = UriComponentsBuilder.fromPath("/synop/id/{id}/format/{format}").
//                .buildAndExpand("Kwoka")
//                .toUriString();
//        assertEquals("/junit-5", uriString);
    }
}
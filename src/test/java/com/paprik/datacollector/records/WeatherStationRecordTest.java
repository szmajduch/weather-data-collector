package com.paprik.datacollector.records;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class WeatherStationRecordTest {

    @Test
    void checkMapping(){
        String jsonResponse = "{\"id_stacji\":\"12295\",\"stacja\":\"Białystok\",\"data_pomiaru\":\"2024-10-16\",\"godzina_pomiaru\":\"19\",\"temperatura\":\"1.6\",\"predkosc_wiatru\":\"1\",\"kierunek_wiatru\":\"260\",\"wilgotnosc_wzgledna\":\"95.8\",\"suma_opadu\":\"0.4\",\"cisnienie\":\"1034.2\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            WeatherStationRecord record = objectMapper.readValue(jsonResponse, WeatherStationRecord.class);
            System.out.println(record);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkMappingM(){
        String o ="{\"id_stacji\":\"153140010\",\"stacja\":\"Świnoujście\",\"rzeka\":\"Zatoka Pomorska (ujście Świny)\",\"województwo\":\"zachodniopomorskie\",\"stan_wody\":\"506\",\"stan_wody_data_pomiaru\":\"2024-10-25 22:10:00\",\"temperatura_wody\":\"11.8\",\"temperatura_wody_data_pomiaru\":\"2024-10-25 22:10:00\",\"zjawisko_lodowe\":\"0\",\"zjawisko_lodowe_data_pomiaru\":\"2024-01-21 06:00:00\",\"zjawisko_zarastania\":null,\"zjawisko_zarastania_data_pomiaru\":null}";
        try {
            new ObjectMapper().readValue(o, TempRecordHydro.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void checkMappingMeteo(){
        String k ="{\"kod_stacji\":\"250170110\",\"nazwa_stacji\":\"DOBROGOSZCZ\",\"lon\":\"17.017222\",\"lat\":\"50.758611\",\"temperatura_gruntu\":\"16.17\",\"temperatura_gruntu_data\":\"2024-10-27 08:50:00\",\"wiatr_kierunek\":\"165.2\",\"wiatr_kierunek_data\":\"2024-10-27 08:50:00\",\"wiatr_srednia_predkosc\":\"4.1\",\"wiatr_srednia_predkosc_data\":\"2024-10-27 08:50:00\",\"wiatr_predkosc_maksymalna\":\"5.8\",\"wiatr_predkosc_maksymalna_data\":\"2024-10-27 08:50:00\",\"wilgotnosc_wzgledna\":\"75.49\",\"wilgotnosc_wzgledna_data\":\"2024-10-27 08:50:00\",\"wiatr_poryw_10min\":null,\"wiatr_poryw_10min_data\":null,\"opad_10min\":\"0\",\"opad_10min_data\":\"2024-10-27 08:50:00\"}";
        try {
            new ObjectMapper().readValue(k, MeteoRecord.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
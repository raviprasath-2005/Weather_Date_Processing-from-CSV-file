package com.kce.weather_data_service.util;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kce.weather_data_service.entity.WeatherData;
import com.kce.weather_data_service.repository.WeatherRepository;
import com.opencsv.CSVReader;

@Service
public class CsvService {

    @Autowired
    private WeatherRepository repository;

    public void saveCsvData(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            String[] line;
            reader.readNext();

            while ((line = reader.readNext()) != null) {

                WeatherData data = new WeatherData();

                data.setDatetimeUtc(line[0]);
                data.setConds(line[1]);
                data.setDewptm(parseDouble(line[2]));
                data.setFog(parseInt(line[3]));
                data.setHail(parseInt(line[4]));
                data.setHeatindexm(parseDouble(line[5]));
                data.setHum(parseDouble(line[6]));
                data.setPrecipm(parseDouble(line[7]));
                data.setPressurem(parseDouble(line[8]));
                data.setRain(parseInt(line[9]));
                data.setSnow(parseInt(line[10]));
                data.setTempm(parseDouble(line[11]));
                data.setThunder(parseInt(line[12]));
                data.setTornado(parseInt(line[13]));
                data.setVism(parseDouble(line[14]));
                data.setWdird(parseDouble(line[15]));
                data.setWdire(line[16]);
                data.setWgustm(parseDouble(line[17]));
                data.setWindchillm(parseDouble(line[18]));
                data.setWspdm(parseDouble(line[19]));

                repository.save(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Double parseDouble(String value) {
        try {
            if (value == null || value.isEmpty() || value.equals("-9999"))
                return null;
            return Double.parseDouble(value);
        } catch (Exception e) {
            return null;
        }
    }

    private Integer parseInt(String value) {
        try {
            if (value == null || value.isEmpty())
                return null;
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }
}
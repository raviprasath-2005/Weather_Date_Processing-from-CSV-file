package com.kce.weather_data_service.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.kce.weather_data_service.entity.WeatherData;

@Component
public class CsvService {
    public List<WeatherData> parseCsvFile(MultipartFile file) throws IOException {

        List<WeatherData> weatherDatas = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(file.getInputStream()))) {

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {

//                if (isFirstLine) {
//                    isFirstLine = false;
//                    continue;
//                }
//
                String[] data = line.split(",",-1);
//
                if (data.length < 20) {
                    continue;
                }
//
                LocalDate date = parseDate(data[0]);
                if (date == null) {
                    continue;
                }

                WeatherData weatherData = new WeatherData();


                weatherData.setRecordDate(date);
                weatherData.setYear(date.getYear());
                weatherData.setMonth(date.getMonthValue());
                weatherData.setWeatherCondition(data[1]);

                weatherData.setDewPoint(parseDouble(data[2]));
                weatherData.setFog(parseInteger(data[3]) != null && parseInteger(data[3]) == 1);
                weatherData.setHail(parseInteger(data[4]) != null && parseInteger(data[4]) == 1);
                weatherData.setHeatIndex(parseDouble(data[5]));
                weatherData.setHumidity(parseDouble(data[6]));
                weatherData.setPrecipitation(parseDouble(data[7]));
                weatherData.setPressure(parseDouble(data[8]));
                weatherData.setRain(parseInteger(data[9]) != null && parseInteger(data[9]) == 1);
                weatherData.setSnow(parseInteger(data[10]) != null && parseInteger(data[10]) == 1);
                weatherData.setTemperature(parseDouble(data[11]));
                weatherData.setThunder(parseInteger(data[12]) != null && parseInteger(data[12]) == 1);
                weatherData.setTornado(parseInteger(data[13]) != null && parseInteger(data[13]) == 1);
                weatherData.setVisibility(parseDouble(data[14]));
                weatherData.setWindDirectionDegree(parseInteger(data[15]));
                weatherData.setWindDirectionText(data[16]);
                weatherData.setWindGust(parseDouble(data[17]));
                weatherData.setWindChill(parseDouble(data[18]));
                weatherData.setWindSpeed(parseDouble(data[19]));

                weatherDatas.add(weatherData);


            }
        }

        return weatherDatas;
    }

    private Double parseDouble(String value) {
        if (value == null || value.trim().isEmpty() || value.equals("-9999"))
            return null;

        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer parseInteger(String value) {
        if (value == null || value.trim().isEmpty() || value.equals("-9999"))
            return null;

        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private LocalDate parseDate(String rawDate) {

        if (rawDate == null || rawDate.trim().isEmpty())
            return null;

        rawDate = rawDate.trim();

        try {
            String datePart = rawDate.substring(0, 8);

            return LocalDate.parse(datePart,
                    DateTimeFormatter.ofPattern("yyyyMMdd"));

        } catch (Exception e) {
            return null;
        }
    }

}
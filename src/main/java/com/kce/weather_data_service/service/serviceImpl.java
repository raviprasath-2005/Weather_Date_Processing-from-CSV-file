package com.kce.weather_data_service.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kce.weather_data_service.entity.WeatherData;
import com.kce.weather_data_service.repository.WeatherRepository;
import com.kce.weather_data_service.util.CsvService;
import com.kce.weather_data_service.util.DataLoader;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class serviceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final CsvService csvUtil;

    @Override
    @Transactional
    public String uploadWeatherDataViaCsv(MultipartFile file) {

        try {
            List<WeatherData> weatherDataList =
                    csvUtil.parseCsvFile(file);

            weatherRepository.saveAll(weatherDataList);

            return weatherDataList.size() + " records uploaded successfully";

        } catch (IOException e) {
            throw new RuntimeException("Error processing CSV file", e);
        }
    }

    @Override
    public Page<WeatherData> getWeatherData(
            Integer year,
            Integer month,
            LocalDate date,
            Pageable pageable) {

        Specification<WeatherData> spec =
                Specification.where(DataLoader.hasYear(year))
                        .and(DataLoader.hasMonth(month))
                        .and(DataLoader.hasDate(date));

        return weatherRepository.findAll(spec, pageable);
    }
}
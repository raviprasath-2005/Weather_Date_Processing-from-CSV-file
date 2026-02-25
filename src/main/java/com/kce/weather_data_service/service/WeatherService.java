package com.kce.weather_data_service.service;

import com.kce.weather_data_service.entity.WeatherData;
import com.kce.weather_data_service.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface WeatherService {
    @Transactional
    String uploadWeatherDataViaCsv(MultipartFile file);
    public Page<WeatherData> getWeatherData(
            Integer year,
            Integer month,
            LocalDate date,
            Pageable pageable);
}

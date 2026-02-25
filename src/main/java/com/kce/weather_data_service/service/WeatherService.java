package com.kce.weather_data_service.service;

import com.kce.weather_data_service.entity.WeatherData;
import com.kce.weather_data_service.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository repository;

    /** Get all weather data with optional sorting */
    public List<WeatherData> getAll(String sortBy, String direction) {
        Sort sort = "desc".equalsIgnoreCase(direction) ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        return repository.findAll(sort);
    }

    /** Filter by weather condition */
    public List<WeatherData> filterByCondition(String conds) {
        return repository.findByConds(conds);
    }

    /** Filter by temperature range */
    public List<WeatherData> filterByTemperature(Double min, Double max) {
        return repository.findByTempmBetween(min, max);
    }
}
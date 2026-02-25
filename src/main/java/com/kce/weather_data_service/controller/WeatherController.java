package com.kce.weather_data_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kce.weather_data_service.entity.WeatherData;
import com.kce.weather_data_service.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public List<WeatherData> getAll(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return weatherService.getAll(sortBy, direction);
    }

    @GetMapping("/filter/condition")
    public List<WeatherData> filterByCondition(@RequestParam String conds) {
        return weatherService.filterByCondition(conds);
    }

    @GetMapping("/filter/temperature")
    public List<WeatherData> filterByTemperature(
            @RequestParam Double min,
            @RequestParam Double max) {
        return weatherService.filterByTemperature(min, max);
    }
}
package com.kce.weather_data_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kce.weather_data_service.entity.WeatherData;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {

    List<WeatherData> findByConds(String conds);

    List<WeatherData> findByTempmGreaterThan(Double temp);

    List<WeatherData> findByTempmBetween(Double start, Double end);
}
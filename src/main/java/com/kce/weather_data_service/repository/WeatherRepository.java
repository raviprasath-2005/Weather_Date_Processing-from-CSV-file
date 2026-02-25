
package com.kce.weather_data_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kce.weather_data_service.entity.WeatherData;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData,Long>, JpaSpecificationExecutor<WeatherData> {

}

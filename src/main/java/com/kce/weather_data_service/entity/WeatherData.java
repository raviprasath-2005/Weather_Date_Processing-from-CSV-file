package com.kce.weather_data_service.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "weather_data",
        indexes = {
                @Index(name = "idx_date", columnList = "record_date"),
                @Index(name = "idx_year_month", columnList = "year, month")
        })
@Getter
@Setter
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate recordDate;

    private Integer year;
    private Integer month;

    @Column(name = "weather_condition")
    private String weatherCondition;

    private Double temperature;
    private Double humidity;
    private Double pressure;
    private Double heatIndex;
    private Double dewPoint;

    private Double precipitation;

    private Double windSpeed;
    private Double windGust;
    private Double windChill;

    private String windDirectionText;
    private Integer windDirectionDegree;

    private Double visibility;

    private Boolean fog;
    private Boolean hail;
    private Boolean rain;
    private Boolean snow;
    private Boolean thunder;
    private Boolean tornado;
}

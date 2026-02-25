package com.kce.weather_data_service.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Builder
public class dto {

    private LocalDate recordDate;

    private Double temperature;
    private Double humidity;
    private Double pressure;

    private Double heatIndex;
    private Double dewPoint;

    private Double precipitation;

    private Double windSpeed;
    private Double windGust;
    private Double windChill;

    private String condition;

    private Double visibility;

    private Integer windDirectionDegree;
    private String windDirectionText;

    private Boolean fog;
    private Boolean rain;
    private Boolean snow;
    private Boolean thunder;
    private Boolean tornado;
}
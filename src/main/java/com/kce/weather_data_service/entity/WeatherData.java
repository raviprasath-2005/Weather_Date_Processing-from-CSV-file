package com.kce.weather_data_service.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "weather_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String datetimeUtc;
    private String conds;
    private Double dewptm;
    private Integer fog;
    private Integer hail;
    private Double heatindexm;
    private Double hum;
    private Double precipm;
    private Double pressurem;
    private Integer rain;
    private Integer snow;
    private Double tempm;
    private Integer thunder;
    private Integer tornado;
    private Double vism;
    private Double wdird;
    private String wdire;
    private Double wgustm;
    private Double windchillm;
    private Double wspdm;
}
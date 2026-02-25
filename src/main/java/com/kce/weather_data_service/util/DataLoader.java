package com.kce.weather_data_service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CsvService csvService;

    @Override
    public void run(String... args) {
        csvService.saveCsvData("D:/testset.csv");
    }
}
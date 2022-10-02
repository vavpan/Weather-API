package com.example.Weather.Api.controller;

import com.example.Weather.Api.details.WeatherDetails;
import com.example.Weather.Api.model.WeatherModel;
import com.example.Weather.Api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";



    @GetMapping("/info/{cityValue}")

    private WeatherModel getWeatherByCity(@PathVariable("cityValue") String cityValue){

        String name = weatherService.getWeatherInfoByCity(cityValue).getName();
        double temp =  weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp();
        String desc = weatherService.getWeatherInfoByCity(cityValue).getWeather().listIterator().next().getDescription();
        double minTemp = weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp_min();
        double maxTemp = weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp_max();



        System.out.println(ANSI_CYAN+"City: " +ANSI_RED+name);
        System.out.println(ANSI_CYAN+"Current temperature: "  +ANSI_RED+temp);
        System.out.println(ANSI_CYAN+"Description " +ANSI_RED+desc);
        System.out.println(ANSI_CYAN+"Today minimum temperature: " +ANSI_RED+minTemp);
        System.out.println(ANSI_CYAN+"Today maximum temperature: " +ANSI_RED+maxTemp);
        System.out.println("\n");


        return weatherService.getWeatherInfoByCity(cityValue);


    }



}

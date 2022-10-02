package com.example.Weather.Api.controller;

import com.example.Weather.Api.details.WeatherDetails;
import com.example.Weather.Api.model.WeatherModel;
import com.example.Weather.Api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;


    @GetMapping("/info/{cityValue}")
    private WeatherModel getWeatherByCity(@PathVariable("cityValue") String cityValue){

        String name = weatherService.getWeatherInfoByCity(cityValue).getName();
        double temp =  weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp();
        String desc = weatherService.getWeatherInfoByCity(cityValue).getWeather().listIterator().next().getDescription();
        double minTemp = weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp_min();
        double maxTemp = weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp_max();

        System.out.println("City: " +name+  "\nCurrent temperature: " +temp+ "\nDescription: " +desc+ "\nToday minimum temperature: " +minTemp+ "\nToday maximum temperature: " +maxTemp);
        System.out.println("=====\n");


        return weatherService.getWeatherInfoByCity(cityValue);


    }



}

package com.example.Weather.Api.controller;

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

        System.out.println(weatherService.getWeatherInfoByCity(cityValue).getName());
        System.out.println(weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp());
        return weatherService.getWeatherInfoByCity(cityValue);


    }


}

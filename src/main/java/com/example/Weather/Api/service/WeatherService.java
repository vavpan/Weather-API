package com.example.Weather.Api.service;

import com.example.Weather.Api.model.WeatherModel;

import java.util.List;

public interface WeatherService {


    public WeatherModel getWeatherInfoByCity(String cityValue);

    public WeatherModel searchByCity(String cityName);




}

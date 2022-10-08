package com.example.Weather.Api.service;

import com.example.Weather.Api.model.ForecastWeatherModel;

import java.util.List;


public interface ForecastWeatherService {

    public ForecastWeatherModel getForecastInfoByCity(int counter , String cityValue);



}

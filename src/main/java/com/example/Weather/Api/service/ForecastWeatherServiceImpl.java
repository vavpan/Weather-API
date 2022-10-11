package com.example.Weather.Api.service;

import com.example.Weather.Api.model.ForecastWeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ForecastWeatherServiceImpl implements ForecastWeatherService{

    @Value("${forecast.url}")
    private String forecastApiBaseUrl;

    @Value("${additional.url}")
    private String forecastApiAdditionalUrl;


    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ForecastWeatherModel getForecastInfoByCity(int counter , String cityValue) {

        ForecastWeatherModel result = restTemplate.getForObject(forecastApiBaseUrl+counter+"&appid="+apiKey+forecastApiAdditionalUrl+cityValue+"&units=metric" , ForecastWeatherModel.class);

        return result;
    }




}

package com.example.Weather.Api.service;

import com.example.Weather.Api.model.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService{


    @Value("${external.api.url}")
    private String weatherApiBaseUrl;

    @Value("${api.key}")
    private String apiKey;


    @Autowired
    private RestTemplate restTemplate;



    @Override
    public WeatherModel getWeatherInfoByCity(String cityValue) {


       WeatherModel result = restTemplate.getForObject(weatherApiBaseUrl+cityValue+"&appid="+apiKey+"&units=metric" , WeatherModel.class);
       return result;
    }

    @Override
    public WeatherModel searchByCity(String cityName) {

        WeatherModel result;
        if (cityName != null && (cityName.trim().length() > 0 )){
            result = restTemplate.getForObject(weatherApiBaseUrl+cityName+"&appid="+apiKey+"&units=metric" , WeatherModel.class);
            return result;
        }

           return null;
        }


    }


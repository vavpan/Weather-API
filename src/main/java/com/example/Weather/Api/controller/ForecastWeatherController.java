package com.example.Weather.Api.controller;



import com.example.Weather.Api.details.forecastDetails.CityDetails;
import com.example.Weather.Api.details.forecastDetails.ListDetails;
import com.example.Weather.Api.service.ForecastWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class ForecastWeatherController{


    @Autowired
    private ForecastWeatherService forecastWeatherService;

    @GetMapping("/forecast")
    public String forecastDisplay(){


        return "forecast";
    }

    @GetMapping("/{counterValue}/city/{cityValue}")
    public String getInfo(@PathVariable("counterValue") int counterValue, @PathVariable("cityValue") String cityValue , Model model){

        model.addAttribute("forecast", forecastWeatherService.getForecastInfoByCity(counterValue, cityValue));

        return "forecast";
    }

    @GetMapping("/find")
    public String getInfo(@RequestParam("cityName") String cityName,Model model){

        final int counterValue = 40; // maximum forecast weather

        try {
            model.addAttribute("forecast", forecastWeatherService.getForecastInfoByCity(counterValue, cityName));
        }catch (HttpClientErrorException e){
            if (e.getStatusCode().is4xxClientError()){
                System.out.println("Null OR Invalid value has been entered");
            }
        }

        return "forecast";
    }


}

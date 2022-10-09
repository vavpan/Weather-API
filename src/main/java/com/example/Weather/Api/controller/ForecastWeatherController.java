package com.example.Weather.Api.controller;



import com.example.Weather.Api.service.ForecastWeatherService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class ForecastWeatherController{


    @Autowired
    private ForecastWeatherService forecastWeatherService;


    @GetMapping("/{counterValue}/city/{cityValue}")
    public String getInfo(@PathVariable("counterValue") int counterValue, @PathVariable("cityValue") String cityValue , Model model){
        model.addAttribute("forecast", forecastWeatherService.getForecastInfoByCity(counterValue, cityValue));

        return "forecast";
    }




}

package com.example.Weather.Api.controller;


import com.example.Weather.Api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


@Controller
@RequestMapping("/")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";

    @GetMapping("/")
    public String main(){
        return "home";
    }



    // In case you want to search the city via URL
    @GetMapping("/info/{cityValue}")
    public String home(Model model , @PathVariable("cityValue") String cityValue){

        String name = weatherService.getWeatherInfoByCity(cityValue).getName();
        double temp =  weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp();
        String desc = weatherService.getWeatherInfoByCity(cityValue).getWeather().listIterator().next().getDescription();
        double minTemp = weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp_min();
        double maxTemp = weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp_max();


        model.addAttribute("cityName" , name);
        model.addAttribute("weatherTemp" , temp);
        model.addAttribute("weatherDesc" , desc);
        model.addAttribute("weatherMinTemp" , minTemp);
        model.addAttribute("weatherMaxTemp" , maxTemp);


        return "home";
    }

    // Search via search-button
    @GetMapping("/search")
    public String search(@RequestParam("cityName") String cityValue, Model model){

        try {
            String name = weatherService.getWeatherInfoByCity(cityValue).getName();
            double temp = weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp();
            String desc = weatherService.getWeatherInfoByCity(cityValue).getWeather().listIterator().next().getDescription();
            double minTemp = weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp_min();
            double maxTemp = weatherService.getWeatherInfoByCity(cityValue).getMain().getTemp_max();

            model.addAttribute("cityName", name);
            model.addAttribute("weatherTemp", temp);
            model.addAttribute("weatherDesc", desc);
            model.addAttribute("weatherMinTemp", minTemp);
            model.addAttribute("weatherMaxTemp", maxTemp);

        }catch (HttpClientErrorException e){
          if (e.getStatusCode().is4xxClientError()){
              System.out.println("Null OR Invalid value has been entered");
          }
  }



            return "home";

        }





    }

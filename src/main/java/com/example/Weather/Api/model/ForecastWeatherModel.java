package com.example.Weather.Api.model;

import com.example.Weather.Api.details.forecastDetails.*;
import com.example.Weather.Api.details.weatherDetails.CloudsDetails;
import com.example.Weather.Api.details.weatherDetails.WeatherDetails;
import com.example.Weather.Api.details.weatherDetails.WindDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastWeatherModel {

    private String cod;

    private int message;

    private int cnt;

    private List<ListDetails> list;

    private CityDetails city;





}

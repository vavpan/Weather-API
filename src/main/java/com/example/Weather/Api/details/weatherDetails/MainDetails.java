package com.example.Weather.Api.details.weatherDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainDetails {

    private double temp;

    private double feels_like;

    private double temp_min;

    private double temp_max;

    private double pressure;

    private int humidity;




}

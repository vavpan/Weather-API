package com.example.Weather.Api.details.forecastDetails;


import com.example.Weather.Api.details.weatherDetails.CoordDetails;
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
public class CityDetails {

    private long id;

    private String name;

    private CoordDetails coord;

    private String country;

    private long population;

    private long timezone;

    private long sunrise;

    private long sunset;
}

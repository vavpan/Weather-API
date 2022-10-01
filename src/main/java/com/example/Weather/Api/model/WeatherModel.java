package com.example.Weather.Api.model;

import com.example.Weather.Api.details.*;
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
public class WeatherModel {

      private CoordDetails coord;

      private List<WeatherDetails> weather;

      private String base;

      private MainDetails main;

      private long visibility;

      private WindDetails wind;

      private CloudDetails clouds;

      private long dt;

      private SysDetails sys;

      private long timezone;

      private long id;

      private String name;

      private int cod;







}

package com.weather.demo.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.weather.demo.models.HourlyForecast;
import com.weather.demo.services.WeatherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * This is the controller class for the hourly weather forecast API.
 * It handles GET requests for hourly weather forecast by location name.
 * Example URL : http://localhost:8080/api/weather/hourly/Berlin
 */

@RestController
@RequestMapping("/api/weather")
public class HourlyWeatherForecastController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/hourly/{locationName}")
    public ResponseEntity<HourlyForecast> getHourlyForecastByLocationName(@PathVariable String locationName) {
        try {
            HourlyForecast hourlyForecast = weatherService.getHourlyForecastByLocationName(locationName);
            return new ResponseEntity<>(hourlyForecast, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
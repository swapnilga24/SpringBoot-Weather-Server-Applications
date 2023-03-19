package com.weather.demo.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.weather.demo.models.ForecastSummary;
import com.weather.demo.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * This is the controller class for the weather forecast summary API.
 * It handles GET requests for weather forecast summary by location name.
 * Example URL : http://localhost:8080/api/weather/forecast-summary/Berlin
 */
@RestController
@RequestMapping("/api/weather")
public class WeatherForecastSummaryController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/forecast-summary/{locationName}")
    public ResponseEntity<ForecastSummary> getForecastSummaryByLocationName(@PathVariable String locationName) {
        try {
            ForecastSummary forecastSummary = weatherService.getForecastSummaryByLocationName(locationName);
            return new ResponseEntity<>(forecastSummary, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
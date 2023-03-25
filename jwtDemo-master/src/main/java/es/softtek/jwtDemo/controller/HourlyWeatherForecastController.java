package es.softtek.jwtDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import es.softtek.jwtDemo.dto.ForecastSummary;
import es.softtek.jwtDemo.services.RapidApiClient;

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
    private RapidApiClient rapidApiClient;

    @GetMapping("/hourly/{locationName}")
    public ResponseEntity<ForecastSummary> getHourlyForecastByLocationName(@PathVariable String locationName) {
        try {
            ForecastSummary hourlyForecast = rapidApiClient.getHourlyForecastByLocationName(locationName);
            return new ResponseEntity<>(hourlyForecast, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
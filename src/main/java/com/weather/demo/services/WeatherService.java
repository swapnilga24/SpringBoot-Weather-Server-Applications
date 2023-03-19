package com.weather.demo.services;
import com.weather.demo.models.ForecastSummary;
import com.weather.demo.models.HourlyForecast;
import com.weather.demo.repositories.RapidApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private RapidApiClient rapidApiClient;

    public ForecastSummary getForecastSummaryByLocationName(String locationName) throws Exception {
        return rapidApiClient.getForecastSummaryByLocationName(locationName);
    }

    public HourlyForecast getHourlyForecastByLocationName(String locationName) throws Exception {
        return rapidApiClient.getHourlyForecastByLocationName(locationName);
    }
}
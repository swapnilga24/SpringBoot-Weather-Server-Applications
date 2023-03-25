package es.softtek.jwtDemo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.softtek.jwtDemo.dto.ForecastSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

/*
 * This is the RapidAPI client class which makes HTTP requests to the RapidAPI server to get weather forecast data.
 * It includes the RapidAPI server host, key, and base URL.(store in application.properties)
 * It uses RestTemplate and ObjectMapper to handle HTTP requests and responses.
 */

@Component
public class RapidApiClient {

    @Value("${rapidapi.host}")
    private String rapidApiHost;

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    @Value("${rapidapi.baseUrl}")
    private String baseUrl;

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public RapidApiClient() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
    }

    public ForecastSummary getForecastSummaryByLocationName(String locationName) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("x-rapidapi-host", rapidApiHost);
        headers.set("x-rapidapi-key", rapidApiKey);

        String url = baseUrl + locationName + "/summary/";

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String response = responseEntity.getBody();
        //String response = "{}";
        return objectMapper.readValue(response, ForecastSummary.class);
    }

    public ForecastSummary getHourlyForecastByLocationName(String locationName) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("x-rapidapi-host", rapidApiHost);
        headers.set("x-rapidapi-key", rapidApiKey);

        String url = baseUrl + locationName + "/hourly/";

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String response = responseEntity.getBody();
        //String response = "{}";
        
        return objectMapper.readValue(response, ForecastSummary.class);
    }
}
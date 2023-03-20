# SpringBoot-Weather-Server-Applications

Problem Statement : Write a server by using SpringBoot Java and integrate Weather API from Rapid API. On the basis of that integration, expose your RESTful APIs as follows with JSON response.
Authentication Method: Header-based authentication with random client id and random client secret.

API 1: Get the Weather forecast summary of Any city using API (RapidApiGetForecastSummaryByLocationName)

API 2: Get hourly Weather forecast details of Any city using API (RapidApiGetHourlyForecastByLocationName)

API Document: https://rapidapi.com/wettercom-wettercom-default/api/forecast9 (RapidApiGetForecastSummaryByLocationName & RapidApiGetHourlyForecastByLocationName)

Solutions :

To run this spring boot application first clone this repo and run the DemoApplication.java file. after this server will be start running on port 8080 
using postman you can test the api's

1 : First Try login Api : GET => http://localhost:8080/login 
 => This api will return the client Id and client secret as response. user need to use this id and secret to generate the authorization key 
 => user can create authorization key using base64 encoder fo this we need to encode client Id:client Secret using this online tool(https://www.base64encode.org/) we can generate the authorization key which we can use to call the forecast summary and hourly api's.
  
  Example : Client id : QZmf8p5mdyTyp_Z5kCjTnQ==   Client Secret : 5Mw-ArBV_YaxXBXOfLf4YkXjEeFGgdjZibSwldKFnlSE= 
     Need to generate Authorization Key = using Base64 encode this : QZmf8p5mdyTyp_Z5kCjTnQ==:Mw-ArBV_YaxXBXOfLf4YkXjEeFGgdjZibSwldKFnlSE=     
     Authorization Key =>  Basic UVptZjhwNW1keVR5cF9aNWtDalRuUT09Ok13LUFyQlZfWWF4WEJYT2ZMZjRZa1hqRWVGR2dkalppYlN3bGRLRm5sU0U9 
   
2 : Forecast summary Api : GET => http://localhost:8080/api/weather/forecast-summary/Berlin 
   => here , we need to pass the header : Authorization (key) : Basic + AuthorizationKey (value)
      we need to use AuthorizationKey which we generted from login api and using base64.
   => this api will return the json object which contains the array of object for next 16 days weather details objects.
   
3 : Forecast Hourly Api : GET => http://localhost:8080/api/weather/hourly/Berlin
   => here , we need to pass the header : Authorization (key) : Basic + AuthorizationKey (value)
      we need to use AuthorizationKey which we generted from login api and using base64.
   =>this api will return the json object which contain array of object for next 16 days hourly weather details objectT 

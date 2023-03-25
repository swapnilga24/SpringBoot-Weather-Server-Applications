# SpringBoot-Weather-Server-Applications

Problem Statement : Write a server by using SpringBoot Java and integrate Weather API from Rapid API. On the basis of that integration, expose your RESTful APIs as follows with JSON response. Authentication Method: Header-based authentication with random client id and random client secret.

API 1: Get the Weather forecast summary of Any city using API (RapidApiGetForecastSummaryByLocationName)

API 2: Get hourly Weather forecast details of Any city using API (RapidApiGetHourlyForecastByLocationName)

API Document: https://rapidapi.com/wettercom-wettercom-default/api/forecast9 (RapidApiGetForecastSummaryByLocationName & RapidApiGetHourlyForecastByLocationName)

Solutions :

To run this Spring Boot application, first clone this repository and run the DemoApplication.java file. After this, the server will start running on port 8080. Using Postman, you can test the APIs.

1* : First, try the login API: POST => http://localhost:8080/login.
    Body : username : Swapnilahire.sde@gmail.com 
            password : Swapnil@123 
    This API will return the JSON Object which contain username and JWT token as a response. Users need to use this ID and secret to generate the authorization key.
   User need to use JWT token to call the forecast summary and hourly APIs.
    
  Example: 
  Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzd2FwbmlsSUQiLCJzdWIiOiJzd2FwbmlsYWhpcmUuc2RlQGdtYWlsLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2Nzk3NzQwODUsImV4cCI6MTY3OTc3NDY4NX0.OH-HBZzyTMLDwW9sCHg66o6yU7o2slC5c76nNF4c_1x8eGBhQqYmVkOSPybkULFGEiI7_OKii2V2Ma44ZargEQ
 

2* : Forecast summary API: GET => http://localhost:8080/api/weather/forecast-summary/Berlin.

  Here, we need to pass the header Authorization with the value Authorization Key(JWT Token).

  To obtain the JWT TOken, we generated it from the login API.

  This API will return a JSON object containing an array of objects with weather details for the next 16 days.



3* : Forecast hourly API: GET => http://localhost:8080/api/weather/hourly/Berlin.

  Here, we need to pass the header Authorization with the value Authorization Key(JWT Token).

  To obtain the JWT Token, we generated it from the login API.

  This API will return a JSON object containing an array of objects with hourly weather details for the next 16 days.


Please feel free to reach out with any queries:

Name : Swapnil Ahire 

Email : SwapnilAhire.sde@gmail.com

Linkedin : https://www.linkedin.com/in/swapnil-ahire/

# SpringBoot-Weather-Server-Applications

Problem Statement : Write a server by using SpringBoot Java and integrate Weather API from Rapid API. On the basis of that integration, expose your RESTful APIs as follows with JSON response.
Authentication Method: Header-based authentication with random client id and random client secret.

API 1: Get the Weather forecast summary of Any city using API (RapidApiGetForecastSummaryByLocationName)

API 2: Get hourly Weather forecast details of Any city using API (RapidApiGetHourlyForecastByLocationName)

API Document: https://rapidapi.com/wettercom-wettercom-default/api/forecast9 (RapidApiGetForecastSummaryByLocationName & RapidApiGetHourlyForecastByLocationName)

Solutions :

To run this Spring Boot application, first clone this repository and run the DemoApplication.java file. After this, the server will start running on port 8080. Using Postman, you can test the APIs.


1* : First, try the login API: GET => http://localhost:8080/login.

    This API will return the client ID and client secret as a response. Users need to use this ID and secret to generate the authorization key.

    Users can create the authorization key using a base64 encoder. For this, we need to encode the client ID and client secret using this online tool (https://www.base64encode.org/). 
    
    Please add a colon between the ID and secret while encoding to base64. We can use the generated authorization key to call the forecast summary and hourly APIs.
    
  Example: Client ID:  -e4AZbe1NV_fwrv4jHNR-Q==, Client Secret: GEveECG7PPUdbCs21jxScpYysXxqV1hRj7TH1589sJg=

  To generate the authorization key, use Base64 to encode this: -e4AZbe1NV_fwrv4jHNR-Q==:GEveECG7PPUdbCs21jxScpYysXxqV1hRj7TH1589sJg=

  Authorization key: Basic LWU0QVpiZTFOVl9md3J2NGpITlItUT09OkdFdmVFQ0c3UFBVZGJDczIxanhTY3BZeXNYeHFWMWhSajdUSDE1ODlzSmc9
   
   ![Screenshot (11)](https://user-images.githubusercontent.com/39656416/226533225-7bd5cbc5-9750-42a9-afda-1253b53cc984.png)
    ![Screenshot (12)](https://user-images.githubusercontent.com/39656416/226533323-4c0bf859-e78a-448f-a41e-7acbba85ccaf.png)


2* : Forecast summary API: GET => http://localhost:8080/api/weather/forecast-summary/Berlin.

  Here, we need to pass the header Authorization with the value Basic + Authorization Key.

  To obtain the Authorization Key, we generated it from the login API using Base64.

  This API will return a JSON object containing an array of objects with weather details for the next 16 days.
  ![Screenshot (9)](https://user-images.githubusercontent.com/39656416/226533360-9bb4ad9c-d2c6-45a0-9e31-e7228657500a.png)



3* : Forecast hourly API: GET => http://localhost:8080/api/weather/hourly/Berlin.

  Here, we need to pass the header Authorization with the value Basic + Authorization Key.

  To obtain the Authorization Key, we generated it from the login API using Base64.

  This API will return a JSON object containing an array of objects with hourly weather details for the next 16 days.
 ![Screenshot (10)](https://user-images.githubusercontent.com/39656416/226533380-7e6f71dc-75b2-4a01-93c2-0d7c363055ad.png)


Please feel free to reach out with any queries:

Name : Swapnil Ahire 

Email : SwapnilAhire.sde@gmail.com

Linkedin : https://www.linkedin.com/in/swapnil-ahire/

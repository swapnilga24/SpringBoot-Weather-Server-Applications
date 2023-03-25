package es.softtek.jwtDemo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * This is the model class for the weather forecast summary.
 * The properties in this class represent the fields in the JSON response.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "location",
        "forecast"
})
public class ForecastSummary {
    @JsonProperty("location")
    private Location location;
    @JsonProperty("forecast")
    private Forecast forecast;
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "code",
        "name",
        "timezone"
})
class Location {

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("timezone")
    private String timezone;
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "items",
        "forecastDate"
})
class Forecast {

    @JsonProperty("items")
    private List<Item> items;

    @JsonProperty("forecastDate")
    private String forecastDate;

}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "date",
        "dateWithTimezone",
        "freshSnow",
        "snowHeight",
        "weather",
        "prec",
        "sunHours",
        "rainHours",
        "temperature",
        "wind",
        "windchill",
        "snowLine",
        "astronomy"
})
class Item {
    @JsonProperty("date")
    private String date;

    @JsonProperty("dateWithTimezone")
    private String dateWithTimezone;

    @JsonProperty("freshSnow")
    private Double freshSnow;

    @JsonProperty("snowHeight")
    private Object snowHeight;

    @JsonProperty("weather")
    private Weather weather;

    @JsonProperty("prec")
    private Prec prec;

    @JsonProperty("sunHours")
    private Integer sunHours;

    @JsonProperty("rainHours")
    private Object rainHours;

    @JsonProperty("temperature")
    private Temperature temperature;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("windchill")
    private Windchill windchill;

    @JsonProperty("snowLine")
    private SnowLine snowLine;

    @JsonProperty("astronomy")
    private Astronomy astronomy;
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "state",
        "text",
        "icon"
})
class Weather {
    @JsonProperty("state")
    private Integer state;
    @JsonProperty("text")
    private String text;
    @JsonProperty("icon")
    private String icon;
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "sum",
        "probability",
        "sumAsRain",
        "class"
})
class Prec {
    @JsonProperty("sum")
    private Double sum;
    @JsonProperty("probability")
    private Integer probability;
    @JsonProperty("sumAsRain")
    private Object sumAsRain;
    @JsonProperty("class")
    private Integer _class;
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "min",
        "max",
        "avg"
})
class Temperature {
    @JsonProperty("min")
    private Integer min;
    @JsonProperty("max")
    private Integer max;
    @JsonProperty("avg")
    private Object avg;
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "unit",
        "direction",
        "text",
        "avg",
        "min",
        "max",
        "gusts",
        "significationWind"
})
class Wind {
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("text")
    private String text;
    @JsonProperty("avg")
    private Object avg;
    @JsonProperty("min")
    private Integer min;
    @JsonProperty("max")
    private Integer max;
    @JsonProperty("significationWind")
    private Boolean significationWind;
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "min",
        "max",
        "avg"
})
class Windchill {
    @JsonProperty("min")
    private Integer min;
    @JsonProperty("max")
    private Integer max;
    @JsonProperty("avg")
    private Object avg;
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "avg",
        "min",
        "max",
        "unit"
})
class SnowLine {
    @JsonProperty("avg")
    private Object avg;
    @JsonProperty("min")
    private Object min;
    @JsonProperty("max")
    private Object max;
    @JsonProperty("unit")
    private String unit;
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "dawn",
        "sunrise",
        "suntransit",
        "sunset",
        "dusk",
        "moonrise",
        "moontransit",
        "moonset",
        "moonphase",
        "moonzodiac"
})
class Astronomy {

    @JsonProperty("dawn")
    private String dawn;
    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("suntransit")
    private String suntransit;
    @JsonProperty("sunset")
    private String sunset;
    @JsonProperty("dusk")
    private String dusk;
    @JsonProperty("moonrise")
    private String moonrise;
    @JsonProperty("moontransit")
    private String moontransit;
    @JsonProperty("moonset")
    private String moonset;
    @JsonProperty("moonphase")
    private Integer moonphase;
    @JsonProperty("moonzodiac")
    private Integer moonzodiac;
}
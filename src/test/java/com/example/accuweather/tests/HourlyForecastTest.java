package com.example.accuweather.tests;

import com.example.Weather.Temperature;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class HourlyForecastTest extends BaseTest {

    @Test
    public void testHourlyForecast() {
        List<Temperature> hourlyForecast = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/forecasts/v1/hourly/12hour/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList("Temperature", Temperature.class);

        assertNotNull(hourlyForecast);
        assertFalse(hourlyForecast.isEmpty());
    }
}

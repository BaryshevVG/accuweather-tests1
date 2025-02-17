package com.example.accuweather.tests;

import com.example.Weather.DailyForecast;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class RegionalWeatherForecastTest extends BaseTest {

    @Test
    public void testRegionalWeatherForecast() {
        List<DailyForecast> regionalForecast = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/forecasts/v1/regional/5day/EUR")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList("DailyForecasts", DailyForecast.class);

        assertNotNull(regionalForecast);
        assertFalse(regionalForecast.isEmpty());
    }
}

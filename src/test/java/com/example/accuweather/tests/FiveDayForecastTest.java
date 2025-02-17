package com.example.accuweather.tests;

import com.example.Weather.DailyForecast;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class FiveDayForecastTest extends BaseTest {

    @Test
    public void testFiveDayForecast() {
        List<DailyForecast> forecast = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/forecasts/v1/daily/5day/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList("DailyForecasts", DailyForecast.class);

        assertNotNull(forecast);
        assertEquals(5, forecast.size());
    }
}

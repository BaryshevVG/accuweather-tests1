package com.example.accuweather.tests;

import com.example.Weather.Headline;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricalWeatherTest extends BaseTest {

    @Test
    public void testHistoricalWeather() {
        Headline historicalWeather = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/historical/v1/295117/24hour")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Headline.class);

        assertNotNull(historicalWeather);
        assertNotNull(historicalWeather.getText());
    }
}

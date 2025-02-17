package com.example.accuweather.tests;

import com.example.Weather.Headline;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class CurrentWeatherTest extends BaseTest {

    @Test
    public void testCurrentWeather() {
        Headline weather = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/currentconditions/v1/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Headline.class);

        assertNotNull(weather);
        assertNotNull(weather.getText());
    }
}

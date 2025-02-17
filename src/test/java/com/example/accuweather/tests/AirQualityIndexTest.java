package com.example.accuweather.tests;

import com.example.Weather.Headline;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class AirQualityIndexTest extends BaseTest {

    @Test
    public void testAirQualityIndex() {
        Headline airQuality = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/airquality/v1/currentconditions/295117") // Москва
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Headline.class);

        assertNotNull(airQuality);
        assertNotNull(airQuality.getText());
    }
}

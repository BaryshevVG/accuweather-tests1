package com.example.accuweather.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class SunriseSunsetTest extends BaseTest {

    @Test
    public void testSunriseSunset() {
        String response = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/astronomy/v1/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .asString();

        assertNotNull(response);
    }
}

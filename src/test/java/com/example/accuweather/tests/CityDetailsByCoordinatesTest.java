package com.example.accuweather.tests;

import com.example.Location.Location;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class CityDetailsByCoordinatesTest extends BaseTest {

    @Test
    public void testCityDetailsByCoordinates() {
        Location location = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "55.751244,37.618423")
                .when()
                .get("/locations/v1/cities/geoposition/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Location.class);

        assertEquals("Moscow", location.getEnglishName());
        assertEquals("RU", location.getCountry().getId());
    }
}
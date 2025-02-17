package com.example.accuweather.tests;

import com.example.Location.Location;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class CityByIPTest extends BaseTest {

    @Test
    public void testFindCityByIP() {
        Location location = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "2.59.241.32")
                .when()
                .get("/locations/v1/cities/ipaddress")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Location.class);

        assertNotNull(location.getLocalizedName());
        assertNotNull(location.getCountry().getId());
    }
}
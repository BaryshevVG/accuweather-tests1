package com.example.accuweather.tests;

import com.example.Location.Location;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class GeoLocationSearchTest extends BaseTest {

    @Test
    public void testGeoLocationSearch() {
        Location location = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "57.1522,65.5272") // Координаты Тюмени
                .when()
                .get("/locations/v1/cities/geoposition/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Location.class);

        assertNotNull(location);
        assertEquals("Tyumen", location.getLocalizedName());
        assertEquals("RU", location.getCountry().getId());
    }
}

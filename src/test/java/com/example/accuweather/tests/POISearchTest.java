package com.example.accuweather.tests;

import com.example.Location.Location;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class POISearchTest extends BaseTest {

    @Test
    public void testPOISearchInRussia() {
        List<Location> pois = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "Moscow")
                .when()
                .get("/locations/v1/poi/RU/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        assertFalse(pois.isEmpty());
        assertEquals("RU", pois.get(0).getCountry().getId());
    }
}
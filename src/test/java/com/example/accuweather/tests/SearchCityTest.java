package com.example.accuweather.tests;

import com.example.Location.Location;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class SearchCityTest extends BaseTest {

    @Test
    public void testSearchCity() {
        List<Location> cities = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "Moscow")
                .when()
                .get("/locations/v1/cities/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        assertFalse(cities.isEmpty());
        assertEquals("Moscow", cities.get(0).getEnglishName());
        assertEquals("RU", cities.get(0).getCountry().getId());
    }
}

package com.example.accuweather.tests;

import com.example.Location.Location;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class TopCitiesTest extends BaseTest {

    @Test
    public void testTopCities() {
        List<Location> cities = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/locations/v1/topcities/50")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        assertEquals(50, cities.size());
    }
}

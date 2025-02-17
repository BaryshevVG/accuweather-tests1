package com.example.accuweather.tests;

import com.example.Location.Location;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class Top100CitiesTest extends BaseTest {

    @Test
    public void testTop100Cities() {
        List<Location> cities = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/locations/v1/topcities/100")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        assertEquals(100, cities.size());
    }
}

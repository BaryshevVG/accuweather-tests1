package com.example.accuweather.tests;

import com.example.Location.Location;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class AutocompleteSearchTest extends BaseTest {

    @Test
    public void testAutocompleteSearch() {
        List<Location> cities = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "Tyu")
                .when()
                .get("/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        assertFalse(cities.isEmpty());
        assertTrue(cities.get(0).getLocalizedName().startsWith("Ty"));
    }
}

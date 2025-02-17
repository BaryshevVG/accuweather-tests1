package com.example.accuweather.tests;

import com.example.Location.Region;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class RegionsListTest extends BaseTest {

    @Test
    public void testRegionsList() {
        List<Region> regions = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/locations/v1/regions")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Region.class);

        assertFalse(regions.isEmpty());
        assertNotNull(regions.get(0).getId());
    }
}

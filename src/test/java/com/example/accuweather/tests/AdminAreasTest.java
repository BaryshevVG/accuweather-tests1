package com.example.accuweather.tests;

import com.example.Location.AdministrativeArea;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class AdminAreasTest extends BaseTest {

    @Test
    public void testAdminAreas() {
        List<AdministrativeArea> areas = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/locations/v1/adminareas/RU")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", AdministrativeArea.class);

        assertFalse(areas.isEmpty());
        assertEquals("RU", areas.get(0).getCountryID());
    }
}

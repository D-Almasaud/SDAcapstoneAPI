package Test.CountryService;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseUrl.QuadripartiteBaseUrl;

public class CountryAPITest extends QuadripartiteBaseUrl {



    @Test
    public void testGetAllCountries() {
        String response = RestAssured.given()
                .spec(spec)
                .when()
                .get("/v1/country")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        System.out.println("Response:");
        System.out.println(response);

        // Assert the response contains specific country details
        Assert.assertTrue(response.contains("\"iso2\":\"AF\""));
        Assert.assertTrue(response.contains("\"name\":\"Afghanistan\""));
        Assert.assertTrue(response.contains("\"currency\":\"AFN\""));
        Assert.assertTrue(response.contains("\"currency_name\":\"Afghan afghani\""));
    }

    @Test
    public void testGetCountryById() {
        String response = RestAssured.given()
                .spec(spec)
                .pathParam("id", "BH")
                .when()
                .get("/v1/country/{id}")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        System.out.println("Response:");
        System.out.println(response);

        // Assert the country details
        Assert.assertTrue(response.contains("\"iso2\":\"BH\""));
        Assert.assertTrue(response.contains("\"name\":\"Bahrain\""));
        Assert.assertTrue(response.contains("\"currency\":\"BHD\""));
        Assert.assertTrue(response.contains("\"currency_name\":\"Bahraini dinar\""));
    }
}

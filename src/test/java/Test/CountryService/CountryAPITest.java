package Test.CountryService;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AuthenticationUI;

public class CountryAPITest {

     RequestSpecification spec;

    @BeforeClass
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://qa-gm3.quaspareparts.com/a3m/auth/api")
                .setContentType(ContentType.JSON)
                .addHeader("Cookie", "GSESSIONID=" + AuthenticationUI.getSessionId())
                .build();
    }

    @Test
    public void testGetAllCountries() {
        String response = RestAssured.given()
                .spec(spec)
                .when()
                .get("/country")
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
                .when()
                .get("/country/BH")
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

package Test.MembershipService;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojos.MembershipService.Membership;
import utilities.AuthenticationUI;



public class MembershipAPITest {

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
    public void testGetMemberships() {
        String response = RestAssured.given()
                .spec(spec)
                .when()
                .get("/application/2/membership")
                .then()
                .statusCode(403)
                .extract()
                .asString();

        // Assert the response contains expected error details
        Assert.assertTrue(response.contains("\"status\": 403"));
        Assert.assertTrue(response.contains("\"error\": \"Forbidden\""));
        Assert.assertTrue(response.contains("\"message\": \"Principal not authorized\""));
        Assert.assertTrue(response.contains("\"detail\": \"Principal(a) not authorized to fetch memberships\""));
    }

    @Test
    public void testGetAllMemberships() {
        String response = RestAssured.given()
                .spec(spec)
                .when()
                .get("/membership")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        // Assert the response contains the specified JSON array

        Assert.assertTrue(response.contains("app_id: 2"));



    }


    @Test
    public void testGetMembershipsByUserIdAndAppId() {
        String response = RestAssured.given()
                .spec(spec)
                .when()
                .get("/user/2638/application/2/membership")
                .then()
                .statusCode(403)
                .extract()
                .asString();

        // Assert the response contains expected error details
        Assert.assertTrue(response.contains("\"status\": 403"));
        Assert.assertTrue(response.contains("\"error\": \"Forbidden\""));
        Assert.assertTrue(response.contains("\"message\": \"Principal not authorized\""));
        Assert.assertTrue(response.contains("\"detail\": \"Principal(a) not authorized to fetch memberships\""));
    }

    @Test
    public void testGetMembershipsByUserId() {
        String response = RestAssured.given()
                .spec(spec)
                .when()
                .get("/user/2638/membership")
                .then()
                .statusCode(403)
                .extract()
                .asString();

        // Assert the response contains expected error details
        Assert.assertTrue(response.contains("\"status\": 403"));
        Assert.assertTrue(response.contains("\"error\": \"Forbidden\""));
        Assert.assertTrue(response.contains("\"message\": \"Principal not authorized\""));
        Assert.assertTrue(response.contains("\"detail\": \"Principal(a) not authorized to fetch memberships\""));
    }
}

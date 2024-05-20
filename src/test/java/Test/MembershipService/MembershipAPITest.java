package Test.MembershipService;

import baseUrl.QuadripartiteBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MembershipAPITest extends QuadripartiteBaseUrl {

    @Test
    public void testGetMemberships() {

        Response response = given()
                .spec(spec)
                .when()
                .get("/v1/application/2/membership")
                .then()
                .statusCode(403)
                .extract().response();

        response.prettyPrint();

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("\"status\":403"));
        Assert.assertTrue(responseBody.contains("\"error\":\"Forbidden\""));
        Assert.assertTrue(responseBody.contains("\"message\":\"Principal not authorized\""));

    }

    @Test
    public void testGetAllMemberships() {
        Response response = given()
                .spec(spec)
                .when()
                .get("/v1/membership")
                .then()
                .statusCode(200)
                .extract().response();

        response.prettyPrint();

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("\"app_id\":2"));
        Assert.assertTrue(responseBody.contains("\"app_name\":\"Quaspareparts Gateway App\""));

        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getInt("[0].app_id"), 2);
        Assert.assertEquals(json.getString("[0].app_name"), "Quaspareparts Gateway App");
    }

    @Test
    public void testGetMembershipsByUserIdAndAppId() {
        Response response = given()
                .spec(spec)
                .pathParams("userId", 2638, "applicationId", 2)
                .when()
                .get("/v1/user/{userId}/application/{applicationId}/membership")
                .then()
                .statusCode(403)
                .extract().response();

        response.prettyPrint();

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("\"status\":403"));
        Assert.assertTrue(responseBody.contains("\"error\":\"Forbidden\""));
        Assert.assertTrue(responseBody.contains("\"message\":\"Principal not authorized\""));
    }

    @Test
    public void testGetMembershipsByUserId() {
        Response response = given()
                .spec(spec)
                .pathParam("userId", 2638)
                .when()
                .get("/v1/user/{userId}/membership")
                .then()
                .statusCode(403)
                .extract().response();

        response.prettyPrint();

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("\"status\":403"));
        Assert.assertTrue(responseBody.contains("\"error\":\"Forbidden\""));
        Assert.assertTrue(responseBody.contains("\"message\":\"Principal not authorized\""));

    }
}

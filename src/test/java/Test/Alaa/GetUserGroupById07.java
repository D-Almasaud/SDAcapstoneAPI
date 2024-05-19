package Test.Alaa;

import baseUrl.QuasparepartsBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetUserGroupById07 extends QuasparepartsBaseUrl {

    @Test
    public void getUserGroupByIdTest() {
        // Set base URI using the QuasparepartsBaseUrl class
        // The base URI is already set in the static block of QuasparepartsBaseUrl class

        // Set path parameters
        spec.pathParams("id", 1963); // Assuming you want to fetch user group with ID 1

        // Send GET request to fetch user group by ID
        Response response = given().spec(spec)
                .when().get("/user-groups/{id}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.getStatusCode(), 200);
    }
}

package Test.Alaa;


import baseUrl.QuasparepartsBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class GetAllUserGroups03 extends QuasparepartsBaseUrl {

    @Test
    public void getAllUserGroupsTest() {
        // Set base URI using the QuasparepartsBaseUrl class
        // The base URI is already set in the static block of QuasparepartsBaseUrl class

        // Send GET request to retrieve user groups
        Response response = given().spec(spec)
                .when().get("/user-groups");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.getStatusCode(), 200);

        // Add additional assertions as needed}


        // Assert response body contains the expected string
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("Education is so important"));

    }
}

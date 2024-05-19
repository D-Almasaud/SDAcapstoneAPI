package Test.Alaa;

import baseUrl.QuasparepartsBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class RemoveUserFromUserGroup02 extends QuasparepartsBaseUrl {

    @Test
    public void removeUserFromUserGroupTest() {
        // Set the base URI using the QuasparepartsBaseUrl class
        // The base URI is already set in the static block of the QuasparepartsBaseUrl class

        // Define the request body with the user and user group information
        String requestBody = """
                {
                  "user_id": 12345,
                  "user_group_id": 54321
                }
                """;

        // Send the DELETE request to remove the user from the user group
        Response response = given().spec(spec)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().delete("/remove-user-from-user-group");

        // Print the response body
        response.prettyPrint();

        // Assert that the response status code is 200
        assertEquals(response.getStatusCode(), 200);

        // Add additional assertions as needed
    }
}
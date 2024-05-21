package Test.OrgnizationStatusServices;

import baseUrl.QuasparepartsBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.OrganizationStatusServices.OrgnizationSSPOJO;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class OSS extends QuasparepartsBaseUrl {
    int createdId;
    OrgnizationSSPOJO requestBody;

    @Test
    public void GetUsersStatusOfApplication() {
        spec.pathParams("first", "organization-status"
                );

        Response response = given(spec)
                .when()
                .get("{first}");
        // Print response body
        response.prettyPrint();
        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
    }

    @Test(dependsOnMethods = "createOrganizationStatus")
    public void updateOrganizationStatus() {
        spec.pathParams("first", "organization-status");

        // Set the request body for the PUT request
        requestBody.setName("deactive");
        requestBody.setId(createdId);
        Response response = RestAssured.given()
                .spec(spec)
                .body(requestBody)  // Set the request body
                .when()
                .put("/{first}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);

        // Assert that user ID = 5 the updated one
        String name = response.jsonPath().getString("name");
        assertEquals(name, requestBody.getName(), "name of the user test");
    }

    @Test
    public void createOrganizationStatus() {
        spec.pathParams("first", "organization-status");

        // Set the request body for the POST request
        requestBody = new OrgnizationSSPOJO(null,"active"
                ,"Organization/Company account is active");

        Response response = RestAssured.given()
                .spec(spec)
                .body(requestBody)  // Set the request body
                .when()
                .post("/{first}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(), 201);

        // Assert that user status is active
        String name = response.jsonPath().getString("name");
        assertEquals(name, "active", "status of the user ");

        // Get the created ID from the response
        createdId = response.jsonPath().getInt("id");

        // Assert checks if the created ID matches the response ID
        assertEquals(createdId, response.jsonPath().getInt("id")
                , "ID of the created organization status");
    }



    @Test(dependsOnMethods = "createOrganizationStatus")
    public void getOrganizationStatusById() {
        spec.pathParams("first","organization-status"
                ,"second",createdId
                );

        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .get("/{first}/{second}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);

        // Assert that the ID is the same as expected
        int retrievedId = response.jsonPath().get("id");
        // Assuming the ID field is named "id"
        assertEquals(retrievedId, createdId, "Retrieved ID does not match the expected ID");
    }

    @Test
    public void deleteOrganizationStatusById() {
        spec.pathParams("first", "organization-status", "second", createdId);

        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .delete("/{first}/{second}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(),
                200, "Response status code is not 200");

    }

}

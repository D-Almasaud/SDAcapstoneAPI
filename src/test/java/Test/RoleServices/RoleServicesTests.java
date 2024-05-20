package Test.RoleServices;

import baseUrl.QuasparepartsBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class RoleServicesTests extends QuasparepartsBaseUrl {
    @Test
    public void getAllRolesbyOrganization() {
        spec.pathParams("first","application"
                ,"second",2
                ,"third","organization"
                ,"forth","1716152660399179"
                ,"fifth","role");

        // Send GET request to retrieve user inf
        Response response = given(spec).when().get("{first}/{second}/{third}/{forth}/{fifth}");

        // Print response body
        response.prettyPrint();

        //Assert response status code is 200
        assertEquals(response.statusCode(),200);
    }

    @Test
    public void getAllRolesbyApplication() {
        spec.pathParams("first","application"
                ,"second",2
                ,"third", "role");

        // Send GET request to retrieve user inf
        Response response = given(spec).when().get("{first}/{second}/{third}");

        // Print response body
        response.prettyPrint();

        //Assert response status code is 200
        assertEquals(response.statusCode(),200);
    }
    @Test
    public void getAllRolesofTheSubscription() {
        spec.pathParam("first","role");

        // Send GET request to retrieve user inf
        Response response = given(spec).when().get("{first}");

        // Print response body
        response.prettyPrint();

        //Assert response status code is 200
        assertEquals(response.statusCode(),200);
    }
    @Test
    public void updateOrganizationStatus() {
        spec.pathParams("first", "role");

        // Set the request body for the PUT request
        String requestBody = "{\n" +
                "  \"id\": 26,\n" +
                "  \"name\": \"teacher\",\n" +
                "  \"app_id\": 2\n" +
                "}";

        new RoleServicesTests();

        Response response = RestAssured.given()
                .spec(spec)
                .body(requestBody)  // Set the request body
                .when()
                .put("/{first}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(), 403);
    }

@Test
public void addNewRole() {
    spec.pathParams("first", "role");

    // Set the request body for the PUT request

    // Set the request body for the POST request
    String requestBody = "{\n" +
            "  \"id\": 0,\n" +
            "  \"name\": \"MANAGER\",\n" +
            "  \"app_id\": 0,\n" +
            "  \"description\": \"string\",\n" +
            "  \"permissions\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"resource\": \"book\",\n" +
            "      \"action\": \"read, write etc.\",\n" +
            "      \"app_id\": 123\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    Response response = RestAssured.given()
            .spec(spec)
            .body(requestBody)  // Set the request body
            .when()
            .post("/{first}");

    // Print response body
    response.prettyPrint();

    // Assert response status code is 200
    assertEquals(response.statusCode(), 403);
}
    @Test
    public void getRolebyId() {
        spec.pathParams("first","role"
        ,"second",5);

        // Send GET request to retrieve user inf
        Response response = given(spec).when().get("{first}/{second}");

        // Print response body
        response.prettyPrint();

        //Assert response status code is 200
        assertEquals(response.statusCode(),200);
    }

    @Test
    public void deleteExistingRoleById() {
        spec.pathParams("first", "role", "second", 21)
                .queryParam("app_id", 2);


        Response response = given(spec)
                .when()
                .delete("/{first}/{second}");

        // Send DELETE request to delete the role
        spec.pathParams("first", "role", "second", 5);

        // Print response body
        response.prettyPrint();

        // Assert response status code is 403
        assertEquals(response.getStatusCode(),403);
    }
}

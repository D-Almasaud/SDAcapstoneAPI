package Test.Rand;

import baseUrl.QuasparepartsBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UserServices extends QuasparepartsBaseUrl {

    @Test
    public void GetOrSearchUsersOfApplication() {
        spec.pathParams("first","v1"
        ,"second","application"
        ,"third",2
        ,"forth","user");

        Response response = given(spec)
                .when()
                .get("{first}/{second}/{third}/{forth}");
        // Print response body
        response.prettyPrint();
        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
    }

    @Test
    public void GetOrSearchUsersOfOrganization() {
        spec.pathParams("first","v1"
                ,"second","organization"
                ,"third","1715291982442324"
                ,"forth","user");

        Response response = given(spec)
                .when()
                .get("{first}/{second}/{third}/{forth}");
        // Print response body
        response.prettyPrint();
        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
    }

    @Test
    public void DeleteUsersOfOrganization() {
        spec.pathParams("first", "v1",
                "second", "organization",
                "third", "11715291982442324",
                "forth", "user",
                "fifth", 1813);

        Response response = given(spec)
                .when()
                .delete("{first}/{second}/{third}/{forth}/{fifth}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
    }

    @Test
    public void addRegisterNewUserManually() {
        spec.pathParams("first", "v1", "second", "organization",
                "third", "user",
                "forth", "register-manual");

        // Set the request body for the POST request
        String requestBody = "{\n" +
                "    \"app_id\": 2,\n" +
                "    \"organization_id\": 1715291772802536,\n" +
                "    \"email\": \"rm.506@hotmail.com\",\n" +
                "    \"subscription_id\": \"05b57412-412a-4f10-9877-a9c9734f2159\",\n" +
                "    \"default_role_id\": 23\n" +
                "}";

        Response response = RestAssured.given()
                .spec(spec)
                .body(requestBody) // Set the request body
                .when()
                .post("/{first}/{second}/{third}/{forth}"); // Changed method to POST

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(), 201);
    }


    @Test
    public void GetOrSearchUsersWithKeysetPagination() {
        spec.pathParams("first","v1"
                ,"second","user");

        Response response = given(spec)
                .when()
                .get("{first}/{second}");
        // Print response body
        response.prettyPrint();
        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
    }

    @Test
    public void updateRegisterNewUserManually() {
        spec.pathParams("first", "v1", "second", "user");

        // Set the request body for the PUT request
        String requestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"name\": \"John\",\n" +
                "  \"lastname\": \"JAMES\",\n" +
                "  \"username\": \"john\",\n" +
                "  \"email\": \"ra@example.com\",\n" +
                "  \"is_email_verified\": true,\n" +
                "  \"phone\": \"+1 123 123 4567\",\n" +
                "  \"address\": \"string\",\n" +
                "  \"country_id\": \"US\",\n" +
                "  \"pic_id\": 12345,\n" +
                "  \"preferences\": {},\n" +
                "  \"status_id\": 12345,\n" +
                "  \"user_groups\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"Sales Department\",\n" +
                "      \"short_name\": \"Sales Dept.\",\n" +
                "      \"group_type_id\": 0,\n" +
                "      \"pic_id\": 12345,\n" +
                "      \"organization_id\": 12345,\n" +
                "      \"is_head\": false\n" +
                "    }\n" +
                "  ],\n" +
                "  \"created_at\": \"2024-05-16T06:41:26.883Z\",\n" +
                "  \"created_by\": 0,\n" +
                "  \"updated_at\": \"2024-05-16T06:41:26.883Z\",\n" +
                "  \"updated_by\": 0\n" +
                "}";

        Response response = RestAssured.given()
                .spec(spec)
                .body(requestBody) // Set the request body
                .when()
                .put("/{first}/{second}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
    }


    @Test
    public void GetUsersOfUserGroups() {
        spec.pathParams("first","v1"
                ,"second","user-group"
                ,"third",166
                ,"forth","user");

        Response response = given(spec)
                .when()
                .get("{first}/{second}/{third}/{forth}");
        // Print response body
        response.prettyPrint();
        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
    }
    @Test
    public void GetUserById() {
        spec.pathParams("first","v1"
                ,"second","user"
                ,"third",1715);

        Response response = given(spec)
                .when()
                .get("{first}/{second}/{third}");
        // Print response body
        response.prettyPrint();
        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
    }

    @Test
    public void DeleteExistingUserById() {
        spec.pathParams("first", "v1",
                "second", "user",
                "third", "1821");

        Response response = given(spec)
                .when()
                .delete("{first}/{second}/{third}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(), 403);
    }


}


package Test.userServices;

import baseUrl.QuasparepartsBaseUrl;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserServices.CreateUserPOJO;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UserServices extends QuasparepartsBaseUrl {
    CreateUserPOJO requestBody;
    int id;
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
                ,"third","1716152660399179"
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
                "third", "1716152660399179",
                "forth", "user",
                "fifth", 40);

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
        String requestBodyStr = """
                {
                    "id": null,
                    "app_id": 2,
                    "organization_id": 1716152660399179,
                    "email": "assurew.tmimi@gmail.com",
                    "subscription_id": "af7db802-90cc-46d8-b256-d4bf1d0f735d",
                    "default_role_id": 19,
                    "user_groups": [
                        {
                            "id": 28
                        }
                    ]
                }""";

        requestBody = ObjectMapperUtils.convertJsonToJava(requestBodyStr, CreateUserPOJO.class);
        requestBody.setEmail(Faker.instance().internet().emailAddress());
        requestBody.setId(null);
        Response response = RestAssured.given()
                .spec(spec)
                .body(requestBody) // Set the request body
                .when()
                .post("/{first}/{second}/{third}/{forth}"); // Changed method to POST

        // Print response body
        response.prettyPrint();
        CreateUserPOJO actualDAta = ObjectMapperUtils.convertJsonToJava(response.asString(), CreateUserPOJO.class);
        id = actualDAta.getId();
        // Assert response status code is 200
        assertEquals(response.statusCode(), 201);
        assertEquals(actualDAta.getEmail(),requestBody.getEmail());
        assertEquals(actualDAta.getOrganization_id(),requestBody.getOrganization_id());
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

    @Test(dependsOnMethods = "addRegisterNewUserManually")
    public void updateRegisterNewUserManually() {
        spec.pathParams("first", "v1", "second", "user");

        // Set the request body for the PUT request
        requestBody.setEmail("some@thing.known");
        requestBody.setId(id);

        Response response = RestAssured.given()
                .spec(spec)
                .body(requestBody) // Set the request body
                .when()
                .put("/{first}/{second}");

        // Print response body
        response.prettyPrint();
        CreateUserPOJO actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),CreateUserPOJO.class);

        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getEmail(),requestBody.getEmail());
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
                ,"third",39);

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
                "third", "28");

        Response response = given(spec)
                .when()
                .delete("{first}/{second}/{third}");

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.statusCode(), 403);
    }


}


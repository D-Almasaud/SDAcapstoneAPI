package Test.UserGroupServices;

import baseUrl.QuasparepartsBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.UserGroupServices.UserGruopFullPOJO;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UserGroupServices extends QuasparepartsBaseUrl {
    UserGruopFullPOJO requestBody;
    int id;
    @Test
    public void AddUsertoUserGroupoftheOrganization() {
        spec.pathParams("first", "organization",
                "second", "1716152660399179",
                "third", "user-group",
                "fourth", 91,
                "fifth", "user",
                "sixth", 78)
                .queryParam("IsHead","false");



        Response response = RestAssured.given()
                .spec(spec)
                //.body(requestBody) // Set the request body
                .when()
                .post("{first}/{second}/{third}/{fourth}/{fifth}/{sixth}"); // Use POST method

        // Print response body
        response.prettyPrint();

        // Assert response status code is 201
        assertEquals(response.statusCode(), 201);
    }

    @Test
    public void removeUserFromUserGroup() {
        // Setting path parameters for the endpoint
        spec.pathParams("first", "organization",
                        "second", "1716152660399179",
                        "third", "user-group",
                        "fourth", 91,
                        "fifth", "user",
                        "sixth", 78)
                .queryParam("IsHead","false");

        // Sending DELETE request to remove the user from the user group
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .delete("{first}/{second}/{third}/{fourth}/{fifth}/{sixth}"); // Using DELETE method

        // Print response body
        response.prettyPrint();

        // Assert response status code is 200
        assertEquals(response.getStatusCode(), 200);
    }




    @Test
    public void GetAllUserGroup() {

        spec.pathParams("first", "user-group");
        // Send GET request to retrieve GetAllUserGroups

        Response response = given(spec).when()
                .get("{first}");

        // Print response body
        response.prettyPrint();

       // OrganizationDTO responsePojo = response.as(OrganizationDTO.class);

        //Assert response status code is 200
        assertEquals(response.statusCode(), 200);

        // Assert  Education is so important in code"
       //Assert.assertTrue(response.contains("\"status\":Education is so important "));



    }

    @Test(dependsOnMethods = "AddNewUserGroup")
    public void updateUser() {
        spec.pathParams("first", "user-group");

        // Set the request body for the PUT request
        requestBody.setDescription("there is no impossible");
        requestBody.setId(id);

        Response response = RestAssured.given()
                .spec(spec)
                .body(requestBody) // Set the request body
                .when()
                .put("/{first}");

        // Print response body
        response.prettyPrint();
      UserGruopFullPOJO actualData = response.as(UserGruopFullPOJO.class);

        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
        Assert.assertEquals(actualData.getId(),requestBody.getId());
        Assert.assertEquals(actualData.getName(),requestBody.getName());
        Assert.assertEquals(actualData.getGroup_type_id(),requestBody.getGroup_type_id());
        Assert.assertEquals(actualData.getShort_name(),requestBody.getShort_name());
        Assert.assertEquals(actualData.getDescription(),requestBody.getDescription());
    }



    @Test
    public void AddNewUserGroup() {
        spec.pathParams("first", "user-group");

        // Set the request body for the POST request
        String requestBodyStr = """
                {
                    "id": null,
                    "name": "Team02",
                    "short_name": "EDU",
                    "description": "there is impossible",
                    "group_type_id": 3,
                    "organization_id": 1716152660399179
                }""";
        requestBody = ObjectMapperUtils.convertJsonToJava(requestBodyStr, UserGruopFullPOJO.class);
        Response response = RestAssured.given()
                .spec(spec)
                .body(requestBody) // Set the request body
                .when()
                .post("{first}"); // Use POST method

        // Print response body
        response.prettyPrint();
        UserGruopFullPOJO actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),UserGruopFullPOJO.class);

        id = actualData.getId();
        // Assert response status code is 201
        assertEquals(response.statusCode(), 201);
        Assert.assertEquals(actualData.getName(),requestBody.getName());
        Assert.assertEquals(actualData.getGroup_type_id(),requestBody.getGroup_type_id());
        Assert.assertEquals(actualData.getShort_name(),requestBody.getShort_name());
        Assert.assertEquals(actualData.getDescription(),requestBody.getDescription());

    }






    @Test
    public void GetUserGroupbyId() {

        spec.pathParams("first", "user-group", "second", 39);
        // Send GET request to retrieve GetUserGroupbyId

        Response response = given(spec).when()
                .get("{first}/{second}");

        // Print response body
        response.prettyPrint();

        //Assert response status code is 200
        assertEquals(response.statusCode(), 200);
        //Assert UserGroupbyId is 2
       // assertEquals(2, id, "ID 2");
    }




    @Test
    public void deleteExistingUserGroupById() {
        // Set the ID of the user group to be deleted
        int userGroupId = 2308;

        // Send a DELETE request to delete the user group by its ID
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .delete("/user-group/" + userGroupId);

        // Assert response status code is 200
        assertEquals(response.getStatusCode(), 200);
    }

}
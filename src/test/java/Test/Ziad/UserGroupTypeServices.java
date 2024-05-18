package Test.Ziad;

import baseUrl.QuasparepartsBaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.UserGroupTypeServices.CreateUserGroupTypePojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertTrue;

public class UserGroupTypeServices extends QuasparepartsBaseUrl {

    int id;

    //Get all the group user type
    @Test(description = "Get all the group user type")
    public void TC008_01() {

        spec.pathParam("first", "user-group-type");

        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        response
                .then()
                .statusCode(200);
        String responseStr = response.asString();
        assertTrue(responseStr.contains("id"));

        response
                .then()
                .statusCode(200)
                .body(containsString("id"))
                .body(containsString("name"));
    }


    //Negative test case, user search without having the token
    @Test
    public void TC008_02() {
        String url = "https://qa-gm3.quaspareparts.com/a3m/auth/api/user-group-type";
        Response response = given().when().get(url);
        System.out.println("(response = " + (response.statusCode()));
        response.then().statusCode(401);
    }


    @Test
    public void TC008_03() {
        spec.pathParam("first", "user-group-type");

        //Creating payload and making it Pojo
        CreateUserGroupTypePojo payload = new CreateUserGroupTypePojo();
        System.out.println("payload = " + payload);
        payload.setDescription(Faker.instance().lorem().sentence());
        payload.setName(Faker.instance().company().name());

        //Sending request POST
        Response response = given(spec).when().body(payload).post("{first}");
        response.prettyPrint();

        //Getiing the id from the response, so i can delete it later
        id = response.jsonPath().getInt("id");
        SoftAssert softAssert = new SoftAssert();

        //The actual data from the database we switching it to Pojo so we can assert it
        CreateUserGroupTypePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), CreateUserGroupTypePojo.class);

        //Asserting
        softAssert.assertEquals(201, response.statusCode());
        softAssert.assertEquals(actualData.getName(), payload.getName());
        softAssert.assertEquals(actualData.getDescription(), payload.getDescription());

    }

    //Negative test case, Creating with specsfic id
    @Test
    public void TC008_04() {
        spec.pathParam("first", "user-group-type");

        CreateUserGroupTypePojo payload = new CreateUserGroupTypePojo(111,"Ziad","Hi world");
        System.out.println("payload = " + payload);

        Response response = given(spec).when().body(payload).post("{first}");
        response.prettyPrint();

        response
                .then()
                .statusCode(500);
        System.out.println("statusCode = " + response.statusCode());
    }



    //Updating the User group
    @Test(dependsOnMethods = "TC008_03")
    public void TC008_05() {
        spec.pathParams("first", "user-group-type"
        ,"second",id);

        String expectedStr = "{\n" +
                "                        \"id\": "+ id +"  ,\n" +
                "                        \"name\": \"afterupdating11\",\n" +
                "                        \"description\": \"This Is Software Testing\"\n" +
                "                    }";


        CreateUserGroupTypePojo expectedToDo = ObjectMapperUtils.convertJsonToJava(expectedStr, CreateUserGroupTypePojo.class);

        Response response = given(spec).when().body(expectedToDo).put("{first}/{second}");
        response.prettyPrint();

        response.jsonPath().getString("name");

        CreateUserGroupTypePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), CreateUserGroupTypePojo.class);

        //Asserting
        Assert.assertEquals(200, response.statusCode());            // After updating u get 200
        Assert.assertEquals(actualData.getName(), expectedToDo.getName());
        Assert.assertEquals(actualData.getDescription(), expectedToDo.getDescription());

    }

    //Updating the User group with null id
    @Test(dependsOnMethods = "TC008_03")
    public void TC008_06() {
        spec.pathParams("first", "user-group-type"
                , "second", id);

        String expectedStr = """
                {
                                        "id": null  ,
                                        "name": "afterupdating",
                                        "description": "This Is Software Testing"
                                    }""";


        CreateUserGroupTypePojo expectedToDo = ObjectMapperUtils.convertJsonToJava(expectedStr, CreateUserGroupTypePojo.class);
        //Suleyman method
//        expectedToDo.setId(id);

        Response response = given(spec).when().body(expectedToDo).put("{first}/{second}");
        response.prettyPrint();

        response
                .then()
                .statusCode(500);
        System.out.println("statusCode = " + response.statusCode());         // After updating u get 500

    }

    @Test(dependsOnMethods = "TC008_06")
    public void TC008_07() {
        spec.pathParams("first", "user-group-type"
                , "second", id);

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

    }




    //    //Depends on the creating TestCase so we can store the id and delete it
//    @Test(dependsOnMethods = "TC008_03")
//    public void TC008_10() {
//        spec.pathParam("first", "user-group-type");
//    }
//
//}


}
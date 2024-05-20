package Test.userServices;

import baseUrl.Baseurlinfo;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetUserInfo extends Baseurlinfo {

    @Test
    public void getUserInfoTest() {
        // Set base URI using the QuasparepartsBaseUrl class
        // The base URI is already set in the static block of QuasparepartsBaseUrl class
        spec.pathParam("first","userinfo");
        // Send GET request to retrieve user inf

        Response response = given(spec).when().get("{first}");

        // Print response body
        response.prettyPrint();
      //  id =response.jsonPath().getInt("sub_app");
      //  System.out.println("id = " + id);
        //Assert response status code is 200
        assertEquals(response.statusCode(),200);
    }

}

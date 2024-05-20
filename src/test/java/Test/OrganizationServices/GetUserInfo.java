package Test.OrganizationServices;

import baseUrl.AbdullahBaseUrl;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetUserInfo extends AbdullahBaseUrl {


    static long sub_id;

    @Test
    public void getUserInfoTest() {

       spec.pathParam("first","userinfo");

        Response response = given(spec).get("{first}");

        response.prettyPrint();

        //Assert response status code is 200
        assertEquals(response.statusCode(),200);


        JsonPath json =response.jsonPath();
        sub_id = json.get("sub_app");

        File file = new File("sub_id");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write(("" + sub_id).getBytes());
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
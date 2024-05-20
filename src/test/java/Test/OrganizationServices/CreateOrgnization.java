package Test.OrganizationServices;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.organization.CreateOrgnizationPOJO;

import java.io.*;

import static baseUrl.QuasparepartsBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class CreateOrgnization {

    static long orgId;


    @Test
    public void CreateOrganizationTest(){

        spec.pathParam("first", "organization");

        //1

        CreateOrgnizationPOJO payloadEmir = new CreateOrgnizationPOJO( 7,"Abdullah1234");

        Response response = given()
                .spec(spec)
                .body(payloadEmir)
                .when()
                .post("{first}");




        JsonPath json =response.jsonPath();
        json.prettyPrint();
        orgId = json.get("id");

        File file = new File("ids");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write(("" + orgId).getBytes());
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }


    }





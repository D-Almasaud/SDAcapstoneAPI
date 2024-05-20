package Test.OrganizationServices;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static Test.OrganizationServices.GetAllOrganization.testId;
import static baseUrl.QuasparepartsBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class GetOrganizationByAppId {

@Test
        public void getOrgByAppId(){

    spec.pathParams("first","organization");

    Response response = given(spec).when().get("{first}");
    response.then().statusCode(200)
            .contentType(ContentType.JSON);
    //response.prettyPrint();

    JsonPath json =response.jsonPath();
    json.prettyPrint();
    //id = json.get("sub_app");





}


}

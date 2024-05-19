package Test.OrganizationServices;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.organization.OrganizitionPOJO;

import static baseUrl.QuasparepartsBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static Test.OrganizationServices.GetAllOrganization.*;

public class GetOrganizationById {


    @Test(dependsOnMethods = "Test.OrganizationServices.GetAllOrganization.GetAllOrganizationTest")
    public void GetOrganizationByIdTest(){
//        System.out.println("testId = " + testId);
        spec.pathParams("first","organization","second",testId);
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
       OrganizitionPOJO actualData = response.as(OrganizitionPOJO.class);
//        System.out.println("actualData.getName() = " + actualData.getName());
//        System.out.println("testName = " + testName);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(actualData.getId(),testId);
        Assert.assertEquals(actualData.getName().split("-")[0],newTry);
        Assert.assertEquals(actualData.getFounder_id(),founder_id);

    }


}

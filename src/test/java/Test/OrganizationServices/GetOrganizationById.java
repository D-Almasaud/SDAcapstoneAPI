package Test.OrganizationServices;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.organization.OrganizitionPOJO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static baseUrl.Baseurlinfo.spec;
import static io.restassured.RestAssured.given;
import static Test.OrganizationServices.GetAllOrganization.*;

public class GetOrganizationById {

// this test for checking the organization from all organizations by selecting randomly from the list
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



    @Test //this test for checking the organization was deleting
    public void GetOrganizationByIdWasCreatedTest() throws FileNotFoundException {

        File file = new File("ids");
        Scanner scanner = new Scanner(file);
        long orgId = scanner.nextLong();
        scanner.close();

        spec.pathParams("first","organization","second",orgId);
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),404);


    }



}

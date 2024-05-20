package Test.OrganizationServices;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static baseUrl.Baseurlinfo.spec;
import static io.restassured.RestAssured.given;

public class DeleteCreatedOrg {

    @Test
    public void DeleteOrganizationBySavedIdTest() throws FileNotFoundException {

        // Read orgId from file
        File file = new File("ids");
        Scanner scanner = new Scanner(file);
        long orgId = scanner.nextLong();
        scanner.close();

        spec.pathParams("first", "organization", "second", orgId);

        Response response = given()
                .spec(spec)
                .when()
                .delete("/{first}/{second}");

        response.then().statusCode(200);

        System.out.println("Deleted Organization ID: " + orgId);
    }


    @Test(dependsOnMethods = "Test.OrganizationServices.CreateOrgnization.CreateOrganizationTest")
    public void DeleteOrganizationTestAfterCreated() throws FileNotFoundException {

        // Read orgId from file
        File file = new File("ids");
        Scanner scanner = new Scanner(file);
        long orgId = scanner.nextLong();
        scanner.close();

        spec.pathParams("first", "organization", "second", orgId);

        Response response = given()
                .spec(spec)
                .when()
                .delete("/{first}/{second}");

        response.then().statusCode(200);

        System.out.println("Deleted Organization ID: " + orgId);
    }


}

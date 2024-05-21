package Test.OrganizationServices;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static baseUrl.Baseurlinfo.spec;
import static io.restassured.RestAssured.given;

public class DeleteCreatedOrg {

    @Test // this test reads an organization ID from a file and deletes the corresponding organization using an API request
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

        // verifying a successful deletion and print the deletion ID
        response.then().statusCode(200);

        System.out.println("Deleted Organization ID: " + orgId);
    }



// this test, which depends on the successful execution of Create Organization, reads an organization ID from a file
// and deletes the corresponding organization using an API request
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

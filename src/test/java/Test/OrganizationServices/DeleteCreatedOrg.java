package Test.OrganizationServices;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static baseUrl.QuasparepartsBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class DeleteCreatedOrg {

    @Test(dependsOnMethods = "Test.OrganizationServices.CreateOrgnization.CreateOrganizationTest")
    public void DeleteOrganizationTest() throws FileNotFoundException {
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

        response.then().statusCode(404);

        System.out.println("Deleted Organization ID: " + orgId);
    }
}

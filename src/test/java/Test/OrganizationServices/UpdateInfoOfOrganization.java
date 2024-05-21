package Test.OrganizationServices;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.organization.OrganizitionPOJO;
import utilities.ObjectMapperUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static baseUrl.Baseurlinfo.spec;
import static io.restassured.RestAssured.given;

public class UpdateInfoOfOrganization {

    @Test
    public void UpdateOrganizationTest() throws FileNotFoundException {

        // Read orgId from file
        File file = new File("ids");
        Scanner scanner = new Scanner(file);
        long orgId = scanner.nextLong();
        scanner.close();

        spec.pathParam("first", "organization");


        String paylod ="{\n" +
                "    \"id\": "+orgId+",\n" +
                "    \"name\": \""+ Faker.instance().name().firstName() +"\",\n" +
                "    \"founder_id\": 5,\n" +
                "    \"created_at\": \"2024-05-20T12:54:38.708846Z\",\n" +
                "    \"created_by\": 0,\n" +
                "    \"updated_at\": \"2024-05-20T12:54:38.708848Z\",\n" +
                "    \"updated_by\": 0\n" +
                "}";

        OrganizitionPOJO expictedToDo  = ObjectMapperUtils.convertJsonToJava(paylod, OrganizitionPOJO.class);

        Response response = given(spec)
                .when()
                .body(expictedToDo)
                .put("/{first}");

        response.then().statusCode(200);

        System.out.println("updating Organization ID: " + orgId);
        System.out.println("Organization after updating = " + paylod);
    }
}

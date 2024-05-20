package Test.OrganizationServices;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static baseUrl.Baseurlinfo.spec;
import static io.restassured.RestAssured.given;

public class GetOrganizationByAppId {

@Test
        public void getOrgByAppId() throws FileNotFoundException {

    // Read sub_id from file
    File file = new File("sub_id");
    Scanner scanner = new Scanner(file);
    int supId = scanner.nextInt();
    scanner.close();


    spec.pathParams("first","application","second",supId,"third","organization");
    Response response = given(spec).when().get("/{first}/{second}/{third}").then().log().all().extract().response();
    //response.prettyPrint();


}


}

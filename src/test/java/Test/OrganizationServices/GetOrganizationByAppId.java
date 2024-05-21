package Test.OrganizationServices;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static baseUrl.Baseurlinfo.spec;
import static io.restassured.RestAssured.given;

public class GetOrganizationByAppId {

@Test // this test for get info of organization by subscription id
public void getOrgByAppId() throws FileNotFoundException {

    // Read from "sub_id" file the subscription id was saved in that file after run user info test
    File file = new File("sub_id");
    Scanner scanner = new Scanner(file);
    int supId = scanner.nextInt();
    scanner.close();
  
    // get all info by useing subscription id
    spec.pathParams("first","application","second",supId,"third","organization");
    Response response = given(spec).when().get("/{first}/{second}/{third}").then().log().all().extract().response();
    response.prettyPrint();


}


}

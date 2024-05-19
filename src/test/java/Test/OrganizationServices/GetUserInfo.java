package Test.OrganizationServices;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.organization.OrganizationDTO;

import static baseUrl.QuasparepartsBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class GetUserInfo {

   @Test
   public void test(){
       String url = "https://qa-gm3.quaspareparts.com/a3m/auth/userinfo";
       Response response = given().get(url);
       response.then().contentType(ContentType.JSON);
       response.prettyPrint();
   }

}

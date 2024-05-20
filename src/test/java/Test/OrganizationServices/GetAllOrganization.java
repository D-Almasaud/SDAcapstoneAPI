package Test.OrganizationServices;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static baseUrl.QuasparepartsBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class GetAllOrganization {

    static Long testId;
   static Object testName;
   static Object founder_id;
    static String newTry;
    @Test
    public void GetAllOrganizationTest(){

        spec.pathParams("first","organization");

        Response response = given(spec).when().get("{first}");
        response.then().statusCode(200)
                        .contentType(ContentType.JSON);
        //response.prettyPrint();

        JsonPath json =response.jsonPath();
        List<Long> idList = json.getList("id");
        int idSize = idList.size();

        System.out.println("idSize = " + idSize);

        Random random = new Random();
        int idx = random.nextInt(idSize);

        testId = idList.get(idx);
        System.out.println("testId = " + testId);

        testName =json.getList("findAll{it.id==1714394869798336}.name").get(0);
        founder_id =json.getList("findAll{it.id==1714394869798336}.founder_id").get(0);
        System.out.println((json.getList("findAll{it.id==1714394869798336}.founder_id").size()));
        String tryName = testName.toString();
//        System.out.println("testName = " + testName);
//        System.out.println("tryName = " + tryName);
        newTry =tryName.split("-")[0];
        System.out.println("newTry = " + newTry);

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertTrue(idSize>0);

    }




}

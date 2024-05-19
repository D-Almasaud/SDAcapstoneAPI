package Test.UserStatusServices;

import baseUrl.QuasparepartsBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.UserStatusServices.USSPOJO;

import java.util.List;
import java.util.Random;

import static baseUrl.QuasparepartsBaseUrl.spec;
import static io.restassured.RestAssured.given;


public class USS extends QuasparepartsBaseUrl{

    int id;
    Object testName;
    Object testDescription;
    int testId;

    @Test(priority = 0)
    public void TC10_01(){

        spec.pathParam("1st","user-status");

        Response res = given(spec).when().get("{1st}");
        res.prettyPrint();

        JsonPath json = res.jsonPath();
        int listSize = json.getList("id").size();
        System.out.println("listSize = " + listSize);

        Random random = new Random();
        int idx =random.nextInt(listSize)-1;

        System.out.println(idx);

        List<Integer> idList = json.getList("id");
        testId = idList.get(idx);

        testName = json.getList("findAll{it.id=="+testId+"}.name").get(0);
        testDescription = json.getList("findAll{it.id=="+testId+"}.description").get(0);



        Assert.assertTrue(listSize>0);

        //res.then().statusCode(200);
        Assert.assertEquals(res.statusCode(),200);


        System.out.println("------------------------------------------------------");
    }

    @Test(priority = 1)
    public void TC10_02(){


        spec.pathParam("1st","user-status");

        USSPOJO payload = new USSPOJO(null,"Active","This user is Active");

        Response res = given(spec).body(payload).when().post("{1st}");
        id = res.jsonPath().getInt("id");

        res.prettyPrint();
        USSPOJO actualData = res.as(USSPOJO.class);
        //USSPOJO actualData = ObjectMapperUtils.convertJsonToJava(res.asString(),USSPOJO.class);

        Assert.assertEquals(201,res.statusCode());
        Assert.assertEquals(actualData.getName(),payload.getName());
        Assert.assertEquals(actualData.getDescription(),payload.getDescription());



        System.out.println("------------------------------------------------------");
    }

    @Test(priority = 2,dependsOnMethods = "TC10_02")
    public void TC10_03(){

        spec.pathParams("1st","user-status"
                        ,"2nd",id);

        Response res = given(spec).when().get("{1st}/{2nd}");
        res.prettyPrint();

//        JsonPath json = res.jsonPath();
//        int listSize = json.getList("id").size();

        //res.then().statusCode(200);
        Assert.assertEquals(res.statusCode(),200);


        System.out.println("------------------------------------------------------");
    }

    @Test(dependsOnMethods = "TC10_02")
    public void getRandomUser(){

        spec.pathParams("1st","user-status"
                ,"2nd",testId);

        Response res = given(spec).when().get("{1st}/{2nd}");
        res.prettyPrint();

//        JsonPath json = res.jsonPath();
//        int listSize = json.getList("id").size();

        USSPOJO actualData =res.as(USSPOJO.class);
        //res.then().statusCode(200);
        Assert.assertEquals(res.statusCode(),200);
        Assert.assertEquals(actualData.getId(),testId);
        Assert.assertEquals(actualData.getName(),testName);
        Assert.assertEquals(actualData.getDescription(),testDescription);



        System.out.println("------------------------------------------------------");
    }
    @Test(priority = 3 , dependsOnMethods = "TC10_02")
    public void TC10_04(){


        spec.pathParam("1st","user-status");

        USSPOJO payload = new USSPOJO(null, "Active", "This user is Active");
        payload.setId(id);
        payload.setDescription("This is Changed");


        Response res = given(spec).body(payload).when().put("{1st}");

        res.prettyPrint();

        spec.pathParams("1st","user-status"
                            ,"2nd",id);
        given(spec).when().get("{1st}/{2nd}").then().body(Matchers.containsString(id +""));





        System.out.println("------------------------------------------------------");
    }


    @Test(priority = 4, dependsOnMethods = "TC10_02")
    public void TC10_05(){

        spec.pathParams("1st","user-status"
                ,"2nd",id);

        Response res = given(spec).when().delete("{1st}/{2nd}");
        res.prettyPrint();

        Assert.assertEquals(res.statusCode(),200);

        given(spec).when().get("{1st}/{2nd}").then().statusCode(404);



        System.out.println("------------------------------------------------------");
    }




}

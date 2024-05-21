package Test.MembershipType;

import baseUrl.QuasparepartsBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.MembershipTypeServices.MembershipType;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class MTS extends QuasparepartsBaseUrl {


    @Test
    public void TC3_01() {
        //Get all membership types
        spec.pathParams("first","membership-type");

        // Send request and get respnse
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertEquals("Company Membership", response.jsonPath().getString("[0].name"));
        assertEquals("Guest Membership", response.jsonPath().getString("[1].name"));
    }

    @Test
    public void TC3_02() {
        //Get membership type by id
        spec.pathParams("first","membership-type","second", 5);

        // Send request and get respnse
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertEquals("Company Membership", response.jsonPath().getString("name"));
        assertEquals("Comp. Membr.", response.jsonPath().getString("short_name"));
        assertEquals(true, response.jsonPath().getBoolean("is_enabled"));
        assertEquals(2, response.jsonPath().getInt("app_id"));
    }
    @Test
    public void TC3_03() {
        //Get all application membership types of the app
        spec.pathParams("first","application","second", "2","third","membership-type");

        // Send request and get respnse
        Response response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertEquals("Company Membership", response.jsonPath().getString("[0].name"));
        assertEquals("Guest Membership", response.jsonPath().getString("[1].name"));
    }

    @Test
    public void TC3_04() {
        //Create membership type
        spec.pathParams("first","membership-type");

        MembershipType payload = new MembershipType(58, "Test Membership");


        // Send request and get respnse
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        assertEquals(403, response.statusCode());
        assertEquals("Forbidden", response.jsonPath().getString("error"));
    }

    @Test
    public void TC3_05() {
        //Create membership type without body
        spec.pathParams("first","membership-type");

       // MembershipType payload = new MembershipType();


        // Send request and get respnse
        Response response = given(spec).when().post("{first}");
        response.prettyPrint();

        assertEquals(406, response.statusCode());
    }

    @Test
    public void TC3_06() {
        //Update existing membership type
        spec.pathParams("first","membership-type");

      MembershipType payload = new MembershipType(5, "Test Membership");


        // Send request and get respnse
        Response response = given(spec).body(payload).when().put("{first}");
        response.prettyPrint();

        assertEquals(403, response.statusCode());
        assertEquals("Forbidden", response.jsonPath().getString("error"));
    }

    @Test
    public void TC3_07() {
        //Delete existing membership type by ID
        spec.pathParams("first","membership-type","second", 5);


        // Send request and get respnse
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(403, response.statusCode());
        assertEquals("Forbidden", response.jsonPath().getString("error"));
    }






}

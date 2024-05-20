package Test.Reema;
import baseUrl.QuasparepartsBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class OrgnizationStatusServices extends QuasparepartsBaseUrl {

    @Test
    public void GetOrSearchUsersOfApplication() {
        spec.pathParams("first", "organization-status"
                );

        Response response = given(spec)
                .when()
                .get("{first}");
        // Print response body
        response.prettyPrint();
        // Assert response status code is 200
        assertEquals(response.statusCode(), 200);
    }

}

package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static utilities.AuthenticationUI.getSessionId;

public class QuadripartiteBaseUrl {


    public static RequestSpecification spec;
    public String sessionID;

    @BeforeSuite
    public void getSID(){


        sessionID = getSessionId();


    }


@BeforeMethod
    public void setUp(){

        spec = new RequestSpecBuilder()
                .setBaseUri("https://qa-gm3.quaspareparts.com/a3m/auth/api")
                .setContentType(ContentType.JSON)
                .addHeader("Cookie", "GSESSIONID=" + sessionID)
                .build();

    }

}
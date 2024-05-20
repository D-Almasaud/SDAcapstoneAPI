package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.AuthenticationUI.getSessionId;

public class Baseurlinfo {


    public static RequestSpecification spec;

    static {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://qa-gm3.quaspareparts.com/a3m/auth/api")
                .setContentType(ContentType.JSON)
                .addHeader("Cookie", "GSESSIONID=" + getSessionId())
                .build();

    }


}

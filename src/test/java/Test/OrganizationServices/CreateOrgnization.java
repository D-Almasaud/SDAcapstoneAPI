package Test.OrganizationServices;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pojos.organization.OrganizationDTO;
import utilities.ObjectMapperUtils;

import static baseUrl.QuasparepartsBaseUrl.spec;

public class CreateOrgnization {



    @Test
    public void CreateOrganizationTest(){

        spec.pathParams("first", "pojos/organization");

        //1
     OrganizationDTO paylod = new OrganizationDTO("Abdullah alshaker"
             , 5
             , "2024-04-23T16:35:41.492077Z"
             , 5
             , "2024-05-15T09:07:15.578529Z"
             , 5);

        System.out.println("paylod = " + paylod);


        //2
//        OrganizationDTO paylod2 = new OrganizationDTO();
//        paylod2.setName(Faker.instance().name().firstName());
//        paylod2.setCreatedAt(Faker.instance().bothify(Faker.instance().toString()).toLowerCase());
//
//
//
//        //3
//
//        String body = """
//                {
//                    "name": "Abdullah alshaker",
//                    "founder_id": 5,
//                    "created_at": "2024-04-23T16:35:41.492077Z",
//                    "created_by": 5,
//                    "updated_at": "2024-05-15T09:07:15.578529Z",
//                    "updated_by": 5
//                }""";
//
//     OrganizationDTO paylod3 = ObjectMapperUtils.convertJsonToJava(body,OrganizationDTO.class);
//        paylod3.setName(Faker.instance().name().firstName());

    }


    }





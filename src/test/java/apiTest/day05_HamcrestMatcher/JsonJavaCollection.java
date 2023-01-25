package apiTest.day05_HamcrestMatcher;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;




public class JsonJavaCollection {

    @Test
    public void UserToMap(){
        Response response=given().accept(ContentType.JSON)
                .when().get("https://demoqa.com/Account/v1/User/11");

                        Assert.assertEquals(response.statusCode(),401);

        Map<String,Object>jsonMap= response.body().as(Map.class);
        System.out.println("jsonMap = " + jsonMap);

        //verify the message
        String message= (String) jsonMap.get("message");
        System.out.println("message = " + message);
        Assert.assertEquals(message,"User not authorized!");

        //verify the code
        String code= (String) jsonMap.get("code");
        System.out.println("code = " + code);
        Assert.assertEquals(code,"1200");
    }
}

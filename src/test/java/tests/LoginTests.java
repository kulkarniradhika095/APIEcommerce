package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import datadriven.Environment;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.LoginRequest;
import pojo.LoginResponse;

public class LoginTests {
	@Test
	public static void ProdLogin() {
		RestAssured.baseURI = Environment.baseUrl;
		
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail(Environment.UserName);
		loginRequest.setUserPassword(Environment.PASSWORD);
		String response = given().log().all()
				 .header("Content-Type","application/json")
				 .body(loginRequest)
				 .when().post(Environment.APIlogin).then().assertThat().statusCode(200).log().all().extract()
				.response().toString();
		LoginResponse loginResponse = new LoginResponse();
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getUserId());
		JsonPath js = new JsonPath(response);
		System.out.println(js);
	}
}

package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Payloads.Payload;
import datadriven.Environment;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CartTests {
	@Test
	public static void placeOrder() {
		RestAssured.baseURI = Environment.baseUrl;
		String response = given().log().all().body(Payload.orderPayload1("India","6262e990e26b7e1a10e89bfa")).header("Content-Type", "application/json")
				.header("Authorization",
						"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4YmZmZWQ3Nzc4ZjU3OTczNTc5ODAiLCJ1c2VyRW1haWwiOiJrdWxrYXJuaXJhZGhpa2EwOTVAZ21haWwuY29tIiwidXNlck1vYmlsZSI6ODE0OTM5NTc3MywidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTY2ODg1ODM2NiwiZXhwIjoxNzAwNDE1OTY2fQ.VyDnbCTt00t2tuUogbHojqBLFsNMBCmqsDKRFtIpkuo")
				.when().post(Environment.APIPlaceOrder).then().log().all().extract().response().asString();
		JsonPath js = new JsonPath(response);
		System.out.println(js);
		Assert.assertEquals("Order Placed Successfully", js.get("message"));
	}

	@Test
	public static void getOrderDetails() {
		RestAssured.baseURI = Environment.baseUrl;
		String response = given().log().all().header("Content-Type", "application/json").queryParam("id", "6379c3efd7778f579735ddd0")
				.header("Authorization",
						"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4YmZmZWQ3Nzc4ZjU3OTczNTc5ODAiLCJ1c2VyRW1haWwiOiJrdWxrYXJuaXJhZGhpa2EwOTVAZ21haWwuY29tIiwidXNlck1vYmlsZSI6ODE0OTM5NTc3MywidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTY2ODg1ODM2NiwiZXhwIjoxNzAwNDE1OTY2fQ.VyDnbCTt00t2tuUogbHojqBLFsNMBCmqsDKRFtIpkuo")
				.when().get(Environment.APIGetOrderDetails).then().log().all().extract().response().asString();
		JsonPath js = new JsonPath(response);
		System.out.println(js);
		Assert.assertEquals("Orders fetched for customer Successfully", js.get("message"));
		
	}
}

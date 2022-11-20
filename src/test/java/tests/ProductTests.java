package tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import datadriven.Environment;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class ProductTests {
	@Test
	public static void addProduct() {
		RestAssured.baseURI = Environment.baseUrl;
		String response = given().log().all().header("Authorization",
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4YmZmZWQ3Nzc4ZjU3OTczNTc5ODAiLCJ1c2VyRW1haWwiOiJrdWxrYXJuaXJhZGhpa2EwOTVAZ21haWwuY29tIiwidXNlck1vYmlsZSI6ODE0OTM5NTc3MywidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTY2ODg1ODM2NiwiZXhwIjoxNzAwNDE1OTY2fQ.VyDnbCTt00t2tuUogbHojqBLFsNMBCmqsDKRFtIpkuo")
				.param("productName", "Laptop").param("productAddedBy", "6378bffed7778f5797357980")
				.param("productCategory", "fashion").param("productSubCategory", "shirts")
				.param("productPrice", "11500").param("productDescription", "Lenova").param("productFor", "men")
				.multiPart("productImage", new File("C:\\Users\\radhi\\Postman\\files\\e28VfFi.jpg")).when()
				.post(Environment.APIAddProduct).then().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(response);
		System.out.println(js);
	}

	@Test
	public static void deleteProduct() {
		RestAssured.baseURI = Environment.baseUrl;
		String response =given().log().all().header("Authorization",
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4YmZmZWQ3Nzc4ZjU3OTczNTc5ODAiLCJ1c2VyRW1haWwiOiJrdWxrYXJuaXJhZGhpa2EwOTVAZ21haWwuY29tIiwidXNlck1vYmlsZSI6ODE0OTM5NTc3MywidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTY2ODg1ODM2NiwiZXhwIjoxNzAwNDE1OTY2fQ.VyDnbCTt00t2tuUogbHojqBLFsNMBCmqsDKRFtIpkuo")
				.pathParam("productId", "637a049bd7778f579736064d").when()
				.delete(Environment.APIDeleteProduct).then().assertThat().statusCode(200).log().all().extract().response().asString();
		JsonPath js1 = new JsonPath(response);
		Assert.assertEquals("Product Deleted Successfully", js1.get("message"));

	}
}

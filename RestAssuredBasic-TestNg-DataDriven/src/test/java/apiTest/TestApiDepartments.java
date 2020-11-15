package apiTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestApiDepartments {

	@Test(groups = { "E2E" }, priority = 1)
	public void testGetDeps() {
		baseURI = "http://localhost:3000/";
		given().headers("content-type", "application/json").contentType("Content-Type: application/json; charset=utf-8")
				.get("departments").then().statusCode(200).log().all();

	}

	@Test(groups = { "E2E" }, priority = 2)
	public void testGetDeps1WithUsers() {
		System.out.println("\n I want to display the users who belong to dep2 \n");
		baseURI = "http://localhost:3000/departments";
		given().headers("content-type", "application/json").contentType("Content-Type: application/json; charset=utf-8")
				.get("/1/users").then().statusCode(200).log().all();

	}

	@Test(groups = { "E2E" }, priority = 3)
	public void testGetDeps2WithUsers() {
		System.out.println("\n I want to display the users who belong to dep2 \n");
		baseURI = "http://localhost:3000/departments";
		given().headers("content-type", "application/json").contentType("Content-Type: application/json; charset=utf-8")
				.get("/2/users").then().statusCode(200).log().all();

	}

	@Test(groups = { "E2E" }, priority = 4)
	public void testGetDepsWithParams() {
		System.out.println("\n I want to display the depertment with paramter name \n");
		baseURI = "http://localhost:3000/";
		given().params("name", "QA").headers("content-type", "application/json")
				.contentType("Content-Type: application/json; charset=utf-8").get("departments").then().statusCode(200)
				.log().all();

	}

	@Test(groups = { "E2E" }, priority = 5)
	public void testAddDepart() {
		JSONObject department = new JSONObject();

		department.put("name", "Support");

		baseURI = "http://localhost:3000/";
		given().headers("Content-Type", "Application/Json").contentType(ContentType.JSON)
				.body(department.toJSONString()).when().post("departments").then().statusCode(201).log().all();

	}

	@Test(groups = { "E2E" }, priority = 6)
	public void testPutDepart() {
		JSONObject department = new JSONObject();
		department.put("name", "IT-support");
		baseURI = "http://localhost:3000/";
		given().headers("Content-Type", "Application/Json").contentType(ContentType.JSON)
				.body(department.toJSONString()).when().patch("departments/3").then().statusCode(200).log().all();

	}

	@Test(groups = { "E2E" }, priority = 7)
	public void testPatchUser() {
		JSONObject department = new JSONObject();
		department.put("name", "IT-System");
		baseURI = "http://localhost:3000/";
		given().headers("Content-Type", "Application/Json").contentType(ContentType.JSON)
				.body(department.toJSONString()).when().put("departments/3").then().statusCode(200).log().all();

	}

	@Test(groups = { "E2E" }, priority = 8)
	public void testDeleteUser() {

		baseURI = "http://localhost:3000/";
		given().delete("departments/3").then().statusCode(200).log().all();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("i'm after Method, i will executed after each method");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("i'm after Method, i will executed  before each method");
	}
}

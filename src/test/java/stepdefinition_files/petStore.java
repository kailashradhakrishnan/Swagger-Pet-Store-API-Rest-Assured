package stepdefinition_files;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class petStore {

	RequestSpecification request;
	Response res;

	// Scenario: Validate Post Request

	@Given("User sends the API request")
	public void user_sends_the_api_request() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
		RequestSpecification request = RestAssured.given();

	}

	@When("Submit user details to create new user")
	public void submit_user_details_to_create_new_user() {

		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 888450);
		requestParams.put("username", "klash");
		requestParams.put("firstName", "Kailash");
		requestParams.put("lastName", "Radhakrishnan");
		requestParams.put("email", "test@gmail.com");
		requestParams.put("phone", "8884501155");
		requestParams.put("userStatus", "100");

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		res = RestAssured.given().headers(headers).body(requestParams).when().post();
	}

	@Then("User validate the response with status code as {int}")
	public void user_validate_the_response_with_status_code_as(Integer int1) {

		res.then().assertThat().statusCode(int1);
	}

	// Scenario: Validate Get Request

	@Given("User sends the request")
	public void user_sends_the_request() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
		RequestSpecification request = RestAssured.given();
	}

	@When("Fetch the details of created user with username as {string}")
	public void fetch_the_details_of_created_user_with_username_as(String username) {
		res = RestAssured.given().contentType(ContentType.JSON).when()
				.get("https://petstore.swagger.io/v2/user/" + username).then().extract().response();

	}

	@Then("Validate the respose with status code as {int}")
	public void validate_the_respose_with_status_code_as(Integer int1) {
		res.then().assertThat().statusCode(int1);
	}

	// Scenario: Validate Put Request

	@Given("I Set PUT user api endpoint")
	public void i_set_put_user_api_endpoint() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
		RequestSpecification request = RestAssured.given();
	}

	@When("Update the details of created user with username as {string}")
	public void update_the_details_of_created_user_with_username_as(String string) {

		JSONObject requestParams = new JSONObject();
		requestParams.put("username", "klash");

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		RestAssured.given().body(requestParams.toJSONString());
		res = RestAssured.given().headers(headers).body(requestParams).put("/update/" + string);

	}

	@Then("Get respose with status code as {int}")
	public void get_respose_with_status_code_as(Integer int1) {
		res.then().assertThat().statusCode(int1);
	}

	// Scenario: Validate Delete Request

	@Given("I Set Delete api endpoint")
	public void i_set_delete_api_endpoint() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
		RequestSpecification request = RestAssured.given();
	}

	@When("Delete the details from the server")
	public void delete_the_details_from_the_server() {

		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 888450);
		requestParams.put("username", "klash");
		requestParams.put("firstName", "Kailash");
		requestParams.put("lastName", "Radhakrishnan");
		requestParams.put("email", "test@gmail.com");
		requestParams.put("phone", "8884501155");
		requestParams.put("userStatus", "100");

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		res = RestAssured.given().headers(headers).body(requestParams).delete("klash");
	}

	@Then("Validate with status code as {int}")
	public void validate_with_status_code_as(Integer int1) {
		res.then().assertThat().statusCode(int1);
	}

}

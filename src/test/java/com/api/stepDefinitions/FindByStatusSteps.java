package com.api.stepDefinitions;

import com.api.common.PgApiCommon;
import com.api.pageObjects.PgFindByStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FindByStatusSteps extends PgApiCommon {

	private PgFindByStatus findByStatus;
	private String findByStatusSchemaPath = "src/test/resources/schemas/findByStatus.json";

	public FindByStatusSteps() {
		findByStatus = new PgFindByStatus();
	}

	@Given("^I request the petstore url to find the pet using \"([^\"]*)\" status$")
	public void requestPetStoreUsingFindStatus(String status) throws Exception {
		findByStatus.findByStatus(status);
	}

	@Given("^I request the petstore url to find the pet using \"([^\"]*)\" and \"([^\"]*)\" status$")
	public void requestPetStoreUsingFindByMultipleStatus(String status1, String status2) throws Exception {
		findByStatus.findByStatus(status1, status2);
	}

	@And("^I should get status code as (\\d+)$")
	public void assertStatus(int statusCode) throws Exception {
		findByStatus.assertStatusCode(statusCode);
	}

	@And("^I verify the performance response time is less than or equal to (\\d+) milliseconds$")
	public void assertResponseTime(long time) {
		findByStatus.assertResponseTime(time);
	}

	@Then("^I verify all the pets with \"([^\"]*)\" as \"([^\"]*)\" in the result$")
	public void verifyPets(String field, String pets) throws Exception {
		findByStatus.verifyValueCount(field, pets);
	}

	@Then("^I verify all the pets with \"([^\"]*)\" as \"([^\"]*)\" in the result using json deserialize$")
	public void verifyPetsUsingPojo(String field, String pets) throws Exception {
		findByStatus.verifyPetNameUsingPojo(pets);
	}

	@Then("^I verify the response conforms to schema$")
	public void validateSchema() {
		findByStatus.validateSchema(findByStatusSchemaPath);
	}
}

package com.api.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/findByStatus.feature"},
		tags= "@findByStatus",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		glue = {"com.api.stepDefinitions"},
		publish = true
		)

public class FindByStatusRunner extends AbstractTestNGCucumberTests {
}

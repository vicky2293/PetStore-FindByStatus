package com.api.common;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import com.api.utils.ConfigFileReader;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PgApiCommon {

	protected Response response;
	private String baseUrl;
	private String resourcePath;
	private String url;
	private long responseTime;
	private int count;
	ConfigFileReader configFileReader;

	public PgApiCommon() {
		configFileReader = new ConfigFileReader();
	}

	public String getBaseUrl() throws Exception {
		try {
			baseUrl = configFileReader.getBaseUrl();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return baseUrl;
	}

	public String getResourcePath() throws Exception {
		try {
			resourcePath = configFileReader.getResource();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resourcePath;
	}

	public String getCompleteUrl() throws Exception {
		try {
			url = configFileReader.getBaseUrl() + configFileReader.getResource();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return url;
	}

	public void assertStatusCode(int statusCode) {
		try {
			response.then().assertThat().statusCode(statusCode);
			System.out.println("API call response status code: " + statusCode);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void assertResponseTime(long time) {
		try {
			responseTime = response.getTime();
			response.then().time(Matchers.lessThanOrEqualTo(time), TimeUnit.MILLISECONDS);
			System.out.println("Api response time is less than the expected response time " + time
					+ " ::  Actual response time is ::" + responseTime);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void verifyValueCount(String field, String value) {
		try {
			List<String> fields = response.jsonPath().getList(field);
			for (String f : fields) {
				if (f.contains(value)) {
					count++;
				}
			}
			System.out.println("Using jsonPath(): Number of fields with " + field + " as " + value + " are: " + count);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validateSchema(String schemaPath) {
		try {
			response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
			System.out.println("Valid JSON Schema: " + new String(Files.readAllBytes(Paths.get(schemaPath))));
		} catch (Exception e) {
			System.out.println("Invalid Schemae " + e.getMessage());
		}
	}
}

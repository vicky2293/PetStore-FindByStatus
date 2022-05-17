package com.api.pageObjects;

import com.api.common.PgApiCommon;
import com.api.pojo.FindByStatus;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PgFindByStatus extends PgApiCommon {

	private RequestSpecBuilder request;
	private RequestSpecification reqSpec;
	@SuppressWarnings("rawtypes")
	private ResponseBody body;
	private int count;

	public PgFindByStatus() {
		request = new RequestSpecBuilder();
	}

	public RequestSpecBuilder build(String status) throws Exception {
		System.out.println("Building request to the endpoint.........." + getCompleteUrl());
		System.out.println("Adding the URI.........");
		request.setBaseUri(getBaseUrl());
		request.setBasePath(getResourcePath());
		System.out.println("Adding status query parameters..........");
		request.addParam("status", status);
		return request;
	}

	public RequestSpecBuilder build(String status1, String status2) throws Exception {
		System.out.println("Building request to the endpoint.........." + getCompleteUrl());
		System.out.println("Adding the URI.........");
		request.setBaseUri(getBaseUrl());
		request.setBasePath(getResourcePath());
		System.out.println("Adding status query parameters..........");
		request.addParam("status", status1);
		request.addParam("status", status2);
		return request;
	}

	public Response findByStatus(String status) throws Exception {
		try {
			reqSpec = build(status).build();
			response = RestAssured.given(reqSpec).get();
			System.out.println("Receiving response from the API..........");
			System.out.println(response.asPrettyString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		RestAssured.reset();
		return response;
	}

	public Response findByStatus(String status1, String status2) throws Exception {
		try {
			reqSpec = build(status1, status2).build();
			response = RestAssured.given(reqSpec).get();
			System.out.println("Receiving response from the API..........");
			System.out.println(response.asPrettyString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		RestAssured.reset();
		return response;
	}

	public void verifyPetNameUsingPojo(String petName) {
		try {
			body = response.getBody();
			FindByStatus[] findByStatus = body.as(FindByStatus[].class);
			for (FindByStatus find : findByStatus) {
				String pet = find.getCategory().getName();
				if (pet.contains(petName)) {
					count++;
				}
			}
			System.out.println("Using JSON Deserialisation :: Number of pets as " + petName + " are: " + count);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

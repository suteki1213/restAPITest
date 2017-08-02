package com.util;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;

@Service
public class BaseRestService
{

	public Response getWarehouseById(final String id, final Map<String, Object> fields)
	{
		return getDefaultRestCall("/warehousingwebservices/warehouses/" + id + "/", ContentType.JSON, fields);
	}

	public Response getStockAdjustmentReasons(final Map<String, Object> fields)
	{
		return getDefaultRestCall("/warehousingwebservices/stocklevels/adjustment-reasons/", ContentType.JSON, fields);
	}

	public Response getStockLevelByWarehouse(final String code, final Map<String, Object> fields)
	{
		return getDefaultRestCall("/warehousingwebservices/stocklevels/warehouses/" + code + "/", ContentType.JSON, fields);
	}

	public Response postStockLevel(final Map<String, Object> fields, JSONObject body )
	{
		return postDefaultRestCall("/warehousingwebservices/stocklevels/", ContentType.JSON, fields, body);
	}

	/**
	 * Builds a GET rest call.
	 *
	 * @param path
	 * @param fields
	 * @param contentType
	 * @return response
	 */
	protected Response getDefaultRestCall(final String path, final ContentType contentType, final Map<String, Object> fields)
	{
		return given().contentType(contentType).queryParams(fields).log().all().when().get(path).then().log()
				.all().statusCode(200).contentType(contentType).
				extract().response();
	}

	/**
	 * Builds a POST rest call.
	 *
	 * @param path
	 * @param fields
	 * @param contentType
	 * @return response
	 */
	protected <T> Response postDefaultRestCall(final String path, final ContentType contentType, final Map<String, Object> fields,
			final T requestBody)
	{
		return given().contentType(contentType).queryParams(fields).body(requestBody).log().all().when().post(path).then().log()
				.all().statusCode(201).contentType(contentType).
				extract().response();
	}




}

package com.util.obj;

import javax.annotation.Resource;

import java.util.HashMap;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import com.util.BaseRestService;
import com.util.builder.StockLevelBuilder;

@Component
public class StockLevels extends AbstractItems<Response>
{
	@Resource
	private BaseRestService baseRestService;


	public Response defaultStockLevel()
	{
		return getFromCollectionOrSaveAndReturn(
				() -> baseRestService.getStockLevelByWarehouse("Nakano", new HashMap<>()).jsonPath().getJsonObject("stockLevels"),
				() -> baseRestService.postStockLevel(new HashMap<>(),StockLevelBuilder.aObj().withAvailable(12).withProduct("1934793").withWarehosues("Nakano").build()));

	}
}

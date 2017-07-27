import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Before;
import org.junit.Test;
import util.BaseIntegrationTest;
import util.obj.StockLevels;

import static io.restassured.RestAssured.port;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class ControllerRestService extends BaseIntegrationTest
{
	@Resource
	protected StockLevels stockLevels;

	@Before
	public void setup()
	{
		RestAssured.baseURI = System.getProperty("baseUrl");
		port =  Integer.parseInt(System.getProperty("basePort"));
		RestAssured.useRelaxedHTTPSValidation();
	}

	@Test
	public void getWarehouseById()
	{
		//When
		JsonPath response = getWarehouseById("Nakano", new HashMap<>()).jsonPath();

		//Then
		response.get("pointsOfServices[0].address.country.name").equals("Japan");
	}

	@Test
	public void getAllStockAdjustmentReasons()
	{
		//When
		List response = getStockAdjustmentReasons(new HashMap<>()).jsonPath().get("reasons");

		//Then
		assertTrue(response.stream().anyMatch( e -> e. equals("WASTAGE")));
		assertEquals(3, response.size());
	}

	@Test
	public void createStockLevel()
	{
		stockLevels.defaultStockLevel();
	}
}

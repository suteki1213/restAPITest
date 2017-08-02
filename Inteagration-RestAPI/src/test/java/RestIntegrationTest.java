import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;

import com.util.BaseRestService;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Before;
import org.junit.Test;
import com.util.obj.StockLevels;

import static io.restassured.RestAssured.port;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class RestIntegrationTest extends BaseContextConfiguration
{
	@Resource
	protected StockLevels stockLevels;
	@Resource
	protected BaseRestService baseRestService;

	@Before
	public void setup()
	{
		RestAssured.baseURI = baseUrl;
		port = Integer.parseInt(basePort);
		RestAssured.useRelaxedHTTPSValidation();
	}

	@Test
	public void getWarehouseById()
	{
		//When
		JsonPath response = baseRestService.getWarehouseById("Nakano", new HashMap<>()).jsonPath();

		//Then
		response.get("pointsOfServices[0].address.country.name").equals("Japan");
	}

	@Test
	public void getAllStockAdjustmentReasons()
	{
		//When
		List response = baseRestService.getStockAdjustmentReasons(new HashMap<>()).jsonPath().get("reasons");

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

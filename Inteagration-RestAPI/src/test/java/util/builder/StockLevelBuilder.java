package util.builder;



import org.json.simple.JSONObject;


public class StockLevelBuilder
{
	private final JSONObject obj;

	private StockLevelBuilder()
	{
		obj = new JSONObject();
	}

	private JSONObject getObj()
	{
		return this.obj;
	}

	public static StockLevelBuilder aObj()
	{
		return new StockLevelBuilder();
	}

	public JSONObject build()
	{
		return getObj();
	}

	public StockLevelBuilder withAvailable(final int available)
	{
		getObj().put("initialQuantityOnHand", available);
		return this;
	}

	public StockLevelBuilder withProduct(final String code)
	{
		getObj().put("productCode", code);
		return this;
	}

	public StockLevelBuilder withWarehosues(final String code)
	{
		final JSONObject warehouse = new JSONObject();
		warehouse.put("code", code);
		getObj().put("warehouse", warehouse);
		return this;
	}
}

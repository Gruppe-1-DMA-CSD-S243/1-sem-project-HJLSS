package model.Tool;


public class Tool {

	private String id;
	private String barcode;
	private String toolNo;
	private String name;
	private String manufacturerName;
	private String manufacturerID;
	private String model;
	private String description;
	private double costPrice;
	private double msrp;
	private int stockKeepingUnit;
	
	public Tool(String id, String barcode, String toolNo, String name, String manufacturerName, String manufacturerID,
			String model, String description, double costPrice, double msrp, int stockKeepingUnit) {
		
		this.id = id;
		this.barcode = barcode;
		this.toolNo = toolNo;
		this.name = name;
		this.manufacturerName = manufacturerName;
		this.manufacturerID = manufacturerID;
		this.model = model;
		this.description = description;
		this.costPrice = costPrice;
		this.msrp = msrp;
		this.stockKeepingUnit = stockKeepingUnit;
	}

	public String getId() {
		return id;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getToolNo() {
		return toolNo;
	}

	public String getName() {
		return name;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public String getManufacturerID() {
		return manufacturerID;
	}

	public String getModel() {
		return model;
	}

	public String getDescription() {
		return description;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public double getMsrp() {
		return msrp;
	}

	public int getStockKeepingUnit() {
		return stockKeepingUnit;
	}	
	
	
}

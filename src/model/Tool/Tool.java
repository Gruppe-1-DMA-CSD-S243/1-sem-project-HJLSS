package model.Tool;

public class Tool {
	private String id;
	private String barcode;
	private String productNo;
	private String name;
	private String manufacturerId;
	private String manufacturerName;
	private String model;
	private String description;
	private double costPrice;
	private double msrp;
	private int stockKeepingUnit;
	
	public Tool(String id, String barcode, String productNo, String name, String manufacturerId,
			String manufacturerName, String model, String description, double costPrice, double msrp,
			int stockKeepingUnit) {
		this.id = id;
		this.barcode = barcode;
		this.productNo = productNo;
		this.name = name;
		this.manufacturerId = manufacturerId;
		this.manufacturerName = manufacturerName;
		this.model = model;
		this.description = description;
		this.costPrice = costPrice;
		this.msrp = msrp;
		this.stockKeepingUnit = stockKeepingUnit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public int getStockKeepingUnit() {
		return stockKeepingUnit;
	}

	public void setStockKeepingUnit(int stockKeepingUnit) {
		this.stockKeepingUnit = stockKeepingUnit;
	}
	
	
	
	

}

package model.Product;

public abstract class Product {

	protected String barcode;
	protected String productNo;
	protected ProductCategory category;
	protected String name;
	protected String manufacturerName;
	protected String manufacturerID;
	protected String model;
	protected String description;
	protected double price;
	protected double costPrice;
	protected double msrp;
	protected int stockKeepingUnit;
	
	protected Product(String barcode, String productNo, ProductCategory category, 
					String name, String manufacturerName, String manufacturerID, String model, 
					String description, double price, double costPrice, double msrp,
					int stockKeepingUnit) {
		
		this.barcode = barcode;
		this.productNo = productNo;
		this.category = category;
		this.name = name;
		this.manufacturerName = manufacturerName;
		this.manufacturerID = manufacturerID;
		this.model = model;
		this.description = description;
		this.price = price;
		this.costPrice = costPrice;
		this.msrp = msrp;
		this.stockKeepingUnit = stockKeepingUnit;
	}
	
	public String getBarcode() {
		return barcode;
	}

	public double getPrice() {
		return price;
	}
	
	public ProductCategory getProductCategory() {
		return this.category;
	}

	public String getProductNo() {
		return productNo;
	}

	public ProductCategory getCategory() {
		return category;
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

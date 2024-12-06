package model.Product;

public abstract class Product {

	private String barcode;
	private String productNo;
	private ProductCategory category;
	private String name;
	private String manufacturerName;
	private String manufacturerID;
	private String model;
	private String description;
	private double price;
	private double costPrice;
	private double msrp;
	private int stockKeepingUnit;
	
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
}

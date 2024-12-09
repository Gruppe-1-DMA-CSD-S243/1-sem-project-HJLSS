package model.Product;

public class AdvancedProduct extends Product {

	private Item item;
	
	public AdvancedProduct(String barcode, String productNo, ProductCategory category, 
			String name, String manufacturerName, String manufacturerID, String model, 
			String description, double price, double costPrice, double msrp,
			int stockKeepingUnit) {
		
		super(barcode, productNo, category, name, manufacturerName, manufacturerID, model,
				description, price, costPrice, msrp, stockKeepingUnit);
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
	
	
}

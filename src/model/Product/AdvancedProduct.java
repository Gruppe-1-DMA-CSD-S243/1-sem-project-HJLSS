package model.Product;

/**
 * Superclass of product
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 */
public class AdvancedProduct extends Product {

	private Item item;
	
	/**
	 * Calls the constructor in the superclass with provided parameters
	 * @param barcode
	 * @param productNo
	 * @param category
	 * @param name
	 * @param manufacturerName
	 * @param manufacturerID
	 * @param model
	 * @param description
	 * @param price
	 * @param costPrice
	 * @param msrp
	 * @param stockKeepingUnit
	 */
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

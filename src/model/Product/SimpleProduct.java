package model.Product;

/**
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 */
public class SimpleProduct extends Product {

	
	public SimpleProduct(String barcode, String productNo, ProductCategory category, String name,
			String manufacturerName, String manufacturerID, String model, String description, double price,
			double costPrice, double msrp, int stockKeepingUnit) {
		
		super(barcode, productNo, category, name, manufacturerName, manufacturerID, model, description, price, costPrice, msrp,
				stockKeepingUnit);
		
	}
	
}

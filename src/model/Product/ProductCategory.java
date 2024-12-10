package model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jonas
 */
public class ProductCategory {

	private String productCategoryID;
	private String name;
	private String description;
	private Map<String, Product> products;
	
	public ProductCategory(String productCategoryID, String name, String description) {
		this.productCategoryID = productCategoryID;
		this.name = name;
		this.description = description;
		products = new HashMap<>();
	}
	
	public String getProductCategoryID() {
		return productCategoryID;
	}
	
	/**
	 * Adds a product to the HashMap "products" and sets the barcode on products as key
	 * @param product
	 */
	public void addProductToProductCategory(Product product) {
		String key = product.getBarcode();
		
		products.put(key, product);
	}
}

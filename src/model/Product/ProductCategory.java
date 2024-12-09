package model.Product;

import java.util.HashMap;
import java.util.Map;

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
	
	public void addProductToProductCategory(Product product) {
		String key = product.getBarcode();
		
		products.put(key, product);
	}
}

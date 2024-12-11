package model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 */
public class ProductContainer {

	private static ProductContainer instance;
	private Map<String, Product> products;
	
	private ProductContainer() {
		products = new HashMap<>();
	}
	
	public static ProductContainer getInstance() {
		if(instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}
	
	public Product findProductByBarcode(String barcode) {
		if (products.containsKey(barcode)) {
			return products.get(barcode);
		}
		return null;
	}
	
	/**
	 * Adds "product" to the HashMap "products" and sets the barcode on product as the key
	 * @param product
	 */
	public void addProduct(Product product){
		String key = product.getBarcode();
		
		products.put(key, product);
	}
}

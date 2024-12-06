package model.Product;

import java.util.HashMap;
import java.util.Map;

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
		if(products.get(barcode) instanceof SimpleProduct) {
			return (SimpleProduct)products.get(barcode);
		}
		else {
			return (AdvancedProduct)products.get(barcode);
		}
	}
	
	public void addProduct(Product product){
		String key = product.getBarcode();
		
		products.put(key, product);
	}
}

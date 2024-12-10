package model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jonas
 */
public class ProductCategoryContainer {

	private static ProductCategoryContainer instance;
	private Map<String, ProductCategory> productCategoryContainer;
	
	private ProductCategoryContainer() {
		productCategoryContainer = new HashMap<>();
	}
	
	public static ProductCategoryContainer getInstance() {
		if(instance == null) {
			instance = new ProductCategoryContainer();
		}
		return instance;
	}
	
	/**
	 * Adds productCategory to the ProductCategoryContainer and sets the productCategoryID as the key
	 * @param productCategory
	 */
	public void addProductCategory(ProductCategory productCategory){
		String key = productCategory.getProductCategoryID();
		
		productCategoryContainer.put(key, productCategory);
	}
	
	public ProductCategory findProductCategoryByProductCategoryID(String productCategoryID) {
		ProductCategory foundProductCategory = productCategoryContainer.get(productCategoryID);
		return foundProductCategory;
	}
}

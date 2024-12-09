package controller;

import model.Product.Product;
import model.Product.ProductCategory;
import model.Product.ProductCategoryContainer;
import model.Product.ProductContainer;

public class ProductController {

	public ProductController() {
		
	}
	
	public Product findProductByBarcode(String barcode) {
		return ProductContainer.getInstance().findProductByBarcode(barcode);
	}
	
	public ProductCategory findProductCategoryByProductCategoryID(String productCategoryID) {
		return ProductCategoryContainer.getInstance().findProductCategoryByProductCategoryID(productCategoryID);
	}
}

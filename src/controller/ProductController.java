package controller;

import model.Product.Product;
import model.Product.ProductContainer;

public class ProductController {

	public ProductController() {
		
	}
	
	public Product findProductByBarcode(String barcode) {
		return ProductContainer.getInstance().findProductByBarcode(barcode);
	}
}

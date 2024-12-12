package ui;

import controller.OrderController;
import model.Customer.BusinessCustomer;
import model.Customer.CustomerContainer;
import model.Order.Order;
import model.Order.OrderContainer;
import model.Product.ProductCategory;
import model.Product.ProductCategoryContainer;
import model.Product.ProductContainer;
import model.Product.SimpleProduct;


/**
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 */
public class TryMe {
	
	
	public void createTestData() {
		BusinessCustomer businessCustomer1 = new BusinessCustomer("nameTest", "emailTest", "phoneTest", "addressTest", "cvrTest");
		CustomerContainer.getInstance().addCustomer(businessCustomer1);
		
		BusinessCustomer foundCustomer = CustomerContainer.getInstance().findCustomerByCVR("cvrTest");
		System.out.println(foundCustomer.getCVR());
		
		ProductCategory productCategory1 = new ProductCategory("IDTest", "nameTest", "descriptionTest");
		ProductCategoryContainer.getInstance().addProductCategory(productCategory1);
		
		ProductCategory foundProductCategory = ProductCategoryContainer.getInstance().findProductCategoryByProductCategoryID("IDTest");
		System.out.println(foundProductCategory.getProductCategoryID());
		
		
		SimpleProduct simpleProduct1 = new SimpleProduct("1", "1", productCategory1, "hammer", "Stanley", "123", "1000x", "stærk", 1000.00, 200.00, 500.00, 5);
		SimpleProduct simpleProduct2 = new SimpleProduct("2", "1", productCategory1, "hammer", "Stanley", "123", "1000x", "stærk", 500.00, 200.00, 500.00, 5);
		ProductContainer.getInstance().addProduct(simpleProduct1);
		ProductContainer.getInstance().addProduct(simpleProduct2);
		
		SimpleProduct foundProduct = (SimpleProduct)ProductContainer.getInstance().findProductByBarcode("1");
		System.out.println(foundProduct.getProductCategory().getProductCategoryID());
		
	}
	
	
}

//package controller;
//import model.*;
//import model.Customer.BusinessCustomer;
//import model.Customer.CustomerContainer;
//import model.Order.Order;
//import model.Order.OrderContainer;
//import model.Product.Product;
//import model.Product.ProductCategory;
//import model.Product.ProductCategoryContainer;
//import model.Product.ProductContainer;
//import model.Product.SimpleProduct;
//
//public class MainTest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		
//		
//		BusinessCustomer businessCustomer1 = new BusinessCustomer("nameTest", "emailTest", "phoneTest", "addressTest", "cvrTest");
//		CustomerContainer.getInstance().addCustomer(businessCustomer1);
//		
//		BusinessCustomer foundCustomer = CustomerContainer.getInstance().findCustomerByCVR("cvrTest");
//		System.out.println(foundCustomer.getCVR());
//		
//		ProductCategory productCategory1 = new ProductCategory("IDTest", "nameTest", "descriptionTest");
//		ProductCategoryContainer.getInstance().addProductCategory(productCategory1);
//		
//		ProductCategory foundProductCategory = ProductCategoryContainer.getInstance().findProductCategoryByProductCategoryID("IDTest");
//		System.out.println(foundProductCategory.getProductCategoryID());
//		
//		
//		SimpleProduct simpleProduct1 = new SimpleProduct("1", "1", productCategory1, "hammer", "Stanley", "123", "1000x", "stærk", 1000.00, 200.00, 500.00, 5);
//		SimpleProduct simpleProduct2 = new SimpleProduct("2", "1", productCategory1, "hammer", "Stanley", "123", "1000x", "stærk", 500.00, 200.00, 500.00, 5);
//		ProductContainer.getInstance().addProduct(simpleProduct1);
//		ProductContainer.getInstance().addProduct(simpleProduct2);
//		
//		SimpleProduct foundProduct = (SimpleProduct)ProductContainer.getInstance().findProductByBarcode("1");
//		System.out.println(foundProduct.getProductCategory().getProductCategoryID());
//		
//		
//		OrderController oc = new OrderController();
//		oc.makeNewOrder();
//		oc.addProductToOrder("1", 4);
//		oc.addProductToOrder("2", 1);
//		oc.addCustomerToOrder("cvrTest");
//		oc.makePayment(true);
//		oc.finishOrder();
//		
//		Order testOrder = OrderContainer.getInstance().getOrders().get("1");
//		
//		try {
//			System.out.println(testOrder.getOrderNo());
//			System.out.println(testOrder.getTimeOfPurchase());
//			System.out.println(testOrder.getCustomer().getCVR());
//			System.out.println(testOrder.getCustomer().getName());
//			System.out.println(testOrder.getPrice());
//		}
//		catch (Exception e) {
//			
//		}
//		
//		
//	}
//	
//}

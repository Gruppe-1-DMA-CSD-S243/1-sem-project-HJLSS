package controller;

import model.Customer.Customer;
import model.Order.Order;
import model.Product.Product;

public class OrderController {
	
	private ProductController productController;
	private CustomerController customerController;
	private Order order;
	
	public OrderController() {
		
	}
	
	public Order makeNewOrder() {
		return null;
	}
	
	public Product findProductByBarcode(String barcode) {
		return null;
	}
	
	public Customer findCustomerByCVR(String cvr) {
		return null;
	}
	
	public void addProductToOrder(String barcode, int quantity) {
		
	}
	
	public void addCustomerToOrder(String cvr) {
		
	}
	
	public void makePayment(boolean paid) {
		
	}
	
	public void finishOrder() {
		
	}

}

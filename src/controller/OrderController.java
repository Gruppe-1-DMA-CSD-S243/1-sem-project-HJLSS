package controller;

import model.Customer.BusinessCustomer;
import model.Customer.Customer;
import model.Order.Order;
import model.Order.OrderContainer;
import model.Product.Product;

public class OrderController {
	
	private ProductController productController;
	private CustomerController customerController;
	private Order order;
	
	public OrderController() {
		this.productController = new ProductController();
		this.customerController = new CustomerController();
	}
	
	public void makeNewOrder() {
		this.order = new Order();
	}
	
	public Product findProductByBarcode(String barcode) {
		return productController.findProductByBarcode(barcode);
	}
	
	public BusinessCustomer findCustomerByCVR(String cvr) {
		return customerController.findCustomerByCVR(cvr);
	}
	
	public void addProductToOrder(String barcode, int quantity) {
		Product product = findProductByBarcode(barcode);
		
		this.order.addOrderLine(product, quantity);
	}
	
	public void addCustomerToOrder(String cvr) {
		BusinessCustomer customer = findCustomerByCVR(cvr);
		
		this.order.setCustomer(customer);
	}
	
	public void makePayment(boolean paid) {
		this.order.setPaid(paid);
	}
	
	public void finishOrder() {
		if (this.order.isPaid() == true) {
			OrderContainer.getInstance().finishOrder(this.order);
			this.order = null;
		}
		
		else {
			System.out.println("Order not paid!");
		}
		
	}

}

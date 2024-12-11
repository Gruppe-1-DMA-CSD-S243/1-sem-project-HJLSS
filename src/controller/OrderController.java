package controller;

import model.Customer.BusinessCustomer;
import model.Customer.Customer;
import model.Order.Order;
import model.Order.OrderContainer;
import model.Product.Product;

/**
 * Ordercontroller which is the main access point from the UI class <br>
 * which means that when an order needs to be made it is this class which sends the information down to the other layers <br>
 * and asks for product and customer for the order and then adds them to the order and orderline.
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 */
public class OrderController {
	
	private ProductController productController;
	private CustomerController customerController;
	private Order order;
	
	public OrderController() {
		this.productController = new ProductController();
		this.customerController = new CustomerController();
		makeNewOrder();
	}
	
	public void makeNewOrder() {
		this.order = new Order();
	}
	
	/**
	 * Finds a product from the barcode by "asking" the product controller to find it.
	 * @param barcode
	 * @return product
	 */
	public Product findProductByBarcode(String barcode) {
		return productController.findProductByBarcode(barcode);
	}
	
	/**
	 * Finds a product from the barcode by "asking" the custom controller to find it.
	 * @param cvr
	 * @return customer
	 */
	public BusinessCustomer findCustomerByCVR(String cvr) {
		return customerController.findCustomerByCVR(cvr);
	}
	
	/**
	 * Adds the found product to the orderline by adding it through the order which creates a new orderline <br>
	 * @param barcode
	 * @param quantity
	 */
	public void addProductToOrder(String barcode, int quantity) {
		Product product = findProductByBarcode(barcode);
		
		this.order.addOrderLine(product, quantity);
	}
	
	/**
	 * Adds the found customer to the order by accessing the order class <br>
	 * @param cvr
	 */
	public void addCustomerToOrder(String cvr) {
		BusinessCustomer customer = findCustomerByCVR(cvr);
		
		this.order.setCustomer(customer);
	}
	
	public void makePayment(boolean paid) {
		this.order.setPaid(paid);
	}
	
	/**
	 * If the amount paid isnt the same the or over the amount of the price then the order isnt paid.
	 */
	public void finishOrder() {
		if (this.order.isPaid() == true) {
			OrderContainer.getInstance().finishOrder(this.order);
			this.order.printReceipt();
			this.order = null;
		}
		
		else {
			System.out.println("Order not paid!");
		}
		
	}

	public Order getOrder() {
		return order;
	}
	
	

}

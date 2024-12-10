package model.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Customer.BusinessCustomer;
import model.Customer.Customer;
import model.Customer.CustomerContainer;
import model.Product.Product;

/**
 * Order which contains orderlines.
 * Order have the parameter to hold order numbers, time of purchase, price and which customer there is on the order.
 * And if the order is paid or not
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 */
public class Order {

	private String orderNo;
	private String timeOfPurchase;
	private double price;
	private boolean paid;
	private BusinessCustomer customer;
	private ArrayList<OrderLine> orderLines;
	
	private static int count = 1;
	

	/**
	 * Order constructor which counts the orderNo up one each time an order is made.
	 * The order number starts at 1 and then the next order number is 2. <br>
	 * The time of purchase is set by using the java package time.
	 */
	public Order() {
		this.orderNo = "" + count;
		count++;
		
		LocalDateTime localDate = LocalDateTime.now();
		DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss");
		
		String timeOfPurchase = localDate.format(formattedDate);
		
		this.timeOfPurchase = timeOfPurchase;
		this.paid = false;
		
		this.orderLines = new ArrayList<>();
	}
	
	/**
	 * Adds the customer to the order
	 * @param customer
	 */
	public void setCustomer(BusinessCustomer customer) {
		this.customer = customer;
	}
	
	/**
	 * Creates a new orderline <br>
	 * Adds the orderline to the order with Product and quantity <br>
	 * Calls the setter for subtotal which calculates the price for the product. <br>
	 * Calls the setPrice method which sums up all the subtotals <br>
	 * Adds the orderline into orderlines which is the collection of orderlines
	 * @param product
	 * @param quantity
	 */
	public void addOrderLine(Product product, int quantity) {
		OrderLine newOrderLine = new OrderLine(quantity);
		newOrderLine.addProductToOrderLine(product);
		newOrderLine.setSubTotal();
		
		setPrice(newOrderLine.getSubTotal());
		orderLines.add(newOrderLine);
	}
	
	/**
	 * Prints the receipt for the order. <br>
	 * First all the information about the customer is printed <br>
	 * Then all the orderlines are looped through all lines in the order and prints them
	 */
	public void printReceipt() {
		System.out.println();
		if (this.customer != null) {
			System.out.println("Kunde ");
			System.out.println("Navn: " + this.customer.getName());
			System.out.println("Addresse: " + this.customer.getAddress());
			System.out.println("Email: " + this.customer.getEmail());
			System.out.println("Telefon: " + this.customer.getPhone());
			System.out.println("CVR: " + this.customer.getCVR());
			System.out.println();
		}
		
		for (OrderLine orderLine : orderLines) {
			System.out.println("" + orderLine.getQuantity() + " " + orderLine.getProduct().getName() + " " + orderLine.getProduct().getPrice() + "DKK Subtotal: " + orderLine.getSubTotal());
		}
		System.out.println();
		System.out.println("Total: " + getPrice());
		
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public boolean isPaid() {
		return this.paid;
	}
	
	public String getOrderNo() {
		return this.orderNo;
	}
	
	public void setPrice(double price) {
		this.price += price;
	}

	public double getPrice() {
		return price;
	}

	public BusinessCustomer getCustomer() {
		return customer;
	}
	
	public String getTimeOfPurchase() {
		return this.timeOfPurchase;
	}

	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	//used for JUnitTest
	public OrderLine getOrderLineByProductBarcode(String testBarcode) {
		OrderLine returnOrderLine = null;
		for(OrderLine orderLine : orderLines) {
			if(orderLine.getProduct().getBarcode().equals(testBarcode)) {
				returnOrderLine = orderLine;
			}
		}
		return returnOrderLine;
	}
	

}

package model.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Customer.BusinessCustomer;
import model.Customer.Customer;
import model.Customer.CustomerContainer;
import model.Product.Product;

public class Order {

	private String orderNo;
	private String timeOfPurchase;
	private double price;
	private boolean paid;
	private BusinessCustomer customer;
	private ArrayList<OrderLine> orderLines;
	
	private static int count = 1;
	
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
	
	public void setCustomer(BusinessCustomer customer) {
		this.customer = customer;
	}
	
	public void addOrderLine(Product product, int quantity) {
		OrderLine newOrderLine = new OrderLine(quantity);
		newOrderLine.addProductToOrderLine(product);
		newOrderLine.setSubTotal();
		
		setPrice(newOrderLine.getSubTotal());
		orderLines.add(newOrderLine);
	}
	
	public void printReceipt() {
//		for (OrderLine orderLine : orderLines) {
//			System.out.println("" + orderLine.getQuantity() + ", " + orderLine.getProduct().getPrice());
//		}
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
	

}

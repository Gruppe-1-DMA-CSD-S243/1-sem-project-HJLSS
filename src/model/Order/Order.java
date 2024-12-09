package model.Order;

import java.util.ArrayList;

import model.Customer.BusinessCustomer;

public class Order {

	private String orderNo;
	private long timeOfPurchase;
	private double price;
	private BusinessCustomer customer;
	private ArrayList<OrderLine> orderLines;
	
	public Order(String orderNo, long timeOfPurchase, double price) {
		this.orderNo = orderNo;
		this.timeOfPurchase = timeOfPurchase;
		this.price = price;
	}
	
	public void setCustomer(BusinessCustomer customer) {
		
	}
	
	public void addOrderLine(OrderLine orderLine) {
		
	}
	
	public void setPaid(boolean paid) {
		
	}

}

package model.Customer;

import java.util.ArrayList;
import model.Order.Order;

public class BusinessCustomer extends Customer {
	private String cvr;
	private ArrayList<Order> orders;


	public BusinessCustomer(String name, String email, String phone, String address, String cvr) {
		super(name, email, phone, address);
		this.cvr=cvr;
	}
	
	public String getCVR() {
		return cvr;
	}
}
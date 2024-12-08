package controller;

import java.util.HashMap;
import model.Customer.Customer;

public class CustomerController {
	private HashMap<String, Customer> businessCustomers;

	public CustomerController() {

	}
	
	public Customer findCustomerByCVR(String cvr) {
		return businessCustomers.get(cvr);
	}
}
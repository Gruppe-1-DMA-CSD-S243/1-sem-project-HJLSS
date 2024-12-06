package model.Customer;

import java.util.HashMap;

public class CustomerContainer {
private static CustomerContainer instance;	
private HashMap<String, Customer> businessCustomers;


private CustomerContainer() {
	businessCustomers = new HashMap<>();
}
public static CustomerContainer getInstance() {
	if(instance == null) {
		instance = new CustomerContainer();
	}
	return instance;
}


public Customer findByCVR(String cvr) {
	/*
	 * for (Customer customer : customers) {
	 * if(currentCustomer.getCVR().equalsIgnoreCase(cvr)) { return customer; } }
	 * return null;
	 */
	Customer foundCustomer = businessCustomers.get(cvr);
		return foundCustomer;
}
}
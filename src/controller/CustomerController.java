package controller;

import java.util.HashMap;

import model.Customer.Customer;

public class CustomerController {
private HashMap<String, Customer> businessCustomers;


public CustomerController() {

}
public Customer findCustomerByCVR(String cvr) {
	/*
	 * for (Customer customer : customers) {
	 * if(currentCustomer.getCVR().equalsIgnoreCase(cvr)) { return customer; } }
	 * return null;
	 */
	Customer foundCustomer = businessCustomers.get(cvr);
		return foundCustomer;
}
}
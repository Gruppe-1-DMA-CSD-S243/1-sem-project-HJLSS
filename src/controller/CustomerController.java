package controller;

import java.util.HashMap;

import model.Customer.BusinessCustomer;
import model.Customer.Customer;
import model.Customer.CustomerContainer;

public class CustomerController {
	

	public CustomerController() {

	}
	
	public BusinessCustomer findCustomerByCVR(String cvr) {
		return CustomerContainer.getInstance().getCustomers().get(cvr);
	}
}
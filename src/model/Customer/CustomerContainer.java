package model.Customer;

import java.util.HashMap;

public class CustomerContainer {
	private static CustomerContainer instance;	
	private HashMap<String, BusinessCustomer> businessCustomers;


	private CustomerContainer() {
		businessCustomers = new HashMap<>();
	}
	
	public static CustomerContainer getInstance() {
		if(instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}

	public BusinessCustomer findCustomerByCVR(String cvr) {
		BusinessCustomer foundCustomer = businessCustomers.get(cvr);
		return foundCustomer;
	}
	
	public void addCustomer(BusinessCustomer customerToAdd) {
		String key = customerToAdd.getCVR();
		businessCustomers.put(key, customerToAdd);
	}
	
	public HashMap<String, BusinessCustomer> getCustomers(){
		return this.businessCustomers;
	}
}
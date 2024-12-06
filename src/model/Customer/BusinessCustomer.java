package model.Customer;

import java.util.ArrayList;

public class BusinessCustomer extends Customer {
private String cvr;
private ArrayList<Order> orders;


protected BusinessCustomer(String name, String email, String phone, String address, String cvr) {
	super(name, email, phone, address);
	this.cvr=cvr;
}
protected String getCVR() {
	return cvr;
}
}
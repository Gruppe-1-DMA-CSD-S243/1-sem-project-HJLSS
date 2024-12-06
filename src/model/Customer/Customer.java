package model.Customer;

public abstract class Customer {
private String name;
private String email;
private String phone;
private String address;

protected Customer(String name, String email, String phone, String address) {
	this.name=name;
	this.email=email;
	this.phone=phone;
	this.address=address;
}
}
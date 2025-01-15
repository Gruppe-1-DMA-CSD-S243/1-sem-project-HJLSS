package controller;

import java.util.ArrayList;
import java.util.List;

import model.Customer.CustomerContainer;
import model.Customer.PrivateCustomer;
import model.Lease.Lease;
import model.Lease.LeaseContainer;
import model.Tool.Tool;

public class LeaseController {

	private ToolController toolController;
	private CustomerController customerController;
	private List<Lease> leases;
	private Lease lease;
	
	public LeaseController() {
		this.toolController = new ToolController();
		this.customerController = new CustomerController();
		this.leases = new ArrayList<>();
		makeNewLease();
	}
	
	public void makeNewLease() {
		this.lease = new Lease();
		leases.add(lease);
	}
	
	public List<Lease> getLeases() {
		return this.leases;
	}
	
	public Lease getLease() {
		return this.lease;
	}
	
	public Tool findToolByID(String id) {
		return toolController.findToolByID(id);
	}
	
	public PrivateCustomer findPrivateCustomerByPhone(String phone) {
		return customerController.findPrivateCustomerByPhone(phone);
	}
	
	public void addToolToLease(String id) {
		Tool foundTool = toolController.findToolByID(id);
		
		this.lease.setTool(foundTool);
	}
	
	public void returnTool(String toolID) {
		Lease foundLease = findLeaseByToolID(toolID);
		LeaseContainer.getInstance().getLeases().remove(foundLease);
	}
	
	public void addCustomerToLease(String name, String email, String phone, String address) {
		PrivateCustomer customerToAdd = new PrivateCustomer(name, email, phone, address);
		customerController.addPrivateCustomer(customerToAdd);
		
		this.lease.setCustomer(customerToAdd);
	}
	
	public void addExistingCustomerToLease(String phone) {
		PrivateCustomer customerToAdd = this.customerController.findPrivateCustomerByPhone(phone);
		
		this.lease.setCustomer(customerToAdd);
	}
	
	public Lease findLeaseByPhoneNumber(String phone) {
		return LeaseContainer.getInstance().findLeaseByPhoneNumber(phone);
	}
	
	public Lease findLeaseByToolID(String id) {
		return LeaseContainer.getInstance().findLeaseByToolID(id);
	}
	
	public void finishLease() {
		LeaseContainer.getInstance().finishLease(this.lease);
		this.lease = null;
	}
	
	
}

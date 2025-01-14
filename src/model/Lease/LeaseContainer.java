package model.Lease;

import java.util.ArrayList;

import model.Tool.Tool;

public class LeaseContainer {

	private static LeaseContainer instance;
	private ArrayList<Lease> leases;
	private Lease lease;
	
	private LeaseContainer() {
		this.leases = new ArrayList<>();
	}
	
	public static LeaseContainer getInstance() {
		if(instance == null) {
			instance = new LeaseContainer();
		}
		return instance;
	}
	
	public Lease findLeaseByPhoneNumber(String phoneNumber) {
		for(Lease lease: leases) {
			if(lease.getCustomer().getPhone() == phoneNumber) {
				return lease;
			}
		}
		return null;
	}
	
	public Lease findLeaseByToolID(String id) {
		for(Lease lease: leases) {
			if(lease.getTool().getId() == id) {
				return lease;
			}
		}
		return null;
	}
	
	public void finishLease(Lease lease) {
		leases.add(lease);
	}
}

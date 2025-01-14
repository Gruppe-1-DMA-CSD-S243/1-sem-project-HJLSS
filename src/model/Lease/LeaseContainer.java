package model.Lease;

import java.util.ArrayList;

import model.Tool.Tool;

public class LeaseContainer {

	private static LeaseContainer instance;
	private ArrayList<Lease> leases;
	
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
		int index = 0;
		boolean isFound = false;
		Lease matchingLease = null;
		
		while(index < leases.size() && isFound == false) {
			Lease currentLease = leases.get(index);
			
			String phoneNumberOfLease = currentLease.getCustomer().getPhone();
			
			if(phoneNumberOfLease == phoneNumber) {
				matchingLease = currentLease;
				
				isFound = true;
			}
			
		}
		
		return matchingLease;
	}
	
	public Lease findLeaseByToolID(String id) {
		int index = 0;
		boolean isFound = false;
		Lease matchingLease = null;
		
		while(index < leases.size() && isFound == false) {
			Lease currentLease = leases.get(index);
			
			String toolIdOfLease = currentLease.getTool().getId();
			
			if(toolIdOfLease == id) {
				matchingLease = currentLease;
				
				isFound = true;
			}
		}
		return matchingLease;
	}
	
	public Lease findLeaseByLeaseNo(String leaseNo) {
		int index = 0;
		boolean isFound = false;
		Lease matchingLease = null;
		
		while(index < leases.size() && isFound == false) {
			Lease currentLease = leases.get(index);
			
			String leaseNoOfLease = currentLease.getLeaseNo();
			
			if(leaseNoOfLease == leaseNo) {
				matchingLease = currentLease;
				
				isFound = true;
			}
		}
		return matchingLease;
	}
	
	
	
	public void finishLease(Lease lease) {
		leases.add(lease);
	}
}

package model.Lease;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import model.Customer.Customer;
import model.Order.OrderLine;
import model.Tool.Tool;

public class Lease {
	
	private String leaseNo;
	private String timeOfLease;
	private double price;
	private boolean paid;
	private Customer customer;
	private Tool tool;
	private int leasePeriod;
	private boolean returnOverdue;
	
	private LocalDate futureDate;
	
	private static int count = 1;
	
	public Lease() {
		
		this.leaseNo = "" + count;
		count++;
		
		this.leasePeriod = 7;
		LocalDate localDate = LocalDate.now();
		this.futureDate = localDate.plusDays(leasePeriod);
		DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		String timeOfLeaseFormated = localDate.format(formattedDate);
		
		this.timeOfLease = timeOfLeaseFormated;
		this.paid = false;
	
		this.returnOverdue = false;
		
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void removeCustomerFromOrder() {
		this.customer = null;
	}
	
	public void printReceipt() {
		System.out.println();
		if (this.customer != null) {
			System.out.println("***Kunde***");
			System.out.println("Navn: " + this.customer.getName());
			System.out.println("Addresse: " + this.customer.getAddress());
			System.out.println("Email: " + this.customer.getEmail());
			System.out.println("Telefon: " + this.customer.getPhone());
			System.out.println();
		}
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public boolean isPaid() {
		return this.paid;
	}
	
	public String getLeaseNo() {
		return this.leaseNo;
	}
	
	public void setPrice(double price) {
		this.price += price;
	}

	public double getPrice() {
		return price;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public void setTool(Tool newTool) {
		this.tool = newTool;
	}
	
	public Tool getTool() {
		return tool;
	}
	
	public String getTimeOfLease() {
		return this.timeOfLease;
	}
	
	public boolean isReturnOverdue() {
	    try {
	        
	        LocalDate currentDate = LocalDate.now();

	        if (currentDate.isAfter(futureDate)) {
	            System.out.println("The return is overdue.");
	            returnOverdue = true;
	        } else {
	            System.out.println("The return is not overdue.");
	            returnOverdue = false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return returnOverdue;
	}


	
	
}

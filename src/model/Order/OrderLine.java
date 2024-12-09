package model.Order;

import model.Product.Product;

public class OrderLine {
	
	private Product product;
	private int quantity;
	private double subTotal;
	
	public OrderLine(int quantity) {
		this.quantity = quantity;
	}
	
	public void addProductToOrderLine(Product product) {
		
	}
	
	public void setSubTotal() {
		
	}

}

package model.Order;

import model.Product.Product;
import model.Product.ProductContainer;

public class OrderLine {
	
	private Product product;
	private int quantity;
	private double subTotal;
	
	public OrderLine(int quantity) {
		this.quantity = quantity;
	}
	
	public void addProductToOrderLine(Product product) {
		this.product = product;
	}
	
	public void setSubTotal() {
		this.subTotal = this.product.getPrice() * this.quantity;
	}
	
	public double getSubTotal() {
		return this.subTotal;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public int getQuantity() {
		return this.quantity;
	}

}

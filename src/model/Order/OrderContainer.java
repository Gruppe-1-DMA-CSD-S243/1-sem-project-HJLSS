package model.Order;

import java.util.HashMap;

public class OrderContainer {
	
	private static OrderContainer instance;
	private HashMap<String, Order> orders;

	private OrderContainer() {
		orders = new HashMap<>();
	}
	
	public static OrderContainer getInstance() {
		if(instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	public void finishOrder(Order order) {
		
	}
	
}

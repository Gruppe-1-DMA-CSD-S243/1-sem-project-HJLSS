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
		String key = order.getOrderNo();
		orders.put(key, order);
	}
	
	public HashMap<String, Order> getOrders(){
		return this.orders;
	}
	
}

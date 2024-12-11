package model.Order;

import java.util.HashMap;

/**
 * Ordercontainer which holds the orders in a collection using singleton.
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 */
public class OrderContainer {
	
	private static OrderContainer instance;
	private HashMap<String, Order> orders;

	private OrderContainer() {
		orders = new HashMap<>();
	}
	
	/**
	 * Singleton pattern which makes sure that there can only be one instance of the collection.
	 * @return instance
	 */
	public static OrderContainer getInstance() {
		if(instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	/**
	 * Finishes the order by adding the order number as the key and order as value to a hashmap
	 * @param order
	 */
	public void finishOrder(Order order) {
		String key = order.getOrderNo();
		orders.put(key, order);
	}
	
	public HashMap<String, Order> getOrders(){
		return this.orders;
	}
	
}

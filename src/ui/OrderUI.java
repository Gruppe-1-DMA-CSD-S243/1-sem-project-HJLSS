package ui;

import controller.OrderController;

public class OrderUI {
	
	OrderController orderController;
	
	public OrderUI() {
		orderController = new OrderController();
	}
	
	public void start() {
		boolean running = true;
		while (running) {
			int choice = writeOrderUI();
			if (choice == 1) {
				createOrder();
			}
			if (choice == 2) {
				int quantity = TextInput.inputInt("Indtast Antal");
				String barcode = TextInput.inputString("Scan Stregkode");
				
				orderController.addProductToOrder(barcode, quantity);
				
				System.out.print(orderController.getOrder().getPrice());
			}
			if (choice == 3) {
				
			}
			
			else {
				running = false;
			}
		}
	}
	
	private int writeOrderUI() {
		//Creates a keyboard object to read input
		TextOptions menu = new TextOptions("\n ***** OrderMenu *****", "Tilbage");
		menu.addOption("Opret Ordre");
		menu.addOption("Tilføj Produkt");
		menu.addOption("Tilføj Kunde");
		menu.addOption("Betal Ordre");
		menu.addOption("Afslut Ordre");
		
		//TODO if you need more menu items they have to go here
		int choice = menu.prompt();
		
		return choice;
	}
	
	
	
	
	private void createOrder() {
		
		orderController.makeNewOrder();
		
	}
	
	private void addProductToOrder(int quantity, String barcode) {
		
		orderController.addProductToOrder(barcode, quantity);
		
	}
}

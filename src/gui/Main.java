package gui;

import controller.OrderController;
import gui.MainMenu;
import model.*;
import model.Customer.BusinessCustomer;
import model.Customer.CustomerContainer;
import model.Order.Order;
import model.Order.OrderContainer;
import model.Product.Product;
import model.Product.ProductCategory;
import model.Product.ProductCategoryContainer;
import model.Product.ProductContainer;
import model.Product.SimpleProduct;
import ui.MainTUI;
import ui.TryMe;

public class Main {
	
	private static MainMenu mainMenu;

	public static void main(String[] args) {	
		TryMe tryMe = new TryMe();
		tryMe.createTestData();
		
		mainMenu = new MainMenu();
		mainMenu.setVisible(true);
		
//		MainTUI mainTUI = new MainTUI();
//		mainTUI.start();
	}	
}

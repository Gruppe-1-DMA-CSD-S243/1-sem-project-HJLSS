package ui;


import controller.OrderController;
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

public class MainTest {

	public static void main(String[] args) {	
		TryMe tryMe = new TryMe();
		tryMe.createTestData();
		
		MainTUI mainTUI = new MainTUI();
		mainTUI.start();
	}	
}

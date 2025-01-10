package gui;

import gui.MainMenu;
import ui.TryMe;

public class Main {
	private static MainMenu mainMenu;
	
	public static void main(String[] args) {
		TryMe tryMe = new TryMe();
		tryMe.createTestData();
		
		mainMenu = new MainMenu();
		mainMenu.setVisible(true);
	}

}

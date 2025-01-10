package controller;


import model.Tool.Tool;
import model.Tool.ToolContainer;

public class ToolController {
	
	public ToolController() {
		
	}
	
	public Tool findToolByID(String id) {
		return ToolContainer.getInstance().findToolByID(id);
	}

}

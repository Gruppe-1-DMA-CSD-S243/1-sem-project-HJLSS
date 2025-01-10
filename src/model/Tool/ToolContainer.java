package model.Tool;

import java.util.HashMap;
import java.util.Map;

public class ToolContainer {

	private static ToolContainer instance;
	private Map<String, Tool> tools;
	
	public ToolContainer() {
		this.tools = new HashMap<>();
	}
	
	public static ToolContainer getInstance() {
		if (instance == null) {
			instance = new ToolContainer();
		}
		return instance;
		
	}
	
	public Tool findToolByID(String id) {
		if (tools.containsKey(id)) {
			return tools.get(id);
		}
		return null;
	}
	
	public void addTool(Tool tool) {
		String key = tool.getId();
		
		tools.put(key, tool);
	}
}

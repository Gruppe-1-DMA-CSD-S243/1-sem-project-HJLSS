package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Order.Order;
import model.Order.OrderContainer;



public class OrderTableModel extends AbstractTableModel {
	private ArrayList<Order> data = OrderContainer.getInstance();
	private static final String[] COL_NAMES = {"Antal", "Navn", "Pris", "Subtotal"};
	
	public OrderTableModel(ArrayList<Order> data) {
		this.data = data;
		if(this.data == null) {
			this.data = new ArrayList<>();
		}
	}
	
	@Override
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Order o = data.get(rowIndex);
		String returnString = "";
		switch(columnIndex) {
			case 0: 
				returnString = o.getAm();
				break;
			
			case 1: 
				returnString = "" + o.getEmail();
				break;
				
			case 2: 
				returnString = "" + o.getPhone();
				break;
				
			default: returnString = "<UNKNOWN " + columnIndex + ">";
		}
		return returnString;
	}
	
	public Member getDataAt(int rowIndex) {
		return data.get(rowIndex);
	}
	
	public void setData(ArrayList<Member> data) {
		this.data = data;
		super.fireTableDataChanged();

}

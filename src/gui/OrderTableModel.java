package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Order.OrderLine;

public class OrderTableModel extends AbstractTableModel {
	
	private List<OrderLine> orderData;
	
	public OrderTableModel(List<OrderLine> orderData) {
		this.orderData = orderData;
		if(orderData == null) {
			this.orderData = new ArrayList<>();
		}
	}
	
	private static final String[] COL_NAMES = {
			"Antal", "Navn", "Pris", "Subtotal"};
	
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}
	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return orderData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		OrderLine o = orderData.get(rowIndex);
		String res = "";
			switch(columnIndex) {
			case 0: res = "" + o.getQuantity();
				break;
			case 1: res = o.getProduct().getName();
				break;
			case 2: res = "" + o.getProduct().getPrice();
				break;
			case 3: res = "" + o.getSubTotal();
				break;
			default: res = "<UNKNOWN " + columnIndex + ">";
			}
		
		return res;
	}
	
	public void setData(List<OrderLine> orderData) {
		this.orderData = orderData;
		super.fireTableDataChanged();
	}
	
	public OrderLine getDataAt(int rowIndex) {
		return orderData.get(rowIndex);
	}

}

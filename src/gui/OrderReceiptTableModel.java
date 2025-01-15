package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Order.OrderLine; 

public class OrderReceiptTableModel extends AbstractTableModel {
	
	private List<OrderLine> orderLines;
	private static final String[] COL_NAMES = {
			"Antal", "Produkt", "Pris", "Subtotal"};
	
	public OrderReceiptTableModel(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
		if (this.orderLines == null) {
			this.orderLines = new ArrayList<>();
		}
	}
	
	public int getRowCount() {
		return orderLines.size();
	}

	public String getColumnName(int col) {
		return COL_NAMES[col];
	}
	
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		OrderLine o = orderLines.get(rowIndex);
		String res = "";
		
		switch (columnIndex) {
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
	
	public OrderLine getOrderLineAt(int rowIndex) {
		return orderLines.get(rowIndex);
	}
	
	public void setData(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
		super.fireTableDataChanged();
	}

}

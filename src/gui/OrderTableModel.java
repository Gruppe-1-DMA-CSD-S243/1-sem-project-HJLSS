package gui;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;

import model.Order.OrderLine;

public class OrderTableModel extends AbstractTableModel {

	private List<OrderLine> orderLineData;
	
	LocalDate feeYearDate = LocalDate.now();
	DateTimeFormatter feeDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy");
	String formattedDate = feeYearDate.format(feeDateTimeFormatter);
	int formattedDateInt = Integer.parseInt(formattedDate);

	
	public OrderTableModel(List<OrderLine> orderLineData) {
		this.orderLineData = orderLineData;
		if(this.orderLineData == null) {
			this.orderLineData = new ArrayList<OrderLine>();
		}
	}
	
	private static final String[] COL_NAMES = {
			"Antal", "Navn", "Pris", "Subtotal"
	};
	
	@Override
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}

	@Override
	public int getRowCount() {
		return orderLineData.size();
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OrderLine orderLine = orderLineData.get(rowIndex);
		String res = "";
		switch (columnIndex) {
		case 0: res = "" + orderLine.getQuantity();
		break;
		case 1: res = "" + orderLine.getProduct().getName();
		break;
		case 2: res = "" + orderLine.getProduct().getPrice();
		break;
		case 3: res = "" + orderLine.getSubTotal();
		break;
		
		default:
			res = "<UNKNOWN " + columnIndex + ">";
		}
		
		return res;
	}
	
	
	public void setData(List<OrderLine> orderLineData) {
		this.orderLineData = orderLineData;
		super.fireTableDataChanged();
	}
	
	public OrderLine getDataAt(int rowIndex) {
		return orderLineData.get(rowIndex);
	}
	
	public OrderLine getselectedOrderLine(int rowIndex) {
		
		try
		{
			return orderLineData.get(rowIndex);
			
		} catch (IndexOutOfBoundsException e)
		{
			return null;
		}
		
	}
	
	
}


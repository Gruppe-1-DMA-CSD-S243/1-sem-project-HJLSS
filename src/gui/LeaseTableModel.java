package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Lease.Lease;

public class LeaseTableModel extends AbstractTableModel {
	
	private List<Lease> leases;
	private static final String[] COL_NAMES = {
			"leaseNo", "Kunde", "Redskab", "Deadline"};
	
	public LeaseTableModel(List<Lease> leases) {
		this.leases = leases;
		if (this.leases == null) {
			this.leases = new ArrayList<>();
		}
	}
	
	public int getRowCount() {
		return leases.size();
	}

	public String getColumnName(int col) {
		return COL_NAMES[col];
	}
	
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Lease l = leases.get(rowIndex);
		String res = "";
		
		switch (columnIndex) {
			case 0: res = "" + l.getLeaseNo();
				break;
			case 1: if (l.getCustomer() != null){
				res = "" + l.getCustomer().getName();
			}
			else {
				res = "";
			}
				break;
			case 2: if (l.getTool() != null) {
				res = "" + l.getTool().getName();
			}
			else {
				res = "";
			}
				break;
			case 3: res = "" + l.getFutureDateString();
				break;
			default: res = "<UNKNOWN " + columnIndex + ">";
		}
		return res;
	}
	
	public Lease getLeaseAt(int rowIndex) {
		return leases.get(rowIndex);
	}
	
	public void setData(List<Lease> leases) {
		this.leases = leases;
		super.fireTableDataChanged();
	}

}

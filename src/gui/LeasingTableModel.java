package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Lease.Lease;

public class LeasingTableModel extends AbstractTableModel {
	
	private List<Lease> leases;
	private static final String[] COL_NAMES = {
			"Redskab", "ID", "Afleveringsdato"};
	
	public LeasingTableModel(List<Lease> leases) {
		this.leases = leases;
		if(this.leases == null) {
			this.leases = new ArrayList<>();
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return leases.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COL_NAMES.length;
	}
	
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Lease l = leases.get(rowIndex);
		String res = "";
		
		switch(columnIndex) {
			case 0: res = l.getTool().getName();
				break;
			case 1: res = l.getLeaseNo();
				break;
			case 2: res = l.getTimeOfLease();
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

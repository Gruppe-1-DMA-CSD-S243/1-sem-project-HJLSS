package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Lease.Lease;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class LeaseReceipt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ReturnView returnView;
	private String toolID;
	private final JPanel northPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblLease = new JTable();
	private LeaseReceiptTableModel tblModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaseReceipt frame = new LeaseReceipt(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LeaseReceipt(ReturnView returnView, String toolID) {
		this.returnView = returnView;
		this.toolID = toolID;
		initGUI();
		displayLeases();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		centerPanel.add(scrollPane);
		tblLease.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tblLease);
	}
	
	public void displayLeases() {
		List<Lease> leases = new ArrayList<>();
		leases.add(returnView.getLeaseController().findLeaseByToolID(toolID));
		
		tblModel = new LeaseReceiptTableModel(leases);
		tblLease.setModel(tblModel);
	}

}

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LeaseController;
import model.Lease.Lease;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeasingView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblLeasing;
	private LeasingTableModel tblModel;
	private LeaseController leaseController;
	private JLabel lblTotalPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeasingView frame = new LeasingView();
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
	public LeasingView() {
		this.leaseController = new LeaseController();
		initGUI();
		displayLease();
	}
	

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JLabel lblName = new JLabel("Leasing");
		northPanel.add(lblName);
		
		JPanel southPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		JButton btnCreate = new JButton("Opret Leasing");
		southPanel.add(btnCreate);
		
		JButton btnCancel = new JButton("Annuller");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeasingMenu(); 
			}
		});
		southPanel.add(btnCancel);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerSouthPanel = new JPanel();
		centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);
		centerSouthPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerSouthWestPanel = new JPanel();
		centerSouthPanel.add(centerSouthWestPanel, BorderLayout.WEST);
		
		JLabel lblCustomer = new JLabel("Kunde:");
		centerSouthWestPanel.add(lblCustomer);
		
		JLabel lblCustomerName = new JLabel("");
		centerSouthWestPanel.add(lblCustomerName);
		
		JPanel centerSouthEastPanel = new JPanel();
		centerSouthPanel.add(centerSouthEastPanel, BorderLayout.EAST);
		
		JLabel lblTotal = new JLabel("Total:");
		centerSouthEastPanel.add(lblTotal);
		
		lblTotalPrice = new JLabel("");
		centerSouthEastPanel.add(lblTotalPrice);
		
		JPanel centerEastPanel = new JPanel();
		centerPanel.add(centerEastPanel, BorderLayout.EAST);
		GridBagLayout gbl_centerEastPanel = new GridBagLayout();
		gbl_centerEastPanel.columnWidths = new int[]{89, 0};
		gbl_centerEastPanel.rowHeights = new int[]{23, 0, 0, 0, 0};
		gbl_centerEastPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_centerEastPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerEastPanel.setLayout(gbl_centerEastPanel);
		
		JButton btnAddTool = new JButton("Tilføj Redskab");
		btnAddTool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeasingViewTool();
			}
		});
		GridBagConstraints gbc_btnAddTool = new GridBagConstraints();
		gbc_btnAddTool.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddTool.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddTool.anchor = GridBagConstraints.NORTH;
		gbc_btnAddTool.gridx = 0;
		gbc_btnAddTool.gridy = 0;
		centerEastPanel.add(btnAddTool, gbc_btnAddTool);
		
		JButton btnDeleteTool = new JButton("Slet Redskab");
		btnDeleteTool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeToolFromLease();
			}
		});
		GridBagConstraints gbc_btnDeleteTool = new GridBagConstraints();
		gbc_btnDeleteTool.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeleteTool.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleteTool.gridx = 0;
		gbc_btnDeleteTool.gridy = 1;
		centerEastPanel.add(btnDeleteTool, gbc_btnDeleteTool);
		
		JButton btnAddCustomer = new JButton("Tilføj Kunde");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeasingViewCustomer();
			}
		});
		GridBagConstraints gbc_btnAddCustomer = new GridBagConstraints();
		gbc_btnAddCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddCustomer.gridx = 0;
		gbc_btnAddCustomer.gridy = 2;
		centerEastPanel.add(btnAddCustomer, gbc_btnAddCustomer);
		
		JButton btnMakePayment = new JButton("Betal Lease");
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeasingViewPayment();
			}
		});
		GridBagConstraints gbc_btnMakePayment = new GridBagConstraints();
		gbc_btnMakePayment.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMakePayment.gridx = 0;
		gbc_btnMakePayment.gridy = 3;
		centerEastPanel.add(btnMakePayment, gbc_btnMakePayment);
		
		JScrollPane scrollPane = new JScrollPane();
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		
		tblLeasing = new JTable();
		tblLeasing.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblLeasing);
	}

	private void removeToolFromLease() {
		// TODO Auto-generated method stub
		int selectedRow = tblLeasing.getSelectedRow();
		
		if(selectedRow != -1) {
			Lease selectedLease = tblModel.getLeaseAt(selectedRow);
			
			
		}
	}

	private void launchLeasingMenu() {
		// TODO Auto-generated method stub
		LeasingMenu leasingMenu = new LeasingMenu();
		leasingMenu.setVisible(true);
		
		hideFrame();
	}

	private void launchLeasingViewPayment() {
		// TODO Auto-generated method stub
		LeasingViewPayment leasingViewPayment = new LeasingViewPayment();
		leasingViewPayment.setVisible(true);
		
		hideFrame();
	}

	private void launchLeasingViewCustomer() {
		// TODO Auto-generated method stub
		LeasingViewCustomer leasingViewCustomer = new LeasingViewCustomer();
		leasingViewCustomer.setVisible(true);
		
		hideFrame();
	}

	private void launchLeasingViewTool() {
		// TODO Auto-generated method stub
		LeasingViewTool leasingViewTool = new LeasingViewTool(null);
		leasingViewTool.setVisible(true);
		
		hideFrame();
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}
	
	private void displayLease() {
		// TODO Auto-generated method stub
		tblModel = new LeasingTableModel(leaseController.getLeases());
		tblLeasing.setModel(tblModel);
	}
	
	public LeaseController getLeaseController() {
		return leaseController;
	}

	public void updateLeases() {
		// TODO Auto-generated method stub
		tblModel.setData(this.leaseController.getLeases());
	}
	
	JLabel getTotalPrice() {
		return this.lblTotalPrice;
	}
	

}

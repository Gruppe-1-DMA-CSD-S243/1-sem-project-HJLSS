package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LeaseController;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class LeaseView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LeaseController leaseController;
	private final JPanel southPanel = new JPanel();
	private final JPanel northPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JButton btnCancel = new JButton("Annuller");
	private final JLabel lblLease = new JLabel("Lease");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblLease = new JTable();
	private LeaseTableModel tblModel;
	private final JPanel centerEastPanel = new JPanel();
	private final JButton btnAddTool = new JButton("Tilføj Værktøj");
	private final JButton btnAddCustomer = new JButton("Tilføj Kunde");
	private final JButton btnFinishLease = new JButton("Bekræft lease");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaseView frame = new LeaseView();
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
	public LeaseView() {
		this.leaseController = new LeaseController();
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
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnToLeasingMenu();
			}
		});
		btnFinishLease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishLease();
			}
		});
		
		southPanel.add(btnFinishLease);
		
		southPanel.add(btnCancel);
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		northPanel.add(lblLease);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		centerPanel.add(scrollPane);
		tblLease.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tblLease);
		
		centerPanel.add(centerEastPanel, BorderLayout.EAST);
		GridBagLayout gbl_centerEastPanel = new GridBagLayout();
		gbl_centerEastPanel.columnWidths = new int[]{0, 0};
		gbl_centerEastPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_centerEastPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_centerEastPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerEastPanel.setLayout(gbl_centerEastPanel);
		
		GridBagConstraints gbc_btnAddTool = new GridBagConstraints();
		gbc_btnAddTool.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddTool.anchor = GridBagConstraints.NORTH;
		gbc_btnAddTool.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddTool.gridx = 0;
		gbc_btnAddTool.gridy = 0;
		btnAddTool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeaseViewTool();
			}
		});
		centerEastPanel.add(btnAddTool, gbc_btnAddTool);
		
		GridBagConstraints gbc_btnAddCustomer = new GridBagConstraints();
		gbc_btnAddCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddCustomer.anchor = GridBagConstraints.NORTH;
		gbc_btnAddCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddCustomer.gridx = 0;
		gbc_btnAddCustomer.gridy = 1;
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeaseViewCustomer();
			}
		});
		centerEastPanel.add(btnAddCustomer, gbc_btnAddCustomer);
	}
	
	private void launchLeaseViewTool() {
		LeaseViewTool leaseViewTool = new LeaseViewTool(this);
		leaseViewTool.setVisible(true);
	}
	
	private void launchLeaseViewCustomer() {
		LeaseViewCustomer leaseViewCustomer = new LeaseViewCustomer(this);
		leaseViewCustomer.setVisible(true);
	}
	
	private void finishLease() {
		if (leaseController.getLease().getTool() != null && leaseController.getLease().getCustomer() != null) {
			leaseController.finishLease();
			returnToLeasingMenu();
		}
		
		else if (leaseController.getLease().getTool() == null || leaseController.getLease().getCustomer() == null) {
			System.out.println("Tilføj både værktøj og kunde!");
		}
	}
	
	private void returnToLeasingMenu() {
		LeasingMenu leasingMenu = new LeasingMenu();
		leasingMenu.setVisible(true);
		hideFrame();
	}
	
	void updateLeases() {
		tblModel.setData(this.leaseController.getLeases());
	}
	
	public void displayLeases() {
		tblModel = new LeaseTableModel(leaseController.getLeases());
		tblLease.setModel(tblModel);
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}
	
	LeaseController getLeaseController() {
		return this.leaseController;
	}
	
	JButton getCustomerButton() {
		return this.btnAddCustomer;
	}

}

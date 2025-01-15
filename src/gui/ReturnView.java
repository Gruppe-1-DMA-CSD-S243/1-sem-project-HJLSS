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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class ReturnView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LeaseController leaseController;
	private final JPanel northPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JButton btnCancel = new JButton("Tilbage");
	private final JPanel centerPanel = new JPanel();
	private final JLabel lblToolID = new JLabel("Indtast ID:");
	private final JTextField textFieldToolID = new JTextField();
	private final JButton btnReturn = new JButton("Returnér");
	private final JLabel lblError = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnView frame = new ReturnView();
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
	public ReturnView() {
		textFieldToolID.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnToLeasingMenu();
			}
		});
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnTool();
			}
		});
		
		southPanel.add(btnReturn);
		
		southPanel.add(btnCancel);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[]{67, 48, 0, 0};
		gbl_centerPanel.rowHeights = new int[]{14, 0, 0};
		gbl_centerPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		centerPanel.setLayout(gbl_centerPanel);
		
		GridBagConstraints gbc_lblToolID = new GridBagConstraints();
		gbc_lblToolID.anchor = GridBagConstraints.EAST;
		gbc_lblToolID.insets = new Insets(0, 0, 0, 5);
		gbc_lblToolID.gridx = 0;
		gbc_lblToolID.gridy = 1;
		centerPanel.add(lblToolID, gbc_lblToolID);
		
		GridBagConstraints gbc_textFieldToolID = new GridBagConstraints();
		gbc_textFieldToolID.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldToolID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldToolID.gridx = 1;
		gbc_textFieldToolID.gridy = 1;
		centerPanel.add(textFieldToolID, gbc_textFieldToolID);
		
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridx = 2;
		gbc_lblError.gridy = 1;
		centerPanel.add(lblError, gbc_lblError);
	}
	
	private void returnTool() {
		String toolID = textFieldToolID.getText();
		
		this.leaseController = new LeaseController(toolID);
		
		if (leaseController.findLeaseByToolID(toolID) != null) {
			LeaseReceipt leaseReceipt = new LeaseReceipt(this, toolID);
			leaseReceipt.setVisible(true);
			
			leaseController.returnTool(toolID);
			returnToLeasingMenu();
		}
		
		else {
			lblError.setText("Ugyldigt ID!");
			System.out.println("Ugyldigt ID!");
		}
	}
	
	private void returnToLeasingMenu() {
		LeasingMenu leasingMenu = new LeasingMenu();
		leasingMenu.setVisible(true);
		hideFrame();
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}
	
	LeaseController getLeaseController() {
		return this.leaseController;
	}

}

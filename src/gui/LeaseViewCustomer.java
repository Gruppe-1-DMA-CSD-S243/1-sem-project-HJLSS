package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeaseViewCustomer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LeaseView leaseView;
	private final JPanel northPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JButton btnAddExistingCustomer = new JButton("Tilføj eksisterende kunde");
	private final JButton btnAddNewCustomer = new JButton("Opret ny kunde");
	private final JPanel southPanel = new JPanel();
	private final JButton btnCancel = new JButton("Annuller");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaseViewCustomer frame = new LeaseViewCustomer(null);
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
	public LeaseViewCustomer(LeaseView leaseView) {
		this.leaseView = leaseView;
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
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[]{190, 48, 0};
		gbl_centerPanel.rowHeights = new int[]{14, 0, 0, 0};
		gbl_centerPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerPanel.setLayout(gbl_centerPanel);
		
		GridBagConstraints gbc_btnAddExistingCustomer = new GridBagConstraints();
		gbc_btnAddExistingCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddExistingCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddExistingCustomer.gridx = 0;
		gbc_btnAddExistingCustomer.gridy = 1;
		btnAddExistingCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeaseViewExistingCustomer();
			}
		});
		centerPanel.add(btnAddExistingCustomer, gbc_btnAddExistingCustomer);
		
		GridBagConstraints gbc_btnAddNewCustomer = new GridBagConstraints();
		gbc_btnAddNewCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddNewCustomer.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddNewCustomer.gridx = 0;
		gbc_btnAddNewCustomer.gridy = 2;
		btnAddNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeaseViewNewCustomer();
			}
		});
		centerPanel.add(btnAddNewCustomer, gbc_btnAddNewCustomer);
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideFrame();
			}
		});
		
		southPanel.add(btnCancel);
	}
	
	private void launchLeaseViewExistingCustomer() {
		LeaseViewExistingCustomer leaseViewExistingCustomer = new LeaseViewExistingCustomer(this.leaseView);
		leaseViewExistingCustomer.setVisible(true);
		hideFrame();
	}
	
	private void launchLeaseViewNewCustomer() {
		LeaseViewNewCustomer leaseViewNewCustomer = new LeaseViewNewCustomer(this.leaseView);
		leaseViewNewCustomer.setVisible(true);
		hideFrame();
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}

}

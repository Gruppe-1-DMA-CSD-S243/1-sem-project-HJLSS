package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customer.PrivateCustomer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class LeaseViewExistingCustomer extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LeaseView leaseView;
	private JTextField textFieldPhoneNo;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LeaseViewExistingCustomer dialog = new LeaseViewExistingCustomer(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LeaseViewExistingCustomer(LeaseView leaseView) {
		this.leaseView = leaseView;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel northPanel = new JPanel();
			contentPanel.add(northPanel, BorderLayout.NORTH);
		}
		{
			JPanel centerPanel = new JPanel();
			contentPanel.add(centerPanel, BorderLayout.CENTER);
			GridBagLayout gbl_centerPanel = new GridBagLayout();
			gbl_centerPanel.columnWidths = new int[]{0, 328, 0, 0};
			gbl_centerPanel.rowHeights = new int[]{0, 0, 0};
			gbl_centerPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			centerPanel.setLayout(gbl_centerPanel);
			{
				JLabel lblPhoneNo = new JLabel("Indtast tlf nr:");
				GridBagConstraints gbc_lblPhoneNo = new GridBagConstraints();
				gbc_lblPhoneNo.insets = new Insets(0, 0, 0, 5);
				gbc_lblPhoneNo.anchor = GridBagConstraints.EAST;
				gbc_lblPhoneNo.gridx = 0;
				gbc_lblPhoneNo.gridy = 1;
				centerPanel.add(lblPhoneNo, gbc_lblPhoneNo);
			}
			{
				textFieldPhoneNo = new JTextField();
				GridBagConstraints gbc_textFieldPhoneNo = new GridBagConstraints();
				gbc_textFieldPhoneNo.insets = new Insets(0, 0, 0, 5);
				gbc_textFieldPhoneNo.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldPhoneNo.gridx = 1;
				gbc_textFieldPhoneNo.gridy = 1;
				centerPanel.add(textFieldPhoneNo, gbc_textFieldPhoneNo);
				textFieldPhoneNo.setColumns(10);
			}
			{
				lblError = new JLabel("");
				GridBagConstraints gbc_lblError = new GridBagConstraints();
				gbc_lblError.gridx = 2;
				gbc_lblError.gridy = 1;
				centerPanel.add(lblError, gbc_lblError);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAdd = new JButton("Tilføj");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addExistingCustomerToLease();
					}
				});
				btnAdd.setActionCommand("btnAdd");
				buttonPane.add(btnAdd);
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				JButton btnCancel = new JButton("Annuller");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						hideFrame();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	
	private void addExistingCustomerToLease() {
		String phoneNo = textFieldPhoneNo.getText();
		
		if (leaseView.getLeaseController().findPrivateCustomerByPhone(phoneNo) != null) {
			leaseView.getLeaseController().addExistingCustomerToLease(phoneNo);
			leaseView.updateLeases();
			leaseView.getCustomerButton().setText("Redigér Kunde");
			
			hideFrame();
		}
		
		else {
			lblError.setText("Ugyldigt Tlf Nr!");
			System.out.println("Ugyldigt Tlf Nr!");
		}
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}

}

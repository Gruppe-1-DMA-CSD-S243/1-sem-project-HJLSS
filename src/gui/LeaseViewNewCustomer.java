package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class LeaseViewNewCustomer extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LeaseView leaseView;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LeaseViewNewCustomer dialog = new LeaseViewNewCustomer(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LeaseViewNewCustomer(LeaseView leaseView) {
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
			gbl_centerPanel.columnWidths = new int[]{0, 0, 0};
			gbl_centerPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_centerPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			centerPanel.setLayout(gbl_centerPanel);
			{
				JLabel lblCustomerName = new JLabel("Navn:");
				GridBagConstraints gbc_lblCustomerName = new GridBagConstraints();
				gbc_lblCustomerName.insets = new Insets(0, 0, 5, 5);
				gbc_lblCustomerName.anchor = GridBagConstraints.WEST;
				gbc_lblCustomerName.gridx = 0;
				gbc_lblCustomerName.gridy = 1;
				centerPanel.add(lblCustomerName, gbc_lblCustomerName);
			}
			{
				textFieldName = new JTextField();
				GridBagConstraints gbc_textFieldName = new GridBagConstraints();
				gbc_textFieldName.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldName.gridx = 1;
				gbc_textFieldName.gridy = 1;
				centerPanel.add(textFieldName, gbc_textFieldName);
				textFieldName.setColumns(10);
			}
			{
				JLabel lblCustomerEmail = new JLabel("Email:");
				GridBagConstraints gbc_lblCustomerEmail = new GridBagConstraints();
				gbc_lblCustomerEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblCustomerEmail.anchor = GridBagConstraints.WEST;
				gbc_lblCustomerEmail.gridx = 0;
				gbc_lblCustomerEmail.gridy = 2;
				centerPanel.add(lblCustomerEmail, gbc_lblCustomerEmail);
			}
			{
				textFieldEmail = new JTextField();
				GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
				gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldEmail.gridx = 1;
				gbc_textFieldEmail.gridy = 2;
				centerPanel.add(textFieldEmail, gbc_textFieldEmail);
				textFieldEmail.setColumns(10);
			}
			{
				JLabel lblCustomerPhone = new JLabel("Tlf:");
				GridBagConstraints gbc_lblCustomerPhone = new GridBagConstraints();
				gbc_lblCustomerPhone.insets = new Insets(0, 0, 5, 5);
				gbc_lblCustomerPhone.anchor = GridBagConstraints.WEST;
				gbc_lblCustomerPhone.gridx = 0;
				gbc_lblCustomerPhone.gridy = 3;
				centerPanel.add(lblCustomerPhone, gbc_lblCustomerPhone);
			}
			{
				textFieldPhone = new JTextField();
				GridBagConstraints gbc_textFieldPhone = new GridBagConstraints();
				gbc_textFieldPhone.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldPhone.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldPhone.gridx = 1;
				gbc_textFieldPhone.gridy = 3;
				centerPanel.add(textFieldPhone, gbc_textFieldPhone);
				textFieldPhone.setColumns(10);
			}
			{
				JLabel lblCustomerAddress = new JLabel("Addresse:");
				GridBagConstraints gbc_lblCustomerAddress = new GridBagConstraints();
				gbc_lblCustomerAddress.insets = new Insets(0, 0, 0, 5);
				gbc_lblCustomerAddress.anchor = GridBagConstraints.WEST;
				gbc_lblCustomerAddress.gridx = 0;
				gbc_lblCustomerAddress.gridy = 4;
				centerPanel.add(lblCustomerAddress, gbc_lblCustomerAddress);
			}
			{
				textFieldAddress = new JTextField();
				GridBagConstraints gbc_textFieldAddress = new GridBagConstraints();
				gbc_textFieldAddress.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldAddress.gridx = 1;
				gbc_textFieldAddress.gridy = 4;
				centerPanel.add(textFieldAddress, gbc_textFieldAddress);
				textFieldAddress.setColumns(10);
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
						addNewCustomerToLease();
					}
				});
				btnAdd.setActionCommand("OK");
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
	
	private void addNewCustomerToLease() {
		String name = textFieldName.getText();
		String email = textFieldEmail.getText();
		String phone = textFieldPhone.getText();
		String address = textFieldPhone.getText();
		
		leaseView.getLeaseController().addCustomerToLease(name, email, phone, address);
		leaseView.updateLeases();
		leaseView.getCustomerButton().setText("Redigér Kunde");
		
		hideFrame();
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}

}

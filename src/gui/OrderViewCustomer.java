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

public class OrderViewCustomer extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private OrderView orderView;
	private JTextField textFieldCVR;
	private JLabel lblError;
	private JButton btnRemoveCustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderViewCustomer dialog = new OrderViewCustomer(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderViewCustomer(OrderView orderView) {
		this.orderView = orderView;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 168, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCVR = new JLabel("CVR: ");
			GridBagConstraints gbc_lblCVR = new GridBagConstraints();
			gbc_lblCVR.anchor = GridBagConstraints.EAST;
			gbc_lblCVR.insets = new Insets(0, 0, 5, 5);
			gbc_lblCVR.gridx = 0;
			gbc_lblCVR.gridy = 0;
			contentPanel.add(lblCVR, gbc_lblCVR);
		}
		{
			textFieldCVR = new JTextField();
			GridBagConstraints gbc_textFieldCVR = new GridBagConstraints();
			gbc_textFieldCVR.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldCVR.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCVR.gridx = 1;
			gbc_textFieldCVR.gridy = 0;
			contentPanel.add(textFieldCVR, gbc_textFieldCVR);
			textFieldCVR.setColumns(10);
		}
		{
			lblError = new JLabel("");
			GridBagConstraints gbc_lblError = new GridBagConstraints();
			gbc_lblError.insets = new Insets(0, 0, 5, 0);
			gbc_lblError.gridx = 2;
			gbc_lblError.gridy = 0;
			contentPanel.add(lblError, gbc_lblError);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAddCustomer = new JButton("Tilføj");
				if (this.orderView.getOrderController().getOrder().getCustomer() != null) {
					btnAddCustomer.setText("Rediger");
				}
				btnAddCustomer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addCustomerToOrder();
					}
				});
				btnAddCustomer.setActionCommand("OK");
				buttonPane.add(btnAddCustomer);
				getRootPane().setDefaultButton(btnAddCustomer);
			}
			{
				JButton btnCancel = new JButton("Annuller");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						hideFrame();
					}
				});
				{
					btnRemoveCustomer = new JButton("Fjern Kunde");
					if (this.orderView.getOrderController().getOrder().getCustomer() == null) {
						btnRemoveCustomer.setVisible(false);
					}
					btnRemoveCustomer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							removeCustomerFromOrder();
						}
					});
					buttonPane.add(btnRemoveCustomer);
				}
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	
	private void addCustomerToOrder() {
		String CVR = textFieldCVR.getText();
		
		try {
			orderView.getOrderController().addCustomerToOrder(CVR);
			
			orderView.getCustomerName().setText(orderView.getOrderController().getOrder().getCustomer().getName());
			orderView.getCustomerButton().setText("Rediger Kunde");
			
			hideFrame();
		}
		catch (Exception e) {
			lblError.setText("Ugyldigt CVR!");
			System.out.println("Ugyldigt CVR!");
		}
	}
	
	private void removeCustomerFromOrder() {
		orderView.getOrderController().removeCustomerFromOrder();
		
		orderView.getCustomerName().setText("");
		orderView.getCustomerButton().setText("Tilføj Kunde");
		
		hideFrame();
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}

}

package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;

public class OrderViewProduct extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldQuantity;
	private JTextField textFieldBarcode;
	private OrderView orderView;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderViewProduct dialog = new OrderViewProduct(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderViewProduct(OrderView orderView) {
		this.orderView = orderView;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 249, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblQuantity = new JLabel("Antal: ");
			GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
			gbc_lblQuantity.anchor = GridBagConstraints.EAST;
			gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
			gbc_lblQuantity.gridx = 0;
			gbc_lblQuantity.gridy = 0;
			contentPanel.add(lblQuantity, gbc_lblQuantity);
		}
		{
			textFieldQuantity = new JTextField();
			GridBagConstraints gbc_textFieldQuantity = new GridBagConstraints();
			gbc_textFieldQuantity.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldQuantity.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldQuantity.gridx = 1;
			gbc_textFieldQuantity.gridy = 0;
			contentPanel.add(textFieldQuantity, gbc_textFieldQuantity);
			textFieldQuantity.setColumns(10);
		}
		{
			JLabel lblBarcode = new JLabel("Stregkode: ");
			GridBagConstraints gbc_lblBarcode = new GridBagConstraints();
			gbc_lblBarcode.anchor = GridBagConstraints.EAST;
			gbc_lblBarcode.insets = new Insets(0, 0, 5, 5);
			gbc_lblBarcode.gridx = 0;
			gbc_lblBarcode.gridy = 1;
			contentPanel.add(lblBarcode, gbc_lblBarcode);
		}
		{
			textFieldBarcode = new JTextField();
			GridBagConstraints gbc_textFieldBarcode = new GridBagConstraints();
			gbc_textFieldBarcode.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldBarcode.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldBarcode.gridx = 1;
			gbc_textFieldBarcode.gridy = 1;
			contentPanel.add(textFieldBarcode, gbc_textFieldBarcode);
			textFieldBarcode.setColumns(10);
		}
		{
			lblError = new JLabel("");
			GridBagConstraints gbc_lblError = new GridBagConstraints();
			gbc_lblError.anchor = GridBagConstraints.WEST;
			gbc_lblError.insets = new Insets(0, 0, 5, 0);
			gbc_lblError.gridx = 2;
			gbc_lblError.gridy = 1;
			contentPanel.add(lblError, gbc_lblError);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addButton = new JButton("Tilføj");
				addButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addProductToOrder();
					}
				});
				addButton.setActionCommand("OK");
				buttonPane.add(addButton);
				getRootPane().setDefaultButton(addButton);
			}
			{
				JButton cancelButton = new JButton("Annuller");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						hideFrame();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void addProductToOrder() {
		String quantity = textFieldQuantity.getText();
		String barcode = textFieldBarcode.getText();
		
		int parsedQuantity = Integer.parseInt(quantity);
		
		try {
			orderView.getOrderController().addProductToOrder(barcode, parsedQuantity);
			orderView.updateOrderLines();
			
			orderView.setVisibilityForRemoveProduct();
			orderView.getTotalPrice().setText("" + orderView.getOrderController().getOrder().getPrice());
			
			hideFrame();
		}
		catch (Exception e) {
			lblError.setText("Ugyldig Stregkode!");
			System.out.println("Ugyldig Stregkode!");
		}
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}

}

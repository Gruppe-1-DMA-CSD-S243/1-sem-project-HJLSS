package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderViewPayment extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldAmountPaid;
	private OrderView orderView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderViewPayment dialog = new OrderViewPayment(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderViewPayment(OrderView orderView) {
		this.orderView = orderView;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel northPanel = new JPanel();
			contentPanel.add(northPanel, BorderLayout.NORTH);
			{
				JLabel lblHeader = new JLabel("Betal for ordren:");
				northPanel.add(lblHeader);
			}
		}
		{
			JPanel centerPanel = new JPanel();
			contentPanel.add(centerPanel, BorderLayout.CENTER);
			GridBagLayout gbl_centerPanel = new GridBagLayout();
			gbl_centerPanel.columnWidths = new int[]{0, 0, 0};
			gbl_centerPanel.rowHeights = new int[]{0, 0, 0, 0};
			gbl_centerPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			centerPanel.setLayout(gbl_centerPanel);
			{
				JLabel lblTotal = new JLabel("Total:");
				GridBagConstraints gbc_lblTotal = new GridBagConstraints();
				gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
				gbc_lblTotal.gridx = 0;
				gbc_lblTotal.gridy = 0;
				centerPanel.add(lblTotal, gbc_lblTotal);
			}
			{
				JLabel lblTotalAmount = new JLabel("" + this.orderView.getOrderController().getOrder().getPrice());
				GridBagConstraints gbc_lblTotalAmount = new GridBagConstraints();
				gbc_lblTotalAmount.anchor = GridBagConstraints.WEST;
				gbc_lblTotalAmount.insets = new Insets(0, 0, 5, 0);
				gbc_lblTotalAmount.gridx = 1;
				gbc_lblTotalAmount.gridy = 0;
				centerPanel.add(lblTotalAmount, gbc_lblTotalAmount);
			}
			{
				JLabel lblPayment = new JLabel("Indtast beløb:");
				GridBagConstraints gbc_lblPayment = new GridBagConstraints();
				gbc_lblPayment.insets = new Insets(0, 0, 0, 5);
				gbc_lblPayment.anchor = GridBagConstraints.EAST;
				gbc_lblPayment.gridx = 0;
				gbc_lblPayment.gridy = 2;
				centerPanel.add(lblPayment, gbc_lblPayment);
			}
			{
				textFieldAmountPaid = new JTextField();
				GridBagConstraints gbc_textFieldAmountPaid = new GridBagConstraints();
				gbc_textFieldAmountPaid.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldAmountPaid.gridx = 1;
				gbc_textFieldAmountPaid.gridy = 2;
				centerPanel.add(textFieldAmountPaid, gbc_textFieldAmountPaid);
				textFieldAmountPaid.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnMakePayment = new JButton("Betal");
				btnMakePayment.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						makePayment();
					}
				});
				btnMakePayment.setActionCommand("OK");
				buttonPane.add(btnMakePayment);
				getRootPane().setDefaultButton(btnMakePayment);
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
	
	private void makePayment() {
		boolean paid = false;
		String amountPaid = textFieldAmountPaid.getText();
		
		double parsedAmountPaid = Double.parseDouble(amountPaid);
		
		if (parsedAmountPaid >= orderView.getOrderController().getOrder().getPrice()) {
			paid = true;
		}
		
		orderView.getOrderController().makePayment(paid);
		
		hideFrame();
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}
	

}

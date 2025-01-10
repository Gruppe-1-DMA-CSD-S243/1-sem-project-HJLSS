package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class ProductToOrder extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfBarcode;
	private JTextField tfQuantity;
	private OrderView orderView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductToOrder dialog = new ProductToOrder(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProductToOrder(OrderView orderView) {
		this.orderView = orderView;
		
		initGUI();
	}
	
	public void initGUI(){
		setAlwaysOnTop(true);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblBarcode = new JLabel("Skriv stregkode:");
			GridBagConstraints gbc_lblBarcode = new GridBagConstraints();
			gbc_lblBarcode.insets = new Insets(0, 0, 5, 0);
			gbc_lblBarcode.gridx = 1;
			gbc_lblBarcode.gridy = 1;
			contentPanel.add(lblBarcode, gbc_lblBarcode);
		}
		{
			tfBarcode = new JTextField();
			tfBarcode.setToolTipText("Indsæt her");
			tfBarcode.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_tfBarcode = new GridBagConstraints();
			gbc_tfBarcode.insets = new Insets(0, 0, 5, 0);
			gbc_tfBarcode.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfBarcode.gridx = 1;
			gbc_tfBarcode.gridy = 2;
			contentPanel.add(tfBarcode, gbc_tfBarcode);
			tfBarcode.setColumns(10);
		}
		{
			JLabel lblQuantity = new JLabel("Skriv antal:");
			GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
			gbc_lblQuantity.insets = new Insets(0, 0, 5, 0);
			gbc_lblQuantity.gridx = 1;
			gbc_lblQuantity.gridy = 3;
			contentPanel.add(lblQuantity, gbc_lblQuantity);
		}
		{
			tfQuantity = new JTextField();
			tfQuantity.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_tfQuantity = new GridBagConstraints();
			gbc_tfQuantity.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfQuantity.gridx = 1;
			gbc_tfQuantity.gridy = 4;
			contentPanel.add(tfQuantity, gbc_tfQuantity);
			tfQuantity.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAdd = new JButton("Add");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						launchAdd();
					}
				});
				btnAdd.setActionCommand("OK");
				buttonPane.add(btnAdd);
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						launchCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void launchAdd() {
		// TODO Auto-generated method stub
		String barcode = tfBarcode.getText();
		String quantity = tfQuantity.getText();
		
		int parseQuantity = Integer.parseInt(quantity);
		
		orderView.getOrderController().addProductToOrder(barcode, parseQuantity);
		orderView.updateOrderLines();
		orderView.getTotalPrice();
		
		
		dispose();
	}

	protected void launchCancel() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		dispose();
	}


}

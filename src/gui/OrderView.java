package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import model.Order.OrderLine;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class OrderView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tblOrder;
	private JTextField tfTotal;
	private OrderTableModel otm;
	private OrderController orderController = new OrderController();
	private JTextField tfCustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderView dialog = new OrderView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Create the dialog.
	 */
	public OrderView() {
		initGUI();
		displayOrderLines();
		getTotalPrice();
		getCustomer();
	}

	private void initGUI() {
		// TODO Auto-generated method stub
		setModal(true);
		setBounds(100, 100, 483, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelNorth = new JPanel();
			contentPanel.add(panelNorth, BorderLayout.NORTH);
			{
				JLabel lblNavn = new JLabel("Velkommen til ordren");
				panelNorth.add(lblNavn);
			}
		}
		{
			JPanel panelCenter = new JPanel();
			contentPanel.add(panelCenter, BorderLayout.CENTER);
			panelCenter.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panelCenter.add(scrollPane, BorderLayout.CENTER);
				{
					tblOrder = new JTable();
					tblOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(tblOrder);
				}
			}
			{
				JPanel panelCenterEast = new JPanel();
				panelCenter.add(panelCenterEast, BorderLayout.EAST);
				GridBagLayout gbl_panelCenterEast = new GridBagLayout();
				gbl_panelCenterEast.columnWidths = new int[]{97, 0};
				gbl_panelCenterEast.rowHeights = new int[]{23, 0, 0, 0, 0};
				gbl_panelCenterEast.columnWeights = new double[]{0.0, Double.MIN_VALUE};
				gbl_panelCenterEast.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panelCenterEast.setLayout(gbl_panelCenterEast);
				{
					JButton btnAddProduct = new JButton("Tilføj produkt");
					btnAddProduct.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							launchAddProduct();
						}
					});
					GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
					gbc_btnAddProduct.fill = GridBagConstraints.HORIZONTAL;
					gbc_btnAddProduct.insets = new Insets(0, 0, 5, 0);
					gbc_btnAddProduct.anchor = GridBagConstraints.NORTH;
					gbc_btnAddProduct.gridx = 0;
					gbc_btnAddProduct.gridy = 0;
					panelCenterEast.add(btnAddProduct, gbc_btnAddProduct);
				}
				{
					JButton btnAddCustomer = new JButton("Tilføj kunde");
					btnAddCustomer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							launchAddCustomer();
						}
					});
					GridBagConstraints gbc_btnAddCustomer = new GridBagConstraints();
					gbc_btnAddCustomer.fill = GridBagConstraints.HORIZONTAL;
					gbc_btnAddCustomer.insets = new Insets(0, 0, 5, 0);
					gbc_btnAddCustomer.gridx = 0;
					gbc_btnAddCustomer.gridy = 1;
					panelCenterEast.add(btnAddCustomer, gbc_btnAddCustomer);
				}
				{
					JButton btnDelete = new JButton("Slet produkt");
					btnDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							launchDelete();
						}
					});
					GridBagConstraints gbc_btnDelete = new GridBagConstraints();
					gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
					gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
					gbc_btnDelete.gridx = 0;
					gbc_btnDelete.gridy = 2;
					panelCenterEast.add(btnDelete, gbc_btnDelete);
				}
				{
					JButton btnPrintReceipt = new JButton("Print kvittering");
					GridBagConstraints gbc_btnPrintReceipt = new GridBagConstraints();
					gbc_btnPrintReceipt.fill = GridBagConstraints.HORIZONTAL;
					gbc_btnPrintReceipt.gridx = 0;
					gbc_btnPrintReceipt.gridy = 3;
					panelCenterEast.add(btnPrintReceipt, gbc_btnPrintReceipt);
				}
			}
		}
		{
			JPanel panelCenterSouth = new JPanel();
			contentPanel.add(panelCenterSouth, BorderLayout.SOUTH);
			panelCenterSouth.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			{
				JLabel lblCustomer = new JLabel("Kunde:");
				panelCenterSouth.add(lblCustomer);
			}
			{
				tfCustomer = new JTextField();
				panelCenterSouth.add(tfCustomer);
				tfCustomer.setColumns(10);
			}
			{
				JLabel lblTotal = new JLabel("Total:");
				panelCenterSouth.add(lblTotal);
			}
			{
				tfTotal = new JTextField();
				tfTotal.setEditable(false);
				panelCenterSouth.add(tfTotal);
				tfTotal.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
	
	private void launchAddCustomer() {
		// TODO Auto-generated method stub
		CustomerToOrder customerToOrder = new CustomerToOrder(this);
		customerToOrder.setVisible(true);
	}



	private void launchDelete() {
		// TODO Auto-generated method stub
		int selectedRow = tblOrder.getSelectedRow();
		
		if(selectedRow != -1) {
			OrderLine selectedOrderLine = otm.getDataAt(selectedRow);
			
			orderController.removeOrderLineFromOrder(selectedOrderLine);
			
			updateOrderLines();
			
			getTotalPrice();
		}
	}



	private void launchAddProduct() {
		// TODO Auto-generated method stub
		ProductToOrder productToOrder = new ProductToOrder(this);
		productToOrder.setVisible(true);
		
		
	}
	
	public void updateOrderLines() {
		otm.setData(this.orderController.getOrder().getOrderLines());
	}



	public void displayOrderLines() {
		List<OrderLine> orderLines = new ArrayList<>();
		otm = new OrderTableModel(orderLines);
		tblOrder.setModel(otm);
	}



	private void launchCancel() {
		// TODO Auto-generated method stub
		OrderMenu orderMenu = new OrderMenu();
		orderMenu.setVisible(true);
		
		setVisible(false);
		dispose();
	}
	
	public OrderController getOrderController() {
		return this.orderController;
	}
	
	public JTextField getTotalPrice() {
		double total = orderController.getOrder().getPrice();
		tfTotal.setText("" + total);
		
		
		return tfTotal;
	}
	
	public JTextField getCustomer() {
		
		return tfCustomer;
	}

}

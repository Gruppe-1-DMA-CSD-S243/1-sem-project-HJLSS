package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import model.Order.Order;
import model.Order.OrderContainer;
import ui.MainTUI;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class OrderView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel northPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JLabel lblNameLabel = new JLabel("Ordre");
	private final JButton btnBackButton = new JButton("Tilbage");
	private final JPanel centerPanel = new JPanel();
	private final JPanel centerSouthPanel = new JPanel();
	private final JLabel lblTotallabel = new JLabel("Total:");
	private final JLabel lblTotalPriceLabel = new JLabel("");
	private final JPanel centerNorthPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblOrder = new JTable();
	private final JPanel centerWestPanel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Streg kode");
	private final JLabel lblNewLabel_1 = new JLabel("Ordrelinjer for kunde:");
	private final JTextField textBarcodeField = new JTextField();
	private final JButton btnNewButton = new JButton("Tilføj Produkt");
	private final JLabel lblNewLabel_2 = new JLabel("Kunde CVR");
	private final JTextField textField_1 = new JTextField();
	private final JButton btnNewButton_1 = new JButton("Tilføj Kunde");
	private final JLabel lblNewLabel_3 = new JLabel("Antal");
	private final JTextField textQuantityField = new JTextField();
	private final JLabel lblCustomerLabel = new JLabel("");
	private final JLabel lblNewLabel_5 = new JLabel("CVR:");
	private final JLabel lblCVRLabel = new JLabel("");
	private final JButton btnPayButton = new JButton("Betal");
	private final JLabel lblPaidLabel = new JLabel();
	private final JTextField textFieldPay = new JTextField();
	private final JButton btnPrintButton = new JButton("Print kvittering");
	
	/**
	 * Launch the application.
	 */
	
	private OrderTableModel orderTableModel;
	private OrderController orderController = new OrderController();
	private Order order;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderView frame = new OrderView();
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
	
	public void addProductToOrder() {
		
		String barcode = textBarcodeField.getText();
		String quantity = textQuantityField.getText();
		
		int parsedQuantity = Integer.parseInt(quantity);
		
		textBarcodeField.setText("");
		textQuantityField.setText("");
		
		orderController.addProductToOrder(barcode, parsedQuantity);
		
		double Price = orderController.getOrder().getPrice();
		
		String totalPrice = Double.toString(Price);
		
		lblTotalPriceLabel.setText(totalPrice);
		
		displayOrderLines();
	}
	
	public void addCustomerToOrder() {
		
		String customer = textField_1.getText();
		
		orderController.addCustomerToOrder(customer);
		
		textField_1.setText("");
		
		String customerName = orderController.getOrder().getCustomer().getName();
		String cvr = orderController.getOrder().getCustomer().getCVR();
		
		lblCustomerLabel.setText(customerName);
		lblCVRLabel.setText(cvr);
		
	}
	
	public void payOrder() {
		
		try {
			
			String payment = textFieldPay.getText();
			double parsedPayment = Double.parseDouble(payment);
			
			if (orderController.getOrder().getPrice() == parsedPayment) {
				orderController.getOrder().setPaid(true);
				lblPaidLabel.setText("Ordren er betalt");
			}
			else {
				lblPaidLabel.setText("Forkert beløb, indtast igen");
			}
		} catch (Exception e) {
			System.out.println("Intet beløb");
		}
	
	}
	
	public void printReceipt() {
		orderController.getOrder().printReceipt();
		ReceiptView receiptView = new ReceiptView();
		receiptView.setVisible(true);
	}
	
	public void displayOrderLines() {
		orderTableModel = new OrderTableModel(orderController.getOrder().getOrderLines());
		tblOrder.setModel(orderTableModel);
		
	}
	
	public void backToOrderMenu() {
		OrderMenu orderMenu = new OrderMenu();
		orderMenu.setVisible(true);
	}
	
	public void updateTable() {
		orderTableModel.setData(orderController.getOrder().getOrderLines());
	}

	
	public OrderView() {
		textFieldPay.setColumns(10);
		textQuantityField.setColumns(10);
		textField_1.setColumns(10);
		textBarcodeField.setColumns(10);
		initGUI();
		displayOrderLines();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		northPanel.add(lblNameLabel);
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToOrderMenu();
				dispose();
			}
		});
		btnPrintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printReceipt();
			}
		});
		
		southPanel.add(btnPrintButton);
		
		southPanel.add(btnBackButton);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		FlowLayout flowLayout_1 = (FlowLayout) centerSouthPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		
		centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);
		centerSouthPanel.add(lblPaidLabel);
		
		centerSouthPanel.add(lblTotallabel);
		
		centerSouthPanel.add(lblTotalPriceLabel);
		centerNorthPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
		
		centerNorthPanel.add(lblNewLabel_1);
		
		centerNorthPanel.add(lblCustomerLabel);
		
		centerNorthPanel.add(lblNewLabel_5);
		
		centerNorthPanel.add(lblCVRLabel);
		
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		tblOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tblOrder);
		
		contentPane.add(centerWestPanel, BorderLayout.WEST);
		GridBagLayout gbl_centerWestPanel = new GridBagLayout();
		gbl_centerWestPanel.columnWidths = new int[]{120, 0, 0};
		gbl_centerWestPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_centerWestPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerWestPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerWestPanel.setLayout(gbl_centerWestPanel);
		
		GridBagConstraints gbc_btnPayButton = new GridBagConstraints();
		gbc_btnPayButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnPayButton.gridx = 0;
		gbc_btnPayButton.gridy = 15;
		btnPayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payOrder();
			}
		});
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 9;
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomerToOrder();
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		
		// dette styre positionen af knappen i grid.
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 7;
		
		// dette låser knappen til grid.
		gbc_btnNewButton.anchor = GridBagConstraints.CENTER; // Centered within its cell
		gbc_btnNewButton.fill = GridBagConstraints.NONE;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProductToOrder();
			}
		});
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		centerWestPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_textBarcodeField = new GridBagConstraints();
		gbc_textBarcodeField.insets = new Insets(0, 0, 5, 0);
		gbc_textBarcodeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBarcodeField.gridx = 1;
		gbc_textBarcodeField.gridy = 5;
		centerWestPanel.add(textBarcodeField, gbc_textBarcodeField);
		
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		centerWestPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		GridBagConstraints gbc_textQuantityField = new GridBagConstraints();
		gbc_textQuantityField.insets = new Insets(0, 0, 5, 0);
		gbc_textQuantityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textQuantityField.gridx = 1;
		gbc_textQuantityField.gridy = 6;
		centerWestPanel.add(textQuantityField, gbc_textQuantityField);
		centerWestPanel.add(btnNewButton, gbc_btnNewButton);
		
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 8;
		centerWestPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 8;
		centerWestPanel.add(textField_1, gbc_textField_1);
		centerWestPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		centerWestPanel.add(btnPayButton, gbc_btnPayButton);
		
		GridBagConstraints gbc_textFieldPay = new GridBagConstraints();
		gbc_textFieldPay.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPay.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPay.gridx = 1;
		gbc_textFieldPay.gridy = 15;
		centerWestPanel.add(textFieldPay, gbc_textFieldPay);
	}

}

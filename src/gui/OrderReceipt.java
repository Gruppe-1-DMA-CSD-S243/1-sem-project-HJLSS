package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import model.Customer.BusinessCustomer;
import model.Order.OrderContainer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class OrderReceipt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel northPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblOrder = new JTable();
	private ReceiptTableModel tblModel;
	private OrderView orderView;
	private final JLabel lblOrder = new JLabel("Ordrenummer:");
	private final JLabel lblOrderNo = new JLabel("");
	private final JLabel lblTimeOfPurchase = new JLabel("");
	private final JPanel southPanel = new JPanel();
	private final JLabel lblTotal = new JLabel("Total:");
	private final JLabel lblTotalPrice = new JLabel("");
	private final JLabel lblCustomer = new JLabel("");
	private final JLabel lblName = new JLabel("");
	private final JLabel lblAddress = new JLabel("");
	private final JLabel lblEmail = new JLabel("");
	private final JLabel lblPhone = new JLabel("");
	private final JLabel lblCVR = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderReceipt frame = new OrderReceipt(null);
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
	public OrderReceipt(OrderView orderView) {
		setAlwaysOnTop(true);
		this.orderView = orderView;
		initGUI();
		displayOrderLines();
		printAllInfo();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		GridBagLayout gbl_northPanel = new GridBagLayout();
		gbl_northPanel.columnWidths = new int[]{0, 0, 0};
		gbl_northPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_northPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_northPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		northPanel.setLayout(gbl_northPanel);
		
		GridBagConstraints gbc_lblOrder = new GridBagConstraints();
		gbc_lblOrder.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrder.gridx = 0;
		gbc_lblOrder.gridy = 0;
		northPanel.add(lblOrder, gbc_lblOrder);
		
		GridBagConstraints gbc_lblOrderNo = new GridBagConstraints();
		gbc_lblOrderNo.insets = new Insets(0, 0, 5, 0);
		gbc_lblOrderNo.gridx = 1;
		gbc_lblOrderNo.gridy = 0;
		northPanel.add(lblOrderNo, gbc_lblOrderNo);
		
		GridBagConstraints gbc_lblTimeOfPurchase = new GridBagConstraints();
		gbc_lblTimeOfPurchase.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeOfPurchase.gridx = 0;
		gbc_lblTimeOfPurchase.gridy = 1;
		northPanel.add(lblTimeOfPurchase, gbc_lblTimeOfPurchase);
		
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.anchor = GridBagConstraints.WEST;
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomer.gridx = 0;
		gbc_lblCustomer.gridy = 3;
		northPanel.add(lblCustomer, gbc_lblCustomer);
		
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 4;
		northPanel.add(lblName, gbc_lblName);
		
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 5;
		northPanel.add(lblAddress, gbc_lblAddress);
		
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		northPanel.add(lblEmail, gbc_lblEmail);
		
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 7;
		northPanel.add(lblPhone, gbc_lblPhone);
		
		GridBagConstraints gbc_lblCVR = new GridBagConstraints();
		gbc_lblCVR.anchor = GridBagConstraints.WEST;
		gbc_lblCVR.insets = new Insets(0, 0, 5, 5);
		gbc_lblCVR.gridx = 0;
		gbc_lblCVR.gridy = 8;
		northPanel.add(lblCVR, gbc_lblCVR);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		centerPanel.add(scrollPane);
		tblOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tblOrder);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_southPanel = new GridBagLayout();
		gbl_southPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_southPanel.rowHeights = new int[]{0, 0};
		gbl_southPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_southPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		southPanel.setLayout(gbl_southPanel);
		
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 13;
		gbc_lblTotal.gridy = 0;
		southPanel.add(lblTotal, gbc_lblTotal);
		
		
		GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
		gbc_lblTotalPrice.gridx = 14;
		gbc_lblTotalPrice.gridy = 0;
		southPanel.add(lblTotalPrice, gbc_lblTotalPrice);
	}
	
	public void displayOrderLines() {
		tblModel = new ReceiptTableModel(this.orderView.getOrderController().getOrder().getOrderLines());
		tblOrder.setModel(tblModel);
	}
	
//	public void updateOrderLines() {
//		tblModel.setData(orderView.getOrderController().getOrder().getOrderLines());
//	}
	
	private void setOrderNo() {
		lblOrderNo.setText(orderView.getOrderController().getOrder().getOrderNo());
	}
	
	private void setTimeOfPurchase() {
		lblTimeOfPurchase.setText(orderView.getOrderController().getOrder().getTimeOfPurchase());
	}
	
	private void setTotalPrice() {
		lblTotalPrice.setText("" + orderView.getOrderController().getOrder().getPrice());
	}
	
	private BusinessCustomer getCustomer() {
		return orderView.getOrderController().getOrder().getCustomer();
	}
	
	private void setCustomerInfo() {
		if (getCustomer() != null) {
			lblCustomer.setText("Kunde:");
			lblName.setText(getCustomer().getName());
			lblAddress.setText(getCustomer().getAddress());
			lblEmail.setText(getCustomer().getEmail());
			lblPhone.setText(getCustomer().getPhone());
			lblCVR.setText(getCustomer().getCVR());
		}
	}
	
	private void printAllInfo() {
		setOrderNo();
		setTimeOfPurchase();
		setTotalPrice();
		setCustomerInfo();
	}

}

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import model.Order.Order;
import model.Order.OrderContainer;
import model.Order.OrderLine;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class OrderView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel northPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JLabel lblName = new JLabel("Ordre");
	private final JButton btnCancel = new JButton("Annuller");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblOrder = new JTable();
	private OrderTableModel tblModel;
	private OrderController orderController;
	private final JPanel centerSouthPanel = new JPanel();
	private final JPanel eastPanel = new JPanel();
	private final JButton btnAddProduct = new JButton("Tilføj Produkt");
	private final JButton btnAddCustomer = new JButton("Tilføj Kunde");
	private final JPanel centerSouthWestPanel = new JPanel();
	private final JPanel centerSouthEastPanel = new JPanel();
	private final JLabel lblCustomer = new JLabel("Kunde:");
	private final JLabel lblCustomerName = new JLabel("");
	private final JLabel lblTotal = new JLabel("Total:");
	private final JLabel lblTotalPrice = new JLabel("");
	private final JButton btnMakePayment = new JButton("Betal Ordre");
	private final JButton btnFinishOrder = new JButton("Bekræft Ordre");
	private final JButton btnRemoveProduct = new JButton("Fjern Produkt");
	/**
	 * Launch the application.
	 */
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
	public OrderView() {
		this.orderController = new OrderController();
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
		
		northPanel.add(lblName);
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnToOrderMenu();
			}
		});
		btnFinishOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishOrder();
			}
		});
		
		southPanel.add(btnFinishOrder);
		
		southPanel.add(btnCancel);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		tblOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tblOrder);
		
		centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);
		centerSouthPanel.setLayout(new BorderLayout(0, 0));
		FlowLayout flowLayout_1 = (FlowLayout) centerSouthWestPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		centerSouthPanel.add(centerSouthWestPanel, BorderLayout.WEST);
		
		centerSouthWestPanel.add(lblCustomer);
		
		centerSouthWestPanel.add(lblCustomerName);
		FlowLayout flowLayout_2 = (FlowLayout) centerSouthEastPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		
		centerSouthPanel.add(centerSouthEastPanel, BorderLayout.EAST);
		
		centerSouthEastPanel.add(lblTotal);
		
		centerSouthEastPanel.add(lblTotalPrice);
		
		centerPanel.add(eastPanel, BorderLayout.EAST);
		GridBagLayout gbl_eastPanel = new GridBagLayout();
		gbl_eastPanel.columnWidths = new int[]{97, 0};
		gbl_eastPanel.rowHeights = new int[]{23, 0, 0, 0, 0};
		gbl_eastPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_eastPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		eastPanel.setLayout(gbl_eastPanel);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProductToOrder();
			}
		});
		
		GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
		gbc_btnAddProduct.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddProduct.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddProduct.anchor = GridBagConstraints.NORTH;
		gbc_btnAddProduct.gridx = 0;
		gbc_btnAddProduct.gridy = 0;
		eastPanel.add(btnAddProduct, gbc_btnAddProduct);
		
		GridBagConstraints gbc_btnMakePayment = new GridBagConstraints();
		gbc_btnMakePayment.anchor = GridBagConstraints.NORTH;
		gbc_btnMakePayment.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMakePayment.gridx = 0;
		gbc_btnMakePayment.gridy = 3;
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makePayment();
			}
		});
		
		GridBagConstraints gbc_btnAddCustomer = new GridBagConstraints();
		gbc_btnAddCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddCustomer.anchor = GridBagConstraints.NORTH;
		gbc_btnAddCustomer.gridx = 0;
		gbc_btnAddCustomer.gridy = 2;
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomerToOrder();
			}
		});
		
		GridBagConstraints gbc_btnRemoveProduct = new GridBagConstraints();
		gbc_btnRemoveProduct.anchor = GridBagConstraints.NORTH;
		gbc_btnRemoveProduct.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemoveProduct.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemoveProduct.gridx = 0;
		gbc_btnRemoveProduct.gridy = 1;
		setVisibilityForRemoveProduct();
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeOrderLineFromOrder();
			}
		});
		eastPanel.add(btnRemoveProduct, gbc_btnRemoveProduct);
		eastPanel.add(btnAddCustomer, gbc_btnAddCustomer);
		eastPanel.add(btnMakePayment, gbc_btnMakePayment);
	}
	
	private void returnToOrderMenu() {
		OrderMenu orderMenu = new OrderMenu();
		orderMenu.setVisible(true);
		hideFrame();
	}
	
	void updateOrderLines() {
		tblModel.setData(this.orderController.getOrder().getOrderLines());
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}
	
//	void addProductToOrder(int quantity, String barcode) {
//		if (orderController.findProductByBarcode(barcode) != null) {
//			orderController.addProductToOrder(barcode, quantity);
//		}
//		else {
//			System.out.println("Ugyldig stregkode!");
//		}
//	}
	
	private void addProductToOrder() {
		OrderViewProduct addProduct = new OrderViewProduct(this);
		addProduct.setVisible(true);
	}
	
	private void removeOrderLineFromOrder() {
		int selectedRow = tblOrder.getSelectedRow();
		
		if (selectedRow != -1) {
			OrderLine selectedOrderLine = tblModel.getOrderLineAt(selectedRow);
			
			this.orderController.removeOrderLineFromOrder(selectedOrderLine);
			getTotalPrice().setText("" + orderController.getOrder().getPrice());;
			
			updateOrderLines();
			
			setVisibilityForRemoveProduct();
		}
	}
	
	void setVisibilityForRemoveProduct() {
		if (orderController.getOrder().getOrderLines().isEmpty()) {
			btnRemoveProduct.setVisible(false);
		}
		else {
			btnRemoveProduct.setVisible(true);
		}
	}
	
	private void addCustomerToOrder() {
		OrderViewCustomer addCustomer = new OrderViewCustomer(this);
		addCustomer.setVisible(true);
	}
	
	private void makePayment() {
		OrderViewPayment makePayment = new OrderViewPayment(this);
		makePayment.setVisible(true);
	}
	
	private void finishOrder() {
		Receipt receipt = new Receipt(this);
		receipt.setVisible(true);
		OrderMenu orderMenu = new OrderMenu();
		orderMenu.setVisible(true);
		
		orderController.finishOrder();
		hideFrame();
	}
	
	OrderController getOrderController() {
		return this.orderController;
	}
	
	JLabel getTotalPrice() {
		return this.lblTotalPrice;
	}
	
	JLabel getCustomerName() {
		return this.lblCustomerName;
	}
	
	public void displayOrderLines() {
		tblModel = new OrderTableModel(orderController.getOrder().getOrderLines());
		tblOrder.setModel(tblModel);
	}
	
	JButton getCustomerButton() {
		return this.btnAddCustomer;
	}

}

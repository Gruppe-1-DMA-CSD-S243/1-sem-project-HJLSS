package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class OrderMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel northPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JLabel lblName = new JLabel("Ordremenu");
	private final JButton btnBack = new JButton("Tilbage");
	private final JButton btnCreateOrder = new JButton("Opret Ordre");
	private final JButton btnOrderHistory = new JButton("Ordrehistorik");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMenu frame = new OrderMenu();
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
	public OrderMenu() {
		initGUI();
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
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnToMainMenu();
			}
		});
		
		southPanel.add(btnBack);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[]{0, 0};
		gbl_centerPanel.rowHeights = new int[]{0, 0, 0};
		gbl_centerPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		centerPanel.setLayout(gbl_centerPanel);
		
		GridBagConstraints gbc_btnCreateOrder = new GridBagConstraints();
		gbc_btnCreateOrder.anchor = GridBagConstraints.NORTH;
		gbc_btnCreateOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateOrder.gridx = 0;
		gbc_btnCreateOrder.gridy = 0;
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchCreateOrder();
			}
		});
		centerPanel.add(btnCreateOrder, gbc_btnCreateOrder);
		
		GridBagConstraints gbc_btnOrderHistory = new GridBagConstraints();
		gbc_btnOrderHistory.anchor = GridBagConstraints.NORTH;
		gbc_btnOrderHistory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOrderHistory.gridx = 0;
		gbc_btnOrderHistory.gridy = 1;
		btnOrderHistory.setEnabled(false);
		centerPanel.add(btnOrderHistory, gbc_btnOrderHistory);
	}
	
	private void launchCreateOrder() {
		OrderView orderView = new OrderView();
		orderView.setVisible(true);
		hideFrame();
	}
	
	private void returnToMainMenu() {
		MainMenu mainMenu = new MainMenu();
		mainMenu.setVisible(true);
		hideFrame();
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}

}

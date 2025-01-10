package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;

import model.Order.Order;
import model.Order.OrderLine;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ReceiptView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel northPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JPanel westPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JPanel eastPanel = new JPanel();
	private final JLabel lblOrderLabel = new JLabel("Ordre:");
	private final JLabel lblOrderNumberLabel = new JLabel("Ordre nummer");
	private final JLabel lblCustomerLabel = new JLabel("Kunde:");
	private final JLabel lblCustomerNameLabel = new JLabel("Kunde navn");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JList list = new JList();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	                ReceiptView frame = new ReceiptView();
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
	public ReceiptView() {
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
		
		northPanel.add(lblOrderLabel);
		
		northPanel.add(lblOrderNumberLabel);
		
		northPanel.add(lblCustomerLabel);
		
		northPanel.add(lblCustomerNameLabel);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		contentPane.add(westPanel, BorderLayout.WEST);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(list);
		
		contentPane.add(eastPanel, BorderLayout.EAST);
	}

}

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
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblOrderMenu = new JLabel("Velkommen til ordremenuen");
		panelNorth.add(lblOrderMenu);
		
		JPanel panelSouth = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSouth.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchBack();
			}
		});
		panelSouth.add(btnBack);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{0, 0, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelCenter.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JLabel lblChoice = new JLabel("Vælg en menu:");
		GridBagConstraints gbc_lblChoice = new GridBagConstraints();
		gbc_lblChoice.insets = new Insets(0, 0, 5, 0);
		gbc_lblChoice.gridx = 1;
		gbc_lblChoice.gridy = 0;
		panelCenter.add(lblChoice, gbc_lblChoice);
		
		JButton btnCreateOrder = new JButton("Opret salg");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchCreateOrder();
			}
		});
		GridBagConstraints gbc_btnCreateOrder = new GridBagConstraints();
		gbc_btnCreateOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateOrder.gridx = 1;
		gbc_btnCreateOrder.gridy = 1;
		panelCenter.add(btnCreateOrder, gbc_btnCreateOrder);
		
		JButton btnSearch = new JButton("Ordrehistorik");
		btnSearch.setEnabled(false);
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 2;
		panelCenter.add(btnSearch, gbc_btnSearch);
	}

	private void launchCreateOrder() {
		// TODO Auto-generated method stub
		OrderView orderView = new OrderView();
		orderView.setVisible(true);
		
		setVisible(false);
	}

	private void launchBack() {
		// TODO Auto-generated method stub
		MainMenu mainMenu = new MainMenu();
		mainMenu.setVisible(true);
		
		setVisible(false);
		
	}

}

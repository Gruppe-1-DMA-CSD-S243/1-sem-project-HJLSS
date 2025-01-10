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

public class OrderMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel northPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JLabel lblNameLabel = new JLabel("Ordre Menu");
	private final JButton btnBackButton = new JButton("Tilbage");
	private final JPanel centerPanel = new JPanel();
	private final JButton btnCreateOrderButton = new JButton("Opret Ordre");

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
	
	public void backToMainMenu() {
		MainMenu mainMenu = new MainMenu();
		mainMenu.setVisible(true);
	}
	
	public void createOrder() {
		OrderView orderView = new OrderView();
		orderView.setVisible(true);
	}
	
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
		
		northPanel.add(lblNameLabel);
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMainMenu();
				dispose();
			}
		});
		
		southPanel.add(btnBackButton);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[]{0, 0, 0};
		gbl_centerPanel.rowHeights = new int[]{0, 0, 0};
		gbl_centerPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		centerPanel.setLayout(gbl_centerPanel);
		
		GridBagConstraints gbc_btnCreateOrderButton = new GridBagConstraints();
		gbc_btnCreateOrderButton.gridx = 1;
		gbc_btnCreateOrderButton.gridy = 1;
		btnCreateOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOrder();
			}
		});
		centerPanel.add(btnCreateOrderButton, gbc_btnCreateOrderButton);
	}

}

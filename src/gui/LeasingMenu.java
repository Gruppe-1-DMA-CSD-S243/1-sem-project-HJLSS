package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LeasingMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel southPanel = new JPanel();
	private final JButton btnBack = new JButton("Tilbage");
	private final JPanel northPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JLabel lblName = new JLabel("Leasing Menu");
	private final JButton btnCreate = new JButton("Opret");
	private final JButton btnReturn = new JButton("Retuner");
	private final JButton btnHistory = new JButton("Leasinghistorik");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeasingMenu frame = new LeasingMenu();
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
	public LeasingMenu() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnToMainMenu();
			}
		});
		
		southPanel.add(btnBack);
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		northPanel.add(lblName);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[]{0, 0};
		gbl_centerPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_centerPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerPanel.setLayout(gbl_centerPanel);
		
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreate.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreate.gridx = 0;
		gbc_btnCreate.gridy = 0;
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeasingView();
			}
		});
		centerPanel.add(btnCreate, gbc_btnCreate);
		
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.insets = new Insets(0, 0, 5, 0);
		gbc_btnReturn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReturn.gridx = 0;
		gbc_btnReturn.gridy = 1;
		centerPanel.add(btnReturn, gbc_btnReturn);
		
		GridBagConstraints gbc_btnHistory = new GridBagConstraints();
		gbc_btnHistory.gridx = 0;
		gbc_btnHistory.gridy = 2;
		centerPanel.add(btnHistory, gbc_btnHistory);
	}
	
	protected void launchLeasingView() {
		// TODO Auto-generated method stub
		LeasingView leasingView = new LeasingView();
		leasingView.setVisible(true);
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

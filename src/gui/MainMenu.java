package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel southPanel = new JPanel();
	private final JPanel northPanel = new JPanel();
	private final JLabel lblNameLabel = new JLabel("Velkommen til Vestbjerg Byggecenter");
	private final JButton btnCloseButton = new JButton("Afslut");
	private final JPanel centerPanel = new JPanel();
	private final JButton btnOrderButton = new JButton("Ordre");

	/**
	 * Launch the application.
	 */
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void openOrder() {
		OrderMenu orderMenu = new OrderMenu();
		orderMenu.setVisible(true);
		this.setVisible(false);
	}
	

	/**
	 * Create the frame.
	 */
	public MainMenu() {
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
		btnCloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		southPanel.add(btnCloseButton);
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		northPanel.add(lblNameLabel);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[]{0, 0, 0};
		gbl_centerPanel.rowHeights = new int[]{0, 0, 0};
		gbl_centerPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		centerPanel.setLayout(gbl_centerPanel);
		
		GridBagConstraints gbc_btnOrderButton = new GridBagConstraints();
		gbc_btnOrderButton.gridx = 1;
		gbc_btnOrderButton.gridy = 1;
		btnOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openOrder();
			}
		});
		centerPanel.add(btnOrderButton, gbc_btnOrderButton);
	}

}

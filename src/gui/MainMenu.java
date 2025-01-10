package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel northPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JButton btnClose = new JButton("Afslut");
	private final JButton btnOrderMenu = new JButton("Ordremenu");
	private final JButton btnLeasingMenu = new JButton("Udlejningsmenu");
	private final JLabel lblLogo = new JLabel("");
	private final JPanel northCenterPanel = new JPanel();
	private final JLabel lblName = new JLabel("Vestbjerg Byggecenter");

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
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		ImageIcon logo = new ImageIcon("C:\\Users\\Saas\\eclipse-workspace\\foerste_semester_projekt\\src\\resources\\Vestbjerg_Byggecenter_Logo.png");
        Image image = logo.getImage();
        Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        
        lblLogo.setIcon(resizedImageIcon);
        lblLogo.setBounds(20, 11, 253, 209);
		
		northPanel.add(lblLogo, BorderLayout.EAST);
		
		northPanel.add(northCenterPanel, BorderLayout.CENTER);
		northCenterPanel.setLayout(null);
		lblName.setBounds(134, 18, 169, 21);
		
		northCenterPanel.add(lblName);
		FlowLayout flowLayout_1 = (FlowLayout) southPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideFrame();
			}
		});
		
		southPanel.add(btnClose);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[]{74, 0, 0, 0};
		gbl_centerPanel.rowHeights = new int[]{23, 0, 0};
		gbl_centerPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		centerPanel.setLayout(gbl_centerPanel);
		btnOrderMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchOrderMenu();
			}
		});
		
		GridBagConstraints gbc_btnOrderMenu = new GridBagConstraints();
		gbc_btnOrderMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOrderMenu.insets = new Insets(0, 0, 5, 5);
		gbc_btnOrderMenu.anchor = GridBagConstraints.NORTH;
		gbc_btnOrderMenu.gridx = 0;
		gbc_btnOrderMenu.gridy = 0;
		centerPanel.add(btnOrderMenu, gbc_btnOrderMenu);
		
		GridBagConstraints gbc_btnLeasingMenu = new GridBagConstraints();
		gbc_btnLeasingMenu.anchor = GridBagConstraints.NORTH;
		gbc_btnLeasingMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLeasingMenu.insets = new Insets(0, 0, 0, 5);
		gbc_btnLeasingMenu.gridx = 0;
		gbc_btnLeasingMenu.gridy = 1;
		btnLeasingMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLeasingMenu();
			}
		});
		centerPanel.add(btnLeasingMenu, gbc_btnLeasingMenu);
	}
	
	private void launchOrderMenu() {
		OrderMenu orderMenu = new OrderMenu();
		orderMenu.setVisible(true);
		hideFrame();
	}
	
	private void launchLeasingMenu() {
		LeasingMenu leasingMenu = new LeasingMenu();
		leasingMenu.setVisible(true);
		hideFrame();
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}

}

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
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 479, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblNavn = new JLabel("Velkommen til Vestbjerg Byggecenter");
		panelNorth.add(lblNavn);
		
		JPanel panelSouth = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSouth.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchClose();
			}
		});
		panelSouth.add(btnClose);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenterWest = new JPanel();
		panelCenter.add(panelCenterWest, BorderLayout.WEST);
		GridBagLayout gbl_panelCenterWest = new GridBagLayout();
		gbl_panelCenterWest.columnWidths = new int[] {0};
		gbl_panelCenterWest.rowHeights = new int[]{0, 0, 0};
		gbl_panelCenterWest.columnWeights = new double[]{0.0};
		gbl_panelCenterWest.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelCenterWest.setLayout(gbl_panelCenterWest);
		
		JLabel lblID = new JLabel("MedarbejderID:");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 5, 0);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 0;
		panelCenterWest.add(lblID, gbc_lblID);
		
		JButton btnLogin = new JButton("Log ind");
		btnLogin.setEnabled(false);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.WEST;
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 1;
		panelCenterWest.add(btnLogin, gbc_btnLogin);
		
		JPanel panelCenterCenter = new JPanel();
		panelCenter.add(panelCenterCenter, BorderLayout.CENTER);
		panelCenterCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCCW = new JPanel();
		panelCenterCenter.add(panelCCW, BorderLayout.WEST);
		GridBagLayout gbl_panelCCW = new GridBagLayout();
		gbl_panelCCW.columnWidths = new int[]{0, 0};
		gbl_panelCCW.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelCCW.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelCCW.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCCW.setLayout(gbl_panelCCW);
		
		JLabel lblChoice = new JLabel("Vælg en menu:");
		GridBagConstraints gbc_lblChoice = new GridBagConstraints();
		gbc_lblChoice.insets = new Insets(0, 0, 5, 0);
		gbc_lblChoice.gridx = 0;
		gbc_lblChoice.gridy = 0;
		panelCCW.add(lblChoice, gbc_lblChoice);
		
		JButton btnOrder = new JButton("Ordre menu");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchOrder();
			}
		});
		GridBagConstraints gbc_btnOrder = new GridBagConstraints();
		gbc_btnOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnOrder.gridx = 0;
		gbc_btnOrder.gridy = 1;
		panelCCW.add(btnOrder, gbc_btnOrder);
		
		JButton btnReturn = new JButton("Returner varer");
		btnReturn.setEnabled(false);
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReturn.insets = new Insets(0, 0, 5, 0);
		gbc_btnReturn.gridx = 0;
		gbc_btnReturn.gridy = 2;
		panelCCW.add(btnReturn, gbc_btnReturn);
		
		JButton btnLeasing = new JButton("Leasing");
		btnLeasing.setEnabled(false);
		GridBagConstraints gbc_btnLeasing = new GridBagConstraints();
		gbc_btnLeasing.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLeasing.insets = new Insets(0, 0, 5, 0);
		gbc_btnLeasing.gridx = 0;
		gbc_btnLeasing.gridy = 3;
		panelCCW.add(btnLeasing, gbc_btnLeasing);
		
		JButton btnStock = new JButton("Tjek lager");
		btnStock.setEnabled(false);
		GridBagConstraints gbc_btnStock = new GridBagConstraints();
		gbc_btnStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStock.gridx = 0;
		gbc_btnStock.gridy = 4;
		panelCCW.add(btnStock, gbc_btnStock);
		
		JPanel panelCCC = new JPanel();
		panelCenterCenter.add(panelCCC, BorderLayout.CENTER);
		panelCCC.setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon("C:\\Billeder\\Vestbjerg Byggecenter Logo1.png");
		Image image = imageIcon.getImage();
		Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
		
		JLabel lblLogo = new JLabel(resizedImageIcon);
		//lblLogo.setIcon(new ImageIcon("C:\\Billeder\\Vestbjerg Byggecenter Logo1.png"));
		lblLogo.setBounds(20, 11, 253, 209);
		panelCCC.add(lblLogo);
	}

	private void launchOrder() {
		// TODO Auto-generated method stub
		OrderMenu orderMenu = new OrderMenu();
		orderMenu.setVisible(true);
		
		setVisible(false);
	}

	private void launchClose() {
		// TODO Auto-generated method stub
		
		setVisible(false);
		dispose();
	}
}

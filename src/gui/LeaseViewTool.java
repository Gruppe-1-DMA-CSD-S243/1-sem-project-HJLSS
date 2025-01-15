package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Tool.ToolContainer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;

public class LeaseViewTool extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldID;
	private LeaseView leaseView;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LeaseViewTool dialog = new LeaseViewTool(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LeaseViewTool(LeaseView leaseView) {
		this.leaseView = leaseView;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel centerPanel = new JPanel();
			contentPanel.add(centerPanel, BorderLayout.CENTER);
			GridBagLayout gbl_centerPanel = new GridBagLayout();
			gbl_centerPanel.columnWidths = new int[]{71, 201, 0, 0};
			gbl_centerPanel.rowHeights = new int[]{23, 0, 0};
			gbl_centerPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			centerPanel.setLayout(gbl_centerPanel);
			{
				JLabel lblAddTool = new JLabel("Indtast ID:");
				GridBagConstraints gbc_lblAddTool = new GridBagConstraints();
				gbc_lblAddTool.anchor = GridBagConstraints.WEST;
				gbc_lblAddTool.insets = new Insets(0, 0, 0, 5);
				gbc_lblAddTool.gridx = 0;
				gbc_lblAddTool.gridy = 1;
				centerPanel.add(lblAddTool, gbc_lblAddTool);
			}
			{
				textFieldID = new JTextField();
				GridBagConstraints gbc_textFieldID = new GridBagConstraints();
				gbc_textFieldID.insets = new Insets(0, 0, 0, 5);
				gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldID.gridx = 1;
				gbc_textFieldID.gridy = 1;
				centerPanel.add(textFieldID, gbc_textFieldID);
				textFieldID.setColumns(10);
			}
			{
				lblError = new JLabel("");
				GridBagConstraints gbc_lblError = new GridBagConstraints();
				gbc_lblError.gridx = 2;
				gbc_lblError.gridy = 1;
				centerPanel.add(lblError, gbc_lblError);
			}
		}
		{
			JPanel northPanel = new JPanel();
			contentPanel.add(northPanel, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAdd = new JButton("Tilføj");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addToolToLease();
					}
				});
				btnAdd.setActionCommand("OK");
				buttonPane.add(btnAdd);
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				JButton btnCancel = new JButton("Annuller");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						hideFrame();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	
	private void addToolToLease() {
		String toolID = textFieldID.getText();
		
		if (leaseView.getLeaseController().findToolByID(toolID) != null) {
			leaseView.getLeaseController().addToolToLease(toolID);
			leaseView.updateLeases();
			
			hideFrame();
		}
		
		else {
			lblError.setText("Ugyldigt ID!");
			System.out.println("Ugyldigt ID!");
		}
		
//		try {
//			leaseView.getLeaseController().addToolToLease(toolID);
//			leaseView.updateLeases();
//			
//			hideFrame();
//			
//		}
//		catch (Exception e) {
//			lblError.setText("Ugyldigt ID!");
//			System.out.println("Ugyldigt ID!");
//		}
	}
	
	private void hideFrame() {
		this.setVisible(false);
		this.dispose();
	}

}

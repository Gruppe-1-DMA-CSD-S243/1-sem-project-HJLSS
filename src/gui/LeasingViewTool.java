package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeasingViewTool extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldID;
	private LeasingView leasingView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LeasingViewTool dialog = new LeasingViewTool(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LeasingViewTool(LeasingView leasingView) {
		this.leasingView = leasingView;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblToolID = new JLabel("RedskabsID:");
			GridBagConstraints gbc_lblToolID = new GridBagConstraints();
			gbc_lblToolID.anchor = GridBagConstraints.EAST;
			gbc_lblToolID.insets = new Insets(0, 0, 5, 5);
			gbc_lblToolID.gridx = 0;
			gbc_lblToolID.gridy = 0;
			contentPanel.add(lblToolID, gbc_lblToolID);
		}
		{
			textFieldID = new JTextField();
			GridBagConstraints gbc_textFieldID = new GridBagConstraints();
			gbc_textFieldID.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldID.gridx = 1;
			gbc_textFieldID.gridy = 0;
			contentPanel.add(textFieldID, gbc_textFieldID);
			textFieldID.setColumns(10);
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
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	private void addToolToLease() {
		// TODO Auto-generated method stub
		String id = textFieldID.getText();
		
		leasingView.getLeaseController().addToolToLease(id);
		leasingView.updateLeases();
		
		leasingView.getTotalPrice().setText("" + leasingView.getLeaseController().getLease().getPrice());
		
		hideFrame();
			
	}

	private void hideFrame() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
	}
	
	

}

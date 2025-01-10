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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerToOrder extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfCVR;
	private OrderView orderView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerToOrder dialog = new CustomerToOrder(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerToOrder(OrderView orderView) {
		this.orderView = orderView;
		initGUI();
	}
	private void initGUI() {
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCustomer = new JLabel("Skriv kundens CVR:");
			GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
			gbc_lblCustomer.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblCustomer.insets = new Insets(0, 0, 5, 0);
			gbc_lblCustomer.gridx = 1;
			gbc_lblCustomer.gridy = 1;
			contentPanel.add(lblCustomer, gbc_lblCustomer);
		}
		{
			tfCVR = new JTextField();
			GridBagConstraints gbc_tfCVR = new GridBagConstraints();
			gbc_tfCVR.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfCVR.gridx = 1;
			gbc_tfCVR.gridy = 2;
			contentPanel.add(tfCVR, gbc_tfCVR);
			tfCVR.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAdd = new JButton("Add");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						launchAdd();
					}
				});
				btnAdd.setActionCommand("OK");
				buttonPane.add(btnAdd);
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void launchAdd() {
		// TODO Auto-generated method stub
		String cvr = tfCVR.getText();
		
		orderView.getOrderController().addCustomerToOrder(cvr);
		
		//if(orderView.getOrderController().getOrder().getCustomer().getName() != null) {
			
		//}
			//else {
				//String customer = orderView.getOrderController().getOrder().getCustomer().getName();
				//orderView.getCustomer().setText("" + customer);
		
		dispose();
	}
	
	

}

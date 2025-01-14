package controller;
//
import java.util.HashMap;

import model.Customer.BusinessCustomer;
import model.Customer.Customer;
import model.Customer.CustomerContainer;
import model.Customer.PrivateCustomer;


/**Creates class for CustomerController.
 * Purpose of CustomController class, is to find customers by CVR. 
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik			
 */
public class CustomerController {
	

	public CustomerController() {

	}
	
	/**Purpose of this method is to find Customer by CVR search. System returns CVR if matched.
	 * @param cvr
	 * @return
	 */
	public BusinessCustomer findCustomerByCVR(String cvr) {
		return CustomerContainer.getInstance().findCustomerByCVR(cvr);
	}
	
	public PrivateCustomer findPrivateCustomerByPhone(String phone) {
		return CustomerContainer.getInstance().findPrivateCustomerByPhone(phone);
	}
}
package ui;

import controller.OrderController;
import controller.LeaseController;
import model.Customer.BusinessCustomer;
import model.Customer.CustomerContainer;
import model.Customer.PrivateCustomer;
import model.Lease.Lease;
import model.Lease.LeaseContainer;
import model.Order.Order;
import model.Order.OrderContainer;
import model.Product.ProductCategory;
import model.Product.ProductCategoryContainer;
import model.Product.ProductContainer;
import model.Product.SimpleProduct;
import model.Tool.Tool;
import model.Tool.ToolContainer;


/**
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 */
public class TryMe {
	
	private LeaseController leaseController;
	
	public void createTestData() {
		PrivateCustomer privateCustomer1 = new PrivateCustomer("nameTestPrivate", "emailTestPrivate", "phoneTestPrivate", "addressTestPrivate");
		CustomerContainer.getInstance().addPrivateCustomer(privateCustomer1);
		
		Tool tool1 = new Tool("1", "1", "1", "nameTest101", "123", "Stanley", "1000x", "stærk", 200.00, 600.00, 5);
		Tool tool2 = new Tool("2", "1", "1", "nameTest101", "123", "Stanley", "1000x", "stærk", 200.00, 600.00, 5);
		ToolContainer.getInstance().addTool(tool1);
		ToolContainer.getInstance().addTool(tool2);
		
		System.out.println(CustomerContainer.getInstance().getPrivateCustomers().get("phoneTestPrivate").getName());
		System.out.println(ToolContainer.getInstance().findToolByID("1").getName());

		
		leaseController = new LeaseController();
		leaseController.makeNewLease();
		leaseController.addExistingCustomerToLease("phoneTestPrivate");
		leaseController.addToolToLease("1");
		leaseController.finishLease();
		
		System.out.println("By toolID: " + LeaseContainer.getInstance().findLeaseByToolID("1").getLeaseNo());
		System.out.println("By phoneNo: " + LeaseContainer.getInstance().findLeaseByPhoneNumber("phoneTestPrivate").getLeaseNo());
		System.out.println("By leaseNo: " + LeaseContainer.getInstance().findLeaseByLeaseNo("1").getLeaseNo());
		System.out.println(LeaseContainer.getInstance().findLeaseByPhoneNumber("phoneTestPrivate").isReturnOverdue());
	
		
		BusinessCustomer businessCustomer1 = new BusinessCustomer("nameTest", "emailTest", "phoneTest", "addressTest", "cvrTest");
		CustomerContainer.getInstance().addCustomer(businessCustomer1);
		
		BusinessCustomer businessCustomer2 = new BusinessCustomer("nameTest2", "emailTest2", "phoneTest2", "addressTest2", "cvrTest2");
		CustomerContainer.getInstance().addCustomer(businessCustomer2);
		
		BusinessCustomer foundCustomer = CustomerContainer.getInstance().findCustomerByCVR("cvrTest");
		System.out.println(foundCustomer.getCVR());
		
		ProductCategory productCategory1 = new ProductCategory("IDTest", "nameTest", "descriptionTest");
		ProductCategoryContainer.getInstance().addProductCategory(productCategory1);
		
		ProductCategory foundProductCategory = ProductCategoryContainer.getInstance().findProductCategoryByProductCategoryID("IDTest");
		System.out.println(foundProductCategory.getProductCategoryID());
		
		
		SimpleProduct simpleProduct1 = new SimpleProduct("1", "1", productCategory1, "hammer", "Stanley", "123", "1000x", "stærk", 1000.00, 200.00, 500.00, 5);
		SimpleProduct simpleProduct2 = new SimpleProduct("2", "1", productCategory1, "hammer", "Stanley", "123", "1000x", "stærk", 500.00, 200.00, 500.00, 5);
		ProductContainer.getInstance().addProduct(simpleProduct1);
		ProductContainer.getInstance().addProduct(simpleProduct2);
		
		SimpleProduct foundProduct = (SimpleProduct)ProductContainer.getInstance().findProductByBarcode("1");
		System.out.println(foundProduct.getProductCategory().getProductCategoryID());
		
	}
	
	
}

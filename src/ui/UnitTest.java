package ui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.OrderController;
import controller.ProductController;
import model.Customer.BusinessCustomer;
import model.Customer.CustomerContainer;
import model.Product.ProductCategoryContainer;
import model.Product.ProductCategory;


class UnitTest {

	@Test
	 void test() {
		TryMe tryMe = new TryMe();
		tryMe.createTestData();
		
		OrderController oc = new OrderController();
		oc.makeNewOrder();
		oc.addProductToOrder("1", 4);
		oc.addProductToOrder("2", 1);
		oc.addCustomerToOrder("cvrTest");
		oc.makePayment(true);
		
		assertEquals("nameTest", oc.findCustomerByCVR("cvrTest").getName());
		assertEquals("emailTest", oc.findCustomerByCVR("cvrTest").getEmail());
		assertEquals("phoneTest", oc.findCustomerByCVR("cvrTest").getPhone());
		assertEquals("addressTest", oc.findCustomerByCVR("cvrTest").getAddress());
		assertEquals("cvrTest", oc.findCustomerByCVR("cvrTest").getCVR());
		
		assertEquals("IDTest", ProductCategoryContainer.getInstance().findProductCategoryByProductCategoryID("IDTest").getProductCategoryID());
		assertEquals("nameTest", ProductCategoryContainer.getInstance().findProductCategoryByProductCategoryID("IDTest").getProductCategoryName());
		assertEquals("descriptionTest", ProductCategoryContainer.getInstance().findProductCategoryByProductCategoryID("IDTest").getProductCategoryDescription());
		
		ProductCategory productCategory1 = new ProductCategory("IDTest", "nameTest", "descriptionTest");
		
		assertAll("orderline quantity",
		        () -> assertEquals(4, oc.getOrder().getOrderLineByProductBarcode("1").getQuantity()),
		        () -> assertEquals(1, oc.getOrder().getOrderLineByProductBarcode("2").getQuantity())
		    );
		
		assertAll("barcode",
		        () -> assertEquals("1", oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getBarcode()),
		        () -> assertEquals("2", oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getBarcode())
		    );
		
		assertAll("productNo",
		        () -> assertEquals("1", oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getProductNo()),
		        () -> assertEquals("1", oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getProductNo())
		    );
		//Der skal sættes op så dette ikke giver fejl, vores sammenlignings værdi er ikke den som er i vores objekt
		assertAll("category",
		        () -> assertEquals(productCategory1, oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getCategory()),
		        () -> assertEquals(productCategory1, oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getCategory())
		    );
		
		assertAll("name",
		        () -> assertEquals("hammer", oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getName()),
		        () -> assertEquals("hammer", oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getName())
		    );
		
		assertAll("manufacturerName",
		        () -> assertEquals("Stanley", oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getManufacturerName()),
		        () -> assertEquals("Stanley", oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getManufacturerName())
		    );
		
		assertAll("manufacturerID",
		        () -> assertEquals("123", oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getManufacturerID()),
		        () -> assertEquals("123", oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getManufacturerID())
		    );
		
		assertAll("model",
		        () -> assertEquals("1000x", oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getModel()),
		        () -> assertEquals("1000x", oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getModel())
		    );
		
		assertAll("description",
		        () -> assertEquals("stærk", oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getDescription()),
		        () -> assertEquals("stærk", oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getDescription())
		    );
		
		assertAll("price",
		        () -> assertEquals(1000.00, oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getPrice()),
		        () -> assertEquals(500.00, oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getPrice())
		    );
		
		assertAll("costPrice",
		        () -> assertEquals(200.00, oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getCostPrice()),
		        () -> assertEquals(200.00, oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getCostPrice())
		    );
		
		assertAll("msrp",
		        () -> assertEquals(500.00, oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getMsrp()),
		        () -> assertEquals(500.00, oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getMsrp())
		    );
		
		assertAll("stockKeepingUnit",
		        () -> assertEquals(5, oc.getOrder().getOrderLineByProductBarcode("1").getProduct().getStockKeepingUnit()),
		        () -> assertEquals(5, oc.getOrder().getOrderLineByProductBarcode("2").getProduct().getStockKeepingUnit())
		    );
		
		
		
		
		
		
	}

}

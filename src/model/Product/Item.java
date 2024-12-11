package model.Product;

/**
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 */
public class Item {

	private String serialNo;
	private AdvancedProduct advancedProduct;
	
	public Item(String serialNo, AdvancedProduct advancedProduct) {
		
		this.serialNo = serialNo;
		this.advancedProduct = advancedProduct;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public AdvancedProduct getAdvancedProduct() {
		return advancedProduct;
	}

	public void setAdvancedProduct(AdvancedProduct advancedProduct) {
		this.advancedProduct = advancedProduct;
	}
	
	
	
}

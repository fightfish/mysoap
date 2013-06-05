package movement;

import data.CompanyId;
import service.ProductService;
import interfaces.CompanyInfoDefinition;

public class WatchCompanyAllProductMove implements CompanyInfoDefinition{

	CompanyId companyId;
	ProductService productService;
	
	public WatchCompanyAllProductMove(byte[] by){
		
		productService = new ProductService();
		companyId = new CompanyId(by);
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		return productService.getProductByCompany(companyId).serialize();
	}

}

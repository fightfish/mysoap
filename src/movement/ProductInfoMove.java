package movement;

import data.CodeAndCompanyId;
import data.ProductData;
import service.ProductService;
import interfaces.CompanyInfoDefinition;

public class ProductInfoMove implements CompanyInfoDefinition{

	ProductData pData;
	ProductService productService;
	CodeAndCompanyId codeAndCompanyId;
	
	public ProductInfoMove(byte[] by){
		
		productService = new ProductService();
		codeAndCompanyId = new CodeAndCompanyId(by);
	}
	
	public byte[] getResult() {
		return productService.getProduct(codeAndCompanyId).serialize();
		// TODO Auto-generated method stub
	}

}

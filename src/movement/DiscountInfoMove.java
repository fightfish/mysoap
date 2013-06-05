package movement;

import java.util.List;

import service.DiscountService;
import service.ProductService;
import data.DiscountData;
import exdatas.AcknowlegeData;
import interfaces.CompanyInfoDefinition;

public class DiscountInfoMove implements CompanyInfoDefinition{
	
	
	DiscountData dd;
	DiscountService ds;
	
	ProductService productService;
	
	public DiscountInfoMove(byte[] by){
		dd = new DiscountData(by);
		ds = new DiscountService();
		
		productService = new ProductService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		String disid = "";
		switch (dd.getType()) {
		case 1:
			if ((disid = ds.addSingleDiscount(dd)) == null) return new AcknowlegeData(false).serialize();
			break;
		case 2:
			if ((disid = ds.addExceedNumDiscount(dd)) == null) return new AcknowlegeData(false).serialize();
			break;
		case 3:
			if ((disid = ds.addMultiDiscount(dd)) == null) return new AcknowlegeData(false).serialize();
			break;
		case 4:
			if ((disid = ds.addExceedPriceDiscount(dd)) == null) return new AcknowlegeData(false).serialize();
			break;
		default:
			break;
		}
		
		List<String> code = dd.getCode();
		for (int i = 0; i < code.size(); i++)
			productService.addDiscount(code.get(i), dd.getIdentify(), disid, dd.getType());
			
		return new AcknowlegeData(true).serialize();
	}

	
}

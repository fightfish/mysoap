package movement;

import interfaces.CollectRowDefinition;
import service.ProductTypeService;
import data.CompanyId;
import exdatas.ProductTypeListData;

public class CollectRowMove implements CollectRowDefinition{
	
	CompanyId ci;
	ProductTypeService us;
	
	public CollectRowMove(byte[] by){
		ci = new CompanyId(by);
		us = new ProductTypeService();
	}
	
	public byte[] getResult(){
		
		ProductTypeListData ptld = new ProductTypeListData(us.getType(ci));
		
		return ptld.serialize();
	}
}

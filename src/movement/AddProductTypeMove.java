package movement;

import service.ProductTypeService;
import interfaces.AddProductTypeDefinition;
import data.ProductTypeData;
import exdatas.AcknowlegeData;

public class AddProductTypeMove implements AddProductTypeDefinition{

	ProductTypeData pd;
	ProductTypeService pts;
	
	public AddProductTypeMove(byte[] by){
		pd = new ProductTypeData(by);
		pts = new ProductTypeService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		return new AcknowlegeData(pts.addType(pd)).serialize();
	}
}

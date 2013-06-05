package movement;

import interfaces.StorageDefinition;
import service.ProductService;
import service.SubbranchService;
import data.StoreData;
import exdatas.AcknowlegeData;

public class StoreScanMove implements StorageDefinition{

	StoreData sData;
	ProductService ps;
	
	public StoreScanMove(byte[] by){
		sData = new StoreData(by);
		ps = new ProductService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		
		String comid = new SubbranchService().getCompanyId(sData.getSubbranchId().getId());
		
		if (ps.getProduct(sData.getCode(), comid) == null)
			return new AcknowlegeData(true).serialize();
		return new AcknowlegeData(false).serialize();
	}
}

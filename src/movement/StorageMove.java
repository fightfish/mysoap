package movement;

import interfaces.StorageDefinition;
import service.ProductService;
import service.StoreService;
import service.SubbranchService;
import data.AddProductData;
import data.AddStoreData;
import exdatas.AcknowlegeData;

public class StorageMove implements StorageDefinition{
	
	AddProductData pData;
	
	ProductService ps;
	StoreService ss;
	
	public StorageMove(byte[] by){
		
		pData = new AddProductData(by);
		
		ps = new ProductService();
		ss = new StoreService();
		
	}
	
	public byte[] getResult(){
		AddStoreData asd = pData.getStoreData();
		
		asd.setCode(pData.getCode());
		if (!pData.getName().equals("")){
			if (!ps.addProduct(pData.getProduct()))
				return new AcknowlegeData(false).serialize();
		} else{
			String comid = new SubbranchService().getCompanyId(pData.getSubbranch());
			if (ps.getProduct(pData.getCode(), comid) == null)
				return new AcknowlegeData(false).serialize();
		}
		return new AcknowlegeData(ss.addStoreCount(asd)).serialize();
	}
}
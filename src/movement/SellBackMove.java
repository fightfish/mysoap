package movement;

import interfaces.SellBackDefinition;
import service.StoreService;
import data.AddStoreData;
import exdatas.AcknowlegeData;

public class SellBackMove implements SellBackDefinition{

	AddStoreData m;
	StoreService ps;
	
	public SellBackMove(byte[] by){
		m = new AddStoreData(by);
		
		ps = new StoreService();
	}
	
	public byte[] getResult(){
		return new AcknowlegeData(ps.backProduct(m)).serialize();
	}
}
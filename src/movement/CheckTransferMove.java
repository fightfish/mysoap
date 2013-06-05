package movement;

import service.StoreRecordService;
import data.StoreRecordId;
import exdatas.AcknowlegeData;
import interfaces.StorageTransferDefinition;

public class CheckTransferMove implements StorageTransferDefinition{

	StoreRecordId ri;
	StoreRecordService srs;
	
	public CheckTransferMove(byte[] by){
		ri = new StoreRecordId(by);
		srs = new StoreRecordService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		return srs.getStoreOrder(ri).serialize();
	}
}
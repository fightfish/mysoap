package movement;

import java.util.List;

import interfaces.StorageTransferDefinition;
import service.StoreRecordService;
import service.StoreService;
import data.AddStoreData;
import data.StoreOrder;
import data.StoreRecordDetail;
import data.StoreRecordId;
import exdatas.AcknowlegeData;

public class FinishTransferMove implements StorageTransferDefinition{

	StoreRecordId ri;
	StoreRecordService srs;
	StoreService ss;
	
	public FinishTransferMove(byte[] by){
		ri = new StoreRecordId(by);
		srs = new StoreRecordService();
		ss = new StoreService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		if (ri.getId().equals("")) return new AcknowlegeData(false).serialize();
		
		StoreOrder storeOrder = srs.getStoreOrder(ri);
		
		if (storeOrder == null) return new AcknowlegeData(false).serialize();
		
		if (storeOrder.getIsArrive() == 1) return new AcknowlegeData(false).serialize();
		
		storeOrder.setIsArrive(1);
		
		new StoreRecordService().setIsArrive(ri.getId());
		
		AddStoreData ad = new AddStoreData();
		
		ad.setSubbranch(storeOrder.getToSubbranch());
		List<StoreRecordDetail> list = storeOrder.getDetail();
		
		for (int i = 0; i < list.size(); i++){
			ad.setCode(list.get(i).getCode());
			ad.setStoreNum(list.get(i).getCount());
			ad.setSize(list.get(i).getSize());
			ss.addStoreCount(ad);
		}
		
		return new AcknowlegeData(true).serialize();
	}
}
package movement;

import interfaces.StorageTransferDefinition;

import java.util.List;

import service.StoreRecordService;
import service.StoreService;
import service.SubbranchService;
import service.UserService;
import data.AddStoreData;
import data.StoreOrder;
import data.StoreRecordDetail;
import data.SubbranchKeyData;
import exdatas.AcknowledgeDataOrderId;


public class StorageTransferMove implements StorageTransferDefinition{

	StoreOrder so;
	StoreRecordService srs;
	StoreService ss;
	
	
	public StorageTransferMove(byte[] by){
		so = new StoreOrder(by);
		
		srs = new StoreRecordService();
		
		ss = new StoreService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		String store = so.getStoreRecord().getToSubbranchName();
		
		String com = new UserService().getCompanyId(so.getUsername());
		so.setToSubbranch(new SubbranchService().getSubbranch(new SubbranchKeyData(store, com)));
		String orderid = srs.addStoreRecord(so.getStoreRecord());
		AcknowledgeDataOrderId ack = new AcknowledgeDataOrderId(false, orderid);
		if (orderid.equals("")) return ack.serialize();
		List<StoreRecordDetail> list = so.getDetail();
		AddStoreData ad = new AddStoreData();
		ad.setSubbranch(so.getFromSubbranch());
		
		for (int i = 0; i < list.size(); i++){
			ad.setCode(list.get(i).getCode());
			ad.setStoreNum(list.get(i).getCount());
			ad.setSize(list.get(i).getSize());
			ss.outStore(ad);
			
			list.get(i).setRecordId(orderid);
			System.out.println("detail: " + list.get(i).toString());
			srs.setDetail(list.get(i));
		}
		
		ack.setAck(true);
		return ack.serialize();
	}
}
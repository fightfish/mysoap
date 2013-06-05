package movement;

import java.util.List;

import interfaces.SellDefinition;

import service.SalesRecordService;
import service.StoreService;
import data.AddStoreData;
import data.SalesOrder;
import data.SalesRecordDetail;
import data.SalesRecordTotalData;
import exdatas.AcknowlegeData;

public class SellMove implements SellDefinition{

	SalesOrder sData;
	
	SalesRecordService srs;
	
	StoreService ss;
	
	public SellMove(byte[] by){
		
		sData = new SalesOrder(by);
		
		srs = new SalesRecordService();
		
		 ss = new StoreService();
	}
	
	public byte[] getResult(){
		double tot = 0;
		List<SalesRecordDetail> lsd = sData.getDetail().getSalesDetail();
		
		String id = lsd.get(0).getRecord();
		
		SalesRecordTotalData srtData = sData.getSalesRecord();
		
		srtData.setId(id);
		
		String subbranch = sData.getSubbranch();
		
		for (int i = 0; i < lsd.size(); i++){
			
			tot += lsd.get(i).getTotal();
			
			ss.sellProduct(new AddStoreData(lsd.get(i).getCode(), subbranch,
					lsd.get(i).getSize(), lsd.get(i).getCount()));
		}
		
		srtData.setTotal(tot);
		//srtData.setSubbranch(sData.getSubbranch());
		
		if (srs.setTotalCost(srtData)) return new AcknowlegeData(true).serialize();
		
		return new AcknowlegeData(false).serialize();
	}
	
}

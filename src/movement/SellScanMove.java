package movement;

import interfaces.SellDefinition;

import java.util.List;

import service.ProductService;
import service.SalesDetailService;
import service.SalesRecordService;
import service.UserService;

import data.ProductData;
import data.SalesOrder;
import data.SalesRecordDetail;
import discount.Discount;

public class SellScanMove implements SellDefinition{

	SalesOrder sData;
	
	SalesRecordService srs;
	
	SalesDetailService salesDetailService;
	
	public SellScanMove(byte[] by){
		
		sData = new SalesOrder(by);
		srs = new SalesRecordService();
		salesDetailService = new SalesDetailService();
	}
	
	public byte[] getResult(){
		List<SalesRecordDetail> lsd = sData.getDetail().getSalesDetail();
		
		if (sData.getIndex() == 0){
			String barcode = sData.getBarCode();
			
			SalesRecordDetail srd = new SalesRecordDetail();
			srd.setCode(barcode);
			srd.setCount(1);
			srd.setSize(sData.getSize());
			
			String com = new UserService().getCompanyId(sData.getUser());
			
			ProductData productData = new ProductService().getProduct(barcode, com);
			
			srd.setProductName(productData.getName());
			srd.setPrice(productData.getPrice());
			if (lsd.size() == 0)
				srd.setRecord(srs.addSalesRecord(sData.getSalesRecord()));
			else
				srd.setRecord(lsd.get(0).getRecord());
			
			salesDetailService.addDetail(srd);
			
			
			lsd.add(srd);
		} else
		if (sData.getIndex() > 0){
			SalesRecordDetail s = lsd.get(sData.getIndex() - 1);
			salesDetailService.deleteDetail(s.getCode(), s.getRecord(), s.getSize());
			lsd.remove(sData.getIndex() - 1);
		}
		
		return new Discount(sData.getSubbranch(), sData.getDetail()).getOrderToSerizalize();
	}
}
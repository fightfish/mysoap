package discount;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import service.GetDiscount;
import service.ProductService;
import service.SalesDetailService;
import service.SubbranchService;
import data.MultiDiscountData;
import data.SalesDetailList;
import data.SalesRecordDetail;

public class Discount {
	
	SalesDetailList data;
	
	GetDiscount getDiscount;
	
	List<SalesRecordDetail> list;
	String subbranch;
	String companyid;
	MultiDiscountData d3;
	
	SalesDetailService salesDetailService;
	
	public Discount(String s, SalesDetailList m){
		companyid = new SubbranchService().getCompanyId(s);
		subbranch = s;
		data = m;
		list = m.getSalesDetail();
		salesDetailService = new SalesDetailService();
	}
	
	public byte[] getOrderToSerizalize(){
		
		double d1, d2;
		SalesRecordDetail salesRecordDetail;
		
		ArrayList<String> id  = new ArrayList<String>();
		ArrayList<ArrayList<Integer>> loc = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tot = new ArrayList<Integer>();
		ArrayList<Double> dis = new ArrayList<Double>();
		
		getDiscount = new ProductService();
		
		for (int j = 0; j < list.size(); j++){
			salesRecordDetail = list.get(j);
			System.out.println(salesRecordDetail.getCode() + "___" + companyid);
			d1 = getDiscount.getSingle(salesRecordDetail.getCode(), companyid);
			d2 = getDiscount.getRepeat(salesRecordDetail.getCode(), companyid);
			d3 = getDiscount.getMultiple(salesRecordDetail.getCode(), companyid);
			if (d1 > 0){
				salesRecordDetail.setIsDiscount(1);
				salesRecordDetail.setTotal(salesRecordDetail.getCount() * salesRecordDetail.getPrice() * d1);
			} else if (d2 > 0){
				salesRecordDetail.setIsDiscount(1);
				int zheng = salesRecordDetail.getCount() / (int)d2;
				d2 = d2 - zheng;
				salesRecordDetail.setTotal((salesRecordDetail.getCount() - zheng) *
						salesRecordDetail.getPrice() + zheng * salesRecordDetail.getPrice() * d2);
			} else if (d3 != null){
				boolean che = true;
				int k = 0;
				while (k < id.size())
					if (d3.getId().equals(id.get(k))){
						loc.get(k).add(j);
						che = false;
						break;
					} else k++;
				if (che){
					id.add(d3.getId());
					tot.add(d3.getNum());
					dis.add(d3.getDis());
					ArrayList<Integer> x = new ArrayList<Integer>();
					x.add(j);
					loc.add(x);
				}
			} else
				salesRecordDetail.setTotal(salesRecordDetail.getCount() * salesRecordDetail.getPrice());
			salesDetailService.updateDetail(salesRecordDetail);
		}
		
		for (int k = 0; k < loc.size(); k++)
			if (loc.get(k).size() == tot.get(k)){
				for (int j = 0; j < loc.get(k).size(); j++){
					salesRecordDetail = list.get(loc.get(k).get(j));
					salesRecordDetail.setIsDiscount(1);
					salesRecordDetail.setTotal(salesRecordDetail.getCount() *
							salesRecordDetail.getPrice() * dis.get(k));

					salesDetailService.updateDetail(salesRecordDetail);
				}
			} else{
				for (int j = 0; j < loc.get(k).size(); j++){
					salesRecordDetail = list.get(loc.get(k).get(j));
					salesRecordDetail.setIsDiscount(1);
					salesRecordDetail.setTotal(salesRecordDetail.getCount() *
							salesRecordDetail.getPrice());

					salesDetailService.updateDetail(salesRecordDetail);
					
				}
			}
		

		double total = 0;
		for (int j = 0; j < list.size(); j++){
			salesRecordDetail = list.get(j);
			total += salesRecordDetail.getTotal();
		}
		
		
		Map<Double, Double> map = null;//getDiscount.getFull(subbranch);
		System.out.println(subbranch);
		
		if (map != null){
			Double[] dou = (Double[]) map.keySet().toArray();
			
			int k;
			for (k = 0; k < dou.length; k++)
				if (dou[k] < total) break;
			
			if (k < dou.length)
				total -= map.get(dou[k]);
		}
		
		data.setTotal(total);
		
		return data.serialize();
	}
}
package webservice;

import model.WatchModel;
import interfaces.DataHand;

public class SellRecord {
	
	public WatchModel input(DataHand model){
		return sellrecord(model);
	}
	
	private WatchModel sellrecord(DataHand model){
		WatchModel answer = new WatchModel();
		
		answer.setString1("Íà×Ó$100.0#Ð¬×Ó$50.3#¿ã×Ó$201#");
		
		
		
		
		return answer;
	}
}

package webservice;

import model.WatchModel;
import interfaces.DataHand;

public class SellRecord {
	
	public WatchModel input(DataHand model){
		return sellrecord(model);
	}
	
	private WatchModel sellrecord(DataHand model){
		WatchModel answer = new WatchModel();
		
		answer.setString1("����$100.0#Ь��$50.3#����$201#");
		
		
		
		
		return answer;
	}
}

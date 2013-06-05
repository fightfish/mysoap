package movement;

import data.IdentifyRecentSum;
import interfaces.StatisticDefinition;
import service.StatisticsService;

public class StatisticCompanyMove implements StatisticDefinition{

	IdentifyRecentSum i;
	
	public StatisticCompanyMove(byte[] by){
		i = new IdentifyRecentSum(by);
	}

	public byte[] getResult() {
		// TODO Auto-generated method stub
		return new StatisticsService().getIdentifySum(i).serialize();
	}
}

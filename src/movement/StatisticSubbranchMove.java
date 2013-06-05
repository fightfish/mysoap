package movement;

import interfaces.StatisticDefinition;
import service.StatisticsService;
import data.CompanyMemberSum;

public class StatisticSubbranchMove implements StatisticDefinition{

	CompanyMemberSum i;
	
	public StatisticSubbranchMove(byte[] by){
		i = new CompanyMemberSum(by);
	}

	public byte[] getResult() {
		// TODO Auto-generated method stub
		return new StatisticsService().getSubbranchSum(i).serialize();
	}
}

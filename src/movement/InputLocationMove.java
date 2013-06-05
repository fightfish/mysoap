package movement;

import service.SubbranchService;
import data.SubbranchLocation;
import exdatas.AcknowlegeData;
import interfaces.CompanyInfoDefinition;

public class InputLocationMove implements CompanyInfoDefinition{

	SubbranchLocation sl;
	
	SubbranchService ss;
	
	public InputLocationMove(byte[] by){
		sl = new SubbranchLocation(by);
		ss = new SubbranchService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		
		if (ss.updateSubbranch(sl)) return new AcknowlegeData(true).serialize();
		
		return new AcknowlegeData(false).serialize();
	}
}
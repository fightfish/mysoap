package movement;

import service.SubbranchService;
import data.SubbranchData;
import data.SubbranchId;
import interfaces.CompanyInfoDefinition;

public class SubBranchInfoMove implements CompanyInfoDefinition{

	SubbranchData sb;
	
	SubbranchService ss;
	
	public SubBranchInfoMove(byte[] by){
		sb = new SubbranchData(by);
		
		ss = new SubbranchService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		String id = ss.addSubbranch(sb);
		if (id != null) return new SubbranchId(id).serialize();
		else return new SubbranchId().serialize();
	}

	
}

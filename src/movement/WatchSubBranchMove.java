package movement;

import java.util.ArrayList;
import java.util.List;

import interfaces.CompanyInfoDefinition;
import service.SubbranchService;
import data.CompanyId;
import data.SubbranchList;

public class WatchSubBranchMove implements CompanyInfoDefinition{
	
	CompanyId companyId;
	
	SubbranchService service;
	
	public WatchSubBranchMove(byte[] by){
		
		companyId = new CompanyId(by);
		service = new SubbranchService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		List<String> nameList = service.getSubbranchName(companyId.getId());
		if (nameList == null)
			nameList = new ArrayList<String>();
		List<String> idList = service.getSubbranch(companyId.getId());
		if (idList == null)
			idList = new ArrayList<String>();
		//System.out.println(nameList.toString());
		//System.out.println(idList.toString());
		return new SubbranchList(nameList, idList).serialize();
	}
}
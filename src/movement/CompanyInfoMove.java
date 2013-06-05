package movement;

import service.CompanyService;
import service.UserService;
import data.CompanyData;
import data.CompanyId;
import data.UserNameData;
import interfaces.CompanyInfoDefinition;

public class CompanyInfoMove implements CompanyInfoDefinition{

	CompanyData cd;
	CompanyService cs;
	UserService us;
	
	public CompanyInfoMove(byte[] by){
		cd = new CompanyData(by);
		cs = new CompanyService();
		
		us = new UserService();
	}
	
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		String com = "";
		if (us.getUser(new UserNameData(cd.getBossName())) == null)
			return new CompanyId().serialize();
		else{
			com = cs.addCompany(cd);
			us.updateUser(cd.getBossName(), com);
		}
		return new CompanyId(com).serialize();
	}
}
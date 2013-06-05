package movement;


import interfaces.AddUserDefinition;
import service.UserService;
import service.UserGroupService;
import data.PasswordAndUserGroup;
import data.UserNameListData;
import exdatas.AcknowlegeData;

public class AddUserMove implements AddUserDefinition{

	UserNameListData unl;
	UserService us;
	
	public AddUserMove(byte[] by){
		unl = new UserNameListData(by);
		
		us = new UserService();
	}
	
	public byte[] getResult() {
		// TODO Auto-generated method stub
		boolean check = true;
		PasswordAndUserGroup pug = new PasswordAndUserGroup();
		pug.setUserGroupData(new UserGroupService().getGroup("seller"));
		if (us.getCompanyId(unl.getBossName()).equals(""))
			return new AcknowlegeData(false).serialize();
		
		pug.setCompany(us.getCompanyId(unl.getBossName()));
		
		for (int i = 0; i < unl.getUserNameList().size(); i++){
			pug.setUsername(unl.getUserNameList().get(i));
			pug.setPassword("");
			check = us.addUserName(pug);
		}
		return new AcknowlegeData(check).serialize();
	}

}

package movement;

import interfaces.RegisterDefinition;
import service.UserGroupService;
import service.UserService;
import data.GroupNameData;
import data.PasswordAndUserGroup;
import data.PasswordData;

public class RegisterMove implements RegisterDefinition{
	PasswordAndUserGroup und;
	UserService ls;
	
	public RegisterMove(byte[] by){
		und = new PasswordAndUserGroup(by);
		
		ls = new UserService();
		
	}
	
	public byte[] getResult(){
		if (ls.addUserName(und)){
			GroupNameData gnData = new GroupNameData();
			UserGroupService ugs = new UserGroupService();
			und.setGroupName("boss");
			gnData.setName(und.getGroupName());
			
			und.setUserGroup(ugs.addGroup(gnData));
			gnData.setName("seller");
			ugs.addGroup(gnData);
			
			ls.updateUser(und);
			
		} if (!und.getPassword().equals(""))
			ls.updateUser((PasswordData)und);
		
		und = ls.getUser(und);
		
		UserGroupService ugs = new UserGroupService();
		und.setGroupName(ugs.getGroupName(und.getUserGroup()));
		
		return und.serialize();
	}
}
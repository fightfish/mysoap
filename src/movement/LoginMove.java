package movement;

import service.UserService;
import data.PasswordAndUserGroup;
import interfaces.LoginDefinition;



public class LoginMove implements LoginDefinition{
	PasswordAndUserGroup und;
	UserService ls;
	
	public LoginMove(byte[] by){
		und = new PasswordAndUserGroup(by);
		
		ls = new UserService();
	}
	
	public byte[] getResult(){
		
		return null;
	}
}
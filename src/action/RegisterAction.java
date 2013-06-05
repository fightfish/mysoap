package action;

import model.Usermodel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.Rigister;

public class RegisterAction extends ActionSupport implements
		ModelDriven<Usermodel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usermodel usermodel = new Usermodel();
	

	@Override
	public String execute() throws Exception {

		
		new Rigister(usermodel.username, usermodel.password);

		return "success";
	}

	public Usermodel getModel() {
		// TODO Auto-generated method stub
		return usermodel;
	}

}

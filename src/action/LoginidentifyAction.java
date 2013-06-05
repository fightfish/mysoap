package action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dbconn;

public class LoginidentifyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String success = "success";
	private String failure = "failure";
	private String username;
	private String password;
	private String name;
	private String pass;
	
	
	@Override
	public String execute() throws Exception {
		ResultSet rs = null;

		Dbconn.getConn();

		rs = Dbconn.executeSQL("select * from users");

		
		while (rs.next()) {

			name = rs.getString("username");
			pass = rs.getString("pwd");

			if ((name.equals(username)) && (pass.equals(password))){
				Dbconn.close();
				return success;
			}
		}
		
		Dbconn.close();
		return failure;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public void setPassword(String password) {

		this.password = password;

	}

	public String getPassword() {

		return password;

	}
}

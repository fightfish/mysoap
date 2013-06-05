package model;

import java.util.ArrayList;
import java.util.List;

public class Usermodel {

	public String username;
	public String password;
	public String confirmingpassword;
	public List<String> list;

	public Usermodel() {
		list = new ArrayList<String>();
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		list.add(username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		list.add(password);
	}

}

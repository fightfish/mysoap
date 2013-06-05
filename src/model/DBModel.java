package model;

import interfaces.DataHand;

public class DBModel implements DataHand{
	
	private String username = "";
	private String password = "";
	private String confirmingpassword = "";
	
	private double d = 0;
	
	public String getString1() {
		return username;
	}
	public void setString1(String username) {
		this.username = username;
	}
	public String getString2() {
		return password;
	}
	public void setString2(String password) {
		this.password = password;
	}
	public String getString3() {
		return confirmingpassword;
	}
	public void setString3(String confirmingpassword) {
		this.confirmingpassword = confirmingpassword;
	}
	public void setInt(int i) {
		// TODO Auto-generated method stub
		
	}
	public void setDouble(double f) {
		// TODO Auto-generated method stub
		d = f;
	}
	public int getInt() {
		// TODO Auto-generated method stub
		return 0;
	}
	public double getDouble() {
		// TODO Auto-generated method stub
		return d;
	}
	public void setID(int i) {
		// TODO Auto-generated method stub
		
	}
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

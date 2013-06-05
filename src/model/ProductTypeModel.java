package model;

import interfaces.DataHand;

public class ProductTypeModel implements DataHand{
	
	private String id;
	private String type;
	private String companyid;
	
	public void setString1(String str) {
		// TODO Auto-generated method stub
		id = str;
	}

	public void setString2(String str) {
		// TODO Auto-generated method stub
		type = str;
	}

	public void setString3(String str) {
		// TODO Auto-generated method stub
		companyid = str;
	}

	public String getString1() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getString2() {
		// TODO Auto-generated method stub
		return type;
	}

	public String getString3() {
		// TODO Auto-generated method stub
		return companyid;
	}

	public void setInt(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setDouble(double f) {
		// TODO Auto-generated method stub
		
	}

	public int getInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getDouble() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setID(int i) {
		// TODO Auto-generated method stub
		
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
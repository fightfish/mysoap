package model;

import interfaces.DataHand;

public class HelloData implements DataHand{

	String name1, name2;
	
	public void setString1(String str) {
		// TODO Auto-generated method stub
		name1 = str;
	}

	public void setString2(String str) {
		// TODO Auto-generated method stub
		name2 = str;
	}

	public void setString3(String str1) {
		// TODO Auto-generated method stub
		
	}

	public String getString1() {
		// TODO Auto-generated method stub
		return name1;
	}

	public String getString2() {
		// TODO Auto-generated method stub
		return name2;
	}

	public String getString3() {
		// TODO Auto-generated method stub
		return null;
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

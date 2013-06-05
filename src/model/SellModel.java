package model;

import interfaces.DataHand;

public class SellModel implements DataHand{

	private String barcode = "";
	private String name = "";
	private String type = "";
	private int t = 0;
	private int id = 0;
	private double price = 0;
	
	private String string4 = "";
	private String string5 = "";
	
	
	public String getString5() {
		return string5;
	}

	public void setString5(String string5) {
		this.string5 = string5;
	}

	public String getString4() {
		return string4;
	}
	
	public void setString4(String string4) {
		this.string4 = string4;
	}

	public void setString1(String str) {
		// TODO Auto-generated method stub
		barcode = str;
	}

	public void setString2(String str) {
		// TODO Auto-generated method stub
		name = str;
	}

	public void setString3(String str) {
		// TODO Auto-generated method stub
		type = str;
	}

	public String getString1() {
		// TODO Auto-generated method stub
		return barcode;
	}

	public String getString2() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getString3() {
		// TODO Auto-generated method stub
		return type;
	}

	public void setInt(int i) {
		// TODO Auto-generated method stub
		t = i;
	}

	public void setDouble(double f) {
		// TODO Auto-generated method stub
		price = f;
	}

	public int getInt() {
		// TODO Auto-generated method stub
		return t;
	}

	public double getDouble() {
		// TODO Auto-generated method stub
		return price;
	}

	public void setID(int i) {
		// TODO Auto-generated method stub
		id = i;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	
}

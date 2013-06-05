package model;

import interfaces.DataHand;

public class StorageModel implements DataHand{

	private String barcode = "";
	private String data1 = "";
	private String data2 = "";
	private String string4 = "";
	
	private String string5 = "";
	private String string6 = "";
	
	private int tot = 0;
	private int id = 0;
	
	private long time = 0;
	
	private Double d = 0.0;
	
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getString4() {
		return string4;
	}

	public void setString4(String string4) {
		this.string4 = string4;
	}

	public String getString5() {
		return string5;
	}

	public void setString5(String string5) {
		this.string5 = string5;
	}

	public String getString6() {
		return string6;
	}

	public void setString6(String string6) {
		this.string6 = string6;
	}

	public void setString1(String str) {
		// TODO Auto-generated method stub
		barcode = str;
	}

	public void setString2(String str) {
		// TODO Auto-generated method stub
		data1 = str;
	}

	public void setString3(String str) {
		// TODO Auto-generated method stub
		data2 = str;
	}

	public String getString1() {
		// TODO Auto-generated method stub
		return barcode;
	}

	public String getString2() {
		// TODO Auto-generated method stub
		return data1;
	}

	public String getString3() {
		// TODO Auto-generated method stub
		return data2;
	}

	public void setInt(int i) {
		// TODO Auto-generated method stub
		tot = i;
	}

	public void setDouble(double f) {
		// TODO Auto-generated method stub
		d = f;
	}

	public int getInt() {
		// TODO Auto-generated method stub
		return tot;
	}

	public double getDouble() {
		// TODO Auto-generated method stub
		return d;
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

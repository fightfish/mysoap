package webservice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Dbconn;
import interfaces.DataHand;
import interfaces.SellBackDefinition;

public class SellBack {
	
	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		SellBackDefinition sellbackdefinition = (SellBackDefinition) o;
		return sellbackdefinition.getResult();
	}
	
	
	public String input(DataHand model){
		if (model.getString1() == null) return "failed";
		return sellback(model);
	}
	
	private String sellback(DataHand model){
		String answer = "successed";
		
		String sql = "select * from store";
		Dbconn.getConn();
		try {
			ResultSet rs = Dbconn.executeSQL(sql);
			String barcode;
			if (rs.next())
			do {
				barcode = rs.getString("barcode");

				if (barcode.equals(model.getString1())){
					int t = rs.getInt("remain");
					t++;
					sql = "update store set remain = " + t + " where barcode = '" + barcode + "';";
					Dbconn.updateSQL(sql);
					Dbconn.close();
					return answer;
				}
			} while (rs.next());
			else answer = "failed1";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			answer = "failed2";
		}
		Dbconn.close();
		
		return answer;
	}
}

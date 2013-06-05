package webservice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Dbconn;
import interfaces.DataHand;
import interfaces.SellDefinition;

public class Sell {
	
	
	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		SellDefinition selldefinition = (SellDefinition) o;
		return selldefinition.getResult();
	}
	
	
	public String input(DataHand model){
		if (model.getString1() == null) return "failed";
		return sell(model);
	}
	
	private String sell(DataHand model){
		String answer = "successed";
		
		String sql = "select * from sell";
		Dbconn.getConn();
		try {
			ResultSet rs = Dbconn.executeSQL(sql);
			String barcode;
			if (rs.next())
			do {
				barcode = rs.getString("barcode");

				if (barcode.equals(model.getString1())){
					int t = rs.getInt("sells");
					t++;
					sql = "update sell set sells = " + t + " where barcode = " + barcode + ";";
					Dbconn.updateSQL(sql);
					Dbconn.close();
					return answer;
				}
			} while (rs.next());
			else {
				sql = "insert into sell values('" + model.getString1() + "','0');";
				Dbconn.updateSQL(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			answer = "failed";
		}
		Dbconn.close();
		return answer;
	}
}

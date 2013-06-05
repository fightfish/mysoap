package webservice;

import interfaces.CollectRowDefinition;
import interfaces.DataHand;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Dbconn;

public class CollectRow {
	
	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		CollectRowDefinition collectrowdefinition = (CollectRowDefinition) o;
		return collectrowdefinition.getResult();
	}
	
	
	
	public String input(DataHand model){
		if (model.getString1() == null) return "failed";
		return collectrow(model);
	}
	
	private String collectrow(DataHand model){
		String answer = "";
		
		String sql = "select * from producttype";
		String t = model.getString1();
		Dbconn.getConn();
		try {
			ResultSet rs = Dbconn.executeSQL(sql);
			String type;
			while (rs.next()) {
				type = rs.getString(t);
				answer += (type + "#");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			answer = "failed";
		}

		Dbconn.close();
		
		return answer;
	}
}
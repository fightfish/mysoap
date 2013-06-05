package webservice;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import interfaces.DataHand;
import interfaces.RegisterDefinition;
import dao.Dbconn;

public class Register {
	
	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		RegisterDefinition registerdefinition = (RegisterDefinition) o;
		return registerdefinition.getResult();
	}
	
	
	public String input(DataHand model){
		if ((model.getString1() == null) ||
			(model.getString2() == null) ||
			(model.getString3() == null)) return "failed";
		return register(model);
	}
	
	private String register(DataHand model){
		String answer = "successed";
		
		if (!model.getString2().equals(model.getString3())) return "failed";
		
		String sql = "insert into users values('" + model.getString1() + "','" + model.getString2()
		+ "');";
		Dbconn.getConn();
		try {
			Dbconn.updateSQL(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			answer = "failed";
		}
		Dbconn.close();
		
		return answer;
	}
}

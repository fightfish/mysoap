package webservice;

import interfaces.AddProductTypeDefinition;
import interfaces.DataHand;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import dao.Dbconn;

public class AddProductType {
	
	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		AddProductTypeDefinition addproducttypedefinition = (AddProductTypeDefinition) o;
		return addproducttypedefinition.getResult();
	}
	
	public String input(DataHand model){
		if ((model.getString1() == null) ||
			(model.getString2() == null) ||
			(model.getString3() == null)) return "failed";
		return addType(model);
	}
	
	private String addType(DataHand model){
		String answer = "successed";
		
		String sql = "insert into producttype values('" + model.getString1() + "','" + model.getString2()
		+ "','" + model.getString3() + "');";
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

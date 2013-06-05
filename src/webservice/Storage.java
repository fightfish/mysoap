package webservice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Dbconn;
import interfaces.DataHand;
import interfaces.StorageDefinition;

public class Storage {

	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		StorageDefinition storagedefinition = (StorageDefinition) o;
		return storagedefinition.getResult();
	}
	
	
	public String input(DataHand model){
		if (model.getString1() == null) return "failed";
		return storage(model);
	}
	
	private String storage(DataHand model){
		String answer = "successed";
		
		String sql = "select * from store where barcode = '" + model.getString1() + "'";
		
		Dbconn.getConn();
		
		try {
			ResultSet rs = Dbconn.executeSQL(sql);
			if ((rs.next()) && (model.getString2() == null)){
				Dbconn.close();
				return answer;
			} else if (model.getString2() == null) return "mustadd";
		
			
			if (model.getString2().equals("add")){
				int t = rs.getInt("remain") + Integer.parseInt(model.getString3());
				sql = "update store set remain = " + t + " where barcode = '" + model.getString1() + "';";
				Dbconn.updateSQL(sql);
				Dbconn.close();
				return answer;
			} else {
				sql = "insert into store values(" + model.getString2() + ");";
				Dbconn.updateSQL(sql);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			answer = "failed2";
		}
		
		Dbconn.close();
		return answer;
	}
}

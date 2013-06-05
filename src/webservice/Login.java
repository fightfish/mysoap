package webservice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Dbconn;
import interfaces.DataHand;
import interfaces.LoginDefinition;

public class Login {
	
	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		LoginDefinition logindefinition = (LoginDefinition) o;
		
		return logindefinition.getResult();
	}
	
	public String input(DataHand model){
		if ((model.getString1() == null) ||
			(model.getString2() == null)) return "failed";
		return login(model);
	}
	
	private String login(DataHand model){
		String answer = "successed";
		
		String sql = "select * from users";
		Dbconn.getConn();
		try {
			ResultSet rs = Dbconn.executeSQL(sql);
			String name;
			String pass;
			while (rs.next()) {
				name = rs.getString("username");
				pass = rs.getString("pwd");

				if ((name.equals(model.getString1())) && (pass.equals(model.getString2()))){
					Dbconn.close();
					return answer;
				}
			}
			answer = "failed";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			answer = "failed";
		}

		Dbconn.close();
		return answer;
	}
}

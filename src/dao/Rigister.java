package dao;

import java.sql.SQLException;

public class Rigister {

	public Rigister(String name, String password) {

		String sql = "insert into users values('" + name + "','" + password
				+ "');";

			Dbconn.getConn();

		try {
			Dbconn.updateSQL(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Dbconn.close();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rigister("qweq", "43242");
		
	}
}

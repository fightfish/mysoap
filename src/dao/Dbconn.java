package dao;

import java.sql.*; //��ɻ������ã�����java.sql��

public final class Dbconn {

	// declare variable
	static private Connection conn = null;
	static private ResultSet rs = null;
	static private String server = "127.0.0.1"; // Can't use localhost , you must use
	// IP or CNAME
	static private String port = "3306"; // change to your port
	static private String db = "mysoap"; // change to your db name
	static private String user = "root"; // change to your username
	static private String pass = "329"; // change to your password
	static private String drivername = "org.gjt.mm.mysql.Driver"; // mysql driver
	static private String URL = "jdbc:mysql://" + server + ":" + port + "/" + db
			+ "?useUnicode=true&characterEncoding=GBK&user=" + user
			+ "&password=" + pass;

	public static void getConn(){ // get database connection
			try {
				Class.forName(drivername).newInstance(); // ����������
				conn = DriverManager.getConnection(URL);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ���ӵ����ݿ�
	}
	
	public static void close(){
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	public static void updateSQL(String str) throws SQLException{
		Statement stmt;
		stmt = conn.createStatement();
		stmt.execute(str);
	}
	
	public static ResultSet executeSQL(String str) throws SQLException{
		Statement stmt = conn.createStatement(); // ���ӿ�
		rs = stmt.executeQuery(str); // ��ý����
		return rs;
	}
}

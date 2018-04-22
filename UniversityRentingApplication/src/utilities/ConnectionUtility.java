package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
	public static Connection getConnection(ConnectionData data) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return con;
	}
}

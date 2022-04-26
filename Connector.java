package ConLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Connector {
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String HOST = "";
	final int PORT = 3306;
	final String DATABASE = "Sample";
	final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
	final String USER = "root";
	final String PASS = "";

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);

		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return conn;
	}
	

}

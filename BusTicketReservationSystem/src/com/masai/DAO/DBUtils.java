package com.masai.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getConnectionFromHere() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
//		ResourceBundle rs = ResourceBundle.getBundle("db");
		return DriverManager.getConnection("jdbc:mysql://localhost/busticketreservationsystem", "root", "root");
	}
	
	public static void closeConnection(Connection conn) throws SQLException {
		if(conn != null) conn.close();
	}
	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			return true;
		}
		return false;
	}
}

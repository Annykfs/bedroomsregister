package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BedroomConnection {
		
	public static Connection doConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		 Connection con = null;
		 String nameDB = "bedroomsdata";
		 String url = "jdbc:mysql://localhost:3306/" + nameDB;
		 String userName = "root";
		 String psswrd = "";

				Class.forName("com.mysql.jdbc.Driver").newInstance();

				try {	
					 con = (Connection) DriverManager.getConnection(url, userName, psswrd);
					 if (con != null)
							System.out.println("well succeed connection!");	
					} catch (Exception exce) {
							System.out.println("oops! something went wrong.");
					}
				return (Connection) con;
	}
	
	public static void closeConnection(Connection con) {
		try {
			if (con != null)
				con.close();
				System.out.println("the connection has been closed.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(ResultSet reSet) {
		try {
			if (reSet != null)
				reSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

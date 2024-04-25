package conDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c=null;
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url="jdbc:mySQL://localhost:3306/bookstore";
			String user="root";
			String password="";
			c=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.print("\nket noi khong thanh cong\n");
			e.printStackTrace();
		} 
		
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				System.out.print("\nda dong ket noi\n");
				c.close();
			}
		}
		catch(Exception e) {
			
		}
	}
	
}

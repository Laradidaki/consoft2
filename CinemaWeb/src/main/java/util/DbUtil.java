package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}else {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/cinema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url,"root","");
			} catch (ClassNotFoundException e) {
				System.out.println("errore con class.forName");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("errore con getConnection");
				e.printStackTrace();
			}
			
			return connection;
		}
	}
}

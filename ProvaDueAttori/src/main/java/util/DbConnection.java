package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DbConnection {

	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		//INIZIO PARTE MODIFICATA DA ANDREA PER EVITARE DI CREARE E CARICARE IL FILE .PROPERTIES
		
		if (connection != null) {
			return connection;
		}else {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/cinema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
			//FINE PARTE MODIFICATA DA ANDREA
			
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
	
//private void esSelect(String nomeAttore) throws SQLException {
//		
//		String sql= "SELECT nomeAttore, cognomeAttore FROM attore WHERE nomeAttore = '"+nomeAttore+"'";
//		
//		//String sql2="SELECT nomeAttore, cognomeAttore FROM attore WHERE nomeAttore = ?";
//		
//		PreparedStatement ps= getConnection().prepareStatement(sql);
//		
//		//ps.setString(1, "Tom");
//		
//		ResultSet rs=ps.executeQuery();
//		
//		while(rs.next()) {
//			
//			
//			System.out.println("nomeAttore= "+ rs.getString(1));
//			System.out.println("cognomeAttore= "+ rs.getString(2));
//			/*System.out.println("nomeFilm= "+ rs.getString(3));
//			System.out.println("nomeRegista= "+ rs.getString(4));
//			System.out.println("cognomeRegista= "+ rs.getString(5));
//			System.out.println("anno= "+ rs.getInt(6));
//			System.out.println("nomeGenere= "+ rs.getString(7));
//			System.out.println("-------------------------------");
//			*/
//			
//			getConnection().close();
//		}
//		
//	}
//	
	  public static void main( String[] args ) {
		  DbConnection.getConnection();
		 if(connection!=null) {
			 System.out.println("connessione stabilita");
		 }
//			try {
//				//System.out.println(provaDb.getConnection().isClosed());
//				dbcon.esSelect("Tom");
//				//provaDb.esInsert("John", "Travolta",65);
//				//provaDb.esUpdate();
//				//provaDb.esDelete();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
     }
}

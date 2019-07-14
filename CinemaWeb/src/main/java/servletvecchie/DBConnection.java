package servletvecchie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mariadb.jdbc.MySQLDataSource;


public class DBConnection {
	
	Connection connection;
	Statement statement;
	ResultSet resultset;
	String sql;
	
	public static void main(String[] args) {

		DBConnection dbcon= new DBConnection();
		try {
			//System.out.println(provaDb.getConnection().isClosed());
			//provaDb.esSelect("Tom");
			//provaDb.esInsert("John", "Travolta",65);
			dbcon.select();
			//provaDb.esDelete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	protected void select() throws SQLException {
		    statement= getConnection().createStatement();
			resultset=statement.executeQuery("select* from film");
			System.out.println("------------------------------------------------------------------");
			
			while(resultset.next()) {
				
				System.out.println(""+resultset.getString(1));
				System.out.println(""+resultset.getString(2));
				System.out.println(""+resultset.getString(3));
				System.out.println(""+resultset.getString(4));
				System.out.println(""+resultset.getString(5));
				System.out.println("-----------------------");
			
				getConnection().close();
			}
			
	
	}
	
	public ResultSet getResult(String sql, Connection connection) {
		this.connection=connection;
		try {
			statement=connection.createStatement();
			resultset=statement.executeQuery(sql);
		}
		catch(Exception e) {
			System.out.println("C'è un errore");
		}
		return resultset;
	}
	

	public Connection getConnection() throws SQLException {
		
		if(connection==null) {
			MySQLDataSource dataSource= new MySQLDataSource();
			dataSource.setDatabaseName("cinema");
			dataSource.setPortNumber(3306);
			dataSource.setServerName("127.0.0.1");
			dataSource.setUser("root");
			dataSource.setPassword("");
			
			connection= dataSource.getConnection();
			System.out.println("connessione stabilita");
		}
		
		return connection;
	}

}

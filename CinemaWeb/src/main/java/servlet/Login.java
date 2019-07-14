package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletvecchie.DBConnection;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String query;
	Connection connection;
	ResultSet resultSet;
	DBConnection dbcon;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String dbUser=null;
			String dbPass=null;
			query="select username,password from utente where username=? and password=?";
			dbcon= new DBConnection();
			connection=dbcon.getConnection();
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			resultSet=dbcon.getResult(query, connection);
			resultSet=ps.executeQuery();
		
			
			while(resultSet.next()) {
				
				dbUser=resultSet.getString(1);
				dbPass=resultSet.getString(2);
				
			}
		
			if(username.equals(dbUser)&& password.equals(dbPass)) {
				RequestDispatcher rd= request.getRequestDispatcher("/loginValido.jsp");
				rd.forward(request, response);
			}
			
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}
			
			
				
		}
		catch(Exception e){
			
			RequestDispatcher rd= request.getRequestDispatcher("/loginNonValido.jsp");
			rd.forward(request, response);
		}
	}

}

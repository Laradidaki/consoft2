package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Attore;
import model.Utente;
import servletvecchie.DBConnection;


@WebServlet("/registrazione")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	Connection connection;
	Statement statement;
	DBConnection dbcon;
	List<Attore> lista=new ArrayList<Attore>();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String sql="insert into utente(nome, cognome, username, password) values(?,?,?,?)";
			dbcon= new DBConnection();
			connection=dbcon.getConnection();

			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.executeUpdate();
			
			request.getRequestDispatcher("confermaRegistrazione.jsp").forward(request, response);
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
		

}

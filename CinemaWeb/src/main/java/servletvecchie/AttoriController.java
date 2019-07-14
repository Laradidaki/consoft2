package servletvecchie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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



@WebServlet("/listaattori")
public class AttoriController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String query;
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	DBConnection dbcon;
	List<Attore> lista=new ArrayList<Attore>();
	
	


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html");
    	PrintWriter out= response.getWriter();
		try {
			dbcon= new DBConnection();
			connection=dbcon.getConnection();
			statement=connection.createStatement();
			query="select * from attore";
			resultSet=dbcon.getResult(query, connection);
		
			
			while(resultSet.next()) {
				Attore a= new Attore();
				a.setIdAttore(resultSet.getInt(1));
				a.setNomeAttore(resultSet.getString(2));
				a.setCognomeAttore(resultSet.getString(3));
				a.setEtaAttore(resultSet.getInt(4));
				lista.add(a);
			}
		
			
			resultSet.close();
			request.setAttribute("listaattori", lista);
			request.getRequestDispatcher("/listaAttori.jsp").forward(request, response);
				
		}
		catch(Exception e){
			
			RequestDispatcher rd= request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		finally {
		
			lista.clear();
			out.close();
			
		}
	}
	

	
}

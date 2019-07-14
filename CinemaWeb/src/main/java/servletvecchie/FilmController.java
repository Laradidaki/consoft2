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

import model.Film;

/**
 * Servlet implementation class FilmController
 */
@WebServlet("/listafilm")
public class FilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String query;
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	DBConnection dbcon;
	List<Film> lista2=new ArrayList<Film>();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html");
    	PrintWriter out= response.getWriter();
		try {
			dbcon= new DBConnection();
			connection=dbcon.getConnection();
			statement=connection.createStatement();
			query="select idFilm, nomeFilm from film";
			resultSet=dbcon.getResult(query, connection);
		
			
			while(resultSet.next()) {
				Film f= new Film();
				f.setIdFilm(resultSet.getInt(1));
				f.setNomeFilm(resultSet.getString(2));
				lista2.add(f);
			}
		
			
			resultSet.close();
			request.setAttribute("listafilm", lista2);
			request.getRequestDispatcher("/listaFilm.jsp").forward(request, response);
				
		}
		catch(Exception e){
			
			RequestDispatcher rd= request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		finally {
		
			lista2.clear();
			out.close();
			
		}
	}
	

}

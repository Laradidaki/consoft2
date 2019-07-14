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


@WebServlet("/aggiungifilm")
public class AggiungiFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String query;
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	DBConnection dbcon;
	List<String> lista=new ArrayList<String>();
	


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html");
    	String id= request.getParameter("idFilm");
		String titolo= request.getParameter("titoloFilm");
		String durata= request.getParameter("durataFilm");
		String anno= request.getParameter("annoFilm");
		String costo= request.getParameter("costoFilm");
    	PrintWriter out= response.getWriter();
		try {
			dbcon= new DBConnection();
			connection=dbcon.getConnection();
			statement=connection.createStatement();
			query="INSERT INTO film (idFilm, nomeFilm, durataFilm, annoFilm, costoFilm)"
					+ " VALUES('"+id+"','"+titolo+"','"+durata+"','"+anno+"','"+costo+"')";
			statement.executeUpdate(query);
		
			
		connection.close();
				
		}
		catch(Exception e){
			
			RequestDispatcher rd= request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		finally {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/listafilm"));
			lista.clear();
			out.close();
			
		}
	}
}

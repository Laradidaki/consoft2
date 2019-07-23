package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttoreDao;
import model.Attore;

@WebServlet("/elencoAttori")
public class ListaAttori extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		AttoreDao att = new AttoreDao();
		List<Attore>attori = att.getAllAttori();
		request.setAttribute("elencoAttori", attori);
		request.getRequestDispatcher("/listaAttori.jsp").forward(request, response);
	}

}

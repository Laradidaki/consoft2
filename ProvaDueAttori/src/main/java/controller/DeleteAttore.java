package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttoreDao;

/**
 * Servlet implementation class DeleteAttore
 */
@WebServlet("/deleteAttore")
public class DeleteAttore extends HttpServlet {
	private static final long serialVersionUID = 1L;
		       
			
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int idAttore=Integer.parseInt((String)request.getParameter("idAttore"));
				AttoreDao attoreDao= new AttoreDao();
				attoreDao.deleteAttore(idAttore);
				response.sendRedirect(response.encodeRedirectURL("elencoAttori"));
			}

		
	}
	



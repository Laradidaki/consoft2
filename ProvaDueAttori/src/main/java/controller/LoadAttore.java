package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttoreDao;
import model.Attore;

/**
 * Servlet implementation class LoadAttore
 */
@WebServlet("/loadAttore")
public class LoadAttore extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		AttoreDao attDao= new AttoreDao();
		Attore attore= attDao.getAttoreById(Integer.parseInt((String)request.getParameter("idAttore")));
		request.setAttribute("attore", attore);
		request.getRequestDispatcher("/attore.jsp").forward(request, response);

}
}
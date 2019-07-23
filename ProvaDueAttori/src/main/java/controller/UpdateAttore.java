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
 * Servlet implementation class UpdateAttore
 */
@WebServlet("/updateAttore")
public class UpdateAttore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Attore attore= new Attore();
	attore.setIdAttore(Integer.parseInt((String)request.getParameter("idAttore")));
	attore.setNomeAttore(request.getParameter("nomeAttore"));
    attore.setCognomeAttore(request.getParameter("cognomeAttore"));
    attore.setEtaAttore(Integer.parseInt((String)request.getParameter("etaAttore")));
    try {
		AttoreDao att = new AttoreDao();
		att.updateAttore(attore);
		System.out.println("L'HO AGGIUNTO");
	}catch (Exception e) {
		System.out.println("NON L'HO AGGIUNTO");
		// TODO: handle exception
	}
	response.sendRedirect(response.encodeRedirectURL("elencoAttori"));
}

}

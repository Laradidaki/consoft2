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
 * Servlet implementation class AddCompagno
 */
@WebServlet("/addAttore")
public class AddAttore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		Attore a = new Attore();
		a.setNomeAttore(request.getParameter("nomeAtt"));
		a.setCognomeAttore(request.getParameter("cognomeAtt"));
		a.setEtaAttore(Integer.parseInt((String)request.getParameter("etaAtt")));
		try {
			AttoreDao att = new AttoreDao();
			att.addAttore(a);
			System.out.println("L'HO AGGIUNTO");
		}catch (Exception e) {
			System.out.println("NON L'HO AGGIUNTO");
			// TODO: handle exception
		}
		response.sendRedirect(response.encodeRedirectURL("elencoAttori"));
}
}
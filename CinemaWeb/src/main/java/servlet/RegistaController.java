package servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistaDao;
import model.Regista;

/**
 * Servlet implementation class RegistaController
 */
@WebServlet("*.doregista")
public class RegistaController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private RegistaDao dao=new RegistaDao();
	 


	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String url=request.getRequestURI();
			String action=request.getRequestURI().substring(url.lastIndexOf('/')+1, url.lastIndexOf('.'));
			
			if("list".equals(action)){
				List<Regista> registi=dao.getAllRegisti();
				request.setAttribute("registi", registi);
				request.getRequestDispatcher("/listaRegisti.jsp").forward(request, response);
			}
			else if("add".equals(action)){
				Regista regista= new Regista();
				 regista.setNomeRegista(request.getParameter("nomeRegista"));
			     regista.setCognomeRegista(request.getParameter("cognomeRegista"));
			     regista.setEtaRegista(Integer.parseInt(request.getParameter("etaRegista")));
				dao.addRegista(regista);
				response.sendRedirect("list.doregista");
			}else if("delete".equals(action)){
				int idRegista=Integer.parseInt(request.getParameter("idRegista"));
				dao.deleteRegista(idRegista);
				response.sendRedirect("list.doregista");
			}else if("load".equals(action)){
				Regista regista=dao.getRegistaById(Integer.parseInt(request.getParameter("idRegista")));
				request.setAttribute("regista", regista);
				request.getRequestDispatcher("regista.jsp").forward(request, response);
			}else if("update".equals(action)){
				Regista regista= new Regista();
				regista.setIdRegista(Integer.parseInt(request.getParameter("idRegista")));
				 regista.setNomeRegista(request.getParameter("nomeRegista"));
			     regista.setCognomeRegista(request.getParameter("cognomeRegista"));
			     regista.setEtaRegista(Integer.parseInt(request.getParameter("etaRegista")));
				dao.updateRegista(regista);
				response.sendRedirect("list.doregista");
			}
		}

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     doGet(request,response);

}
}

package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttoreDao;
import model.Attore;


/**
 * Servlet implementation class AttoreController
 */
@WebServlet("*.doattore")
public class AttoreController extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	
	    private AttoreDao dao= new AttoreDao();
	    

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String url=request.getRequestURI();
			String action=request.getRequestURI().substring(url.lastIndexOf('/')+1, url.lastIndexOf('.'));
			
			if("list".equals(action)){
				List<Attore> attori=dao.getAllAttori();
				request.setAttribute("attori", attori);
				request.getRequestDispatcher("/listaAttori.jsp").forward(request, response);
			}
			else if("add".equals(action)){
				Attore attore= new Attore();
				attore.setNomeAttore(request.getParameter("nomeAttore"));
			    attore.setCognomeAttore(request.getParameter("cognomeAttore"));
			    attore.setEtaAttore(Integer.parseInt((String)request.getParameter("etaAttore")));
				dao.addAttore(attore);
				response.sendRedirect("list.doattore");
			}else if("delete".equals(action)){
				int idAttore=Integer.parseInt((String)request.getParameter("idAttore"));
				dao.deleteAttore(idAttore);
				response.sendRedirect("list.doattore");
			}else if("load".equals(action)){
				Attore attore=dao.getAttoreById(Integer.parseInt((String)request.getParameter("idAttore")));
				request.setAttribute("attore", attore);
				request.getRequestDispatcher("/attore.jsp").forward(request, response);
			}else if("update".equals(action)){
				Attore attore= new Attore();
				 attore.setIdAttore(Integer.parseInt((String)request.getParameter("idAttore")));
				 attore.setNomeAttore(request.getParameter("nomeAttore"));
			     attore.setCognomeAttore(request.getParameter("cognomeAttore"));
			     attore.setEtaAttore(Integer.parseInt((String)request.getParameter("etaAttore")));
				dao.updateAttore(attore);
				response.sendRedirect("list.doattore");
			}
		}

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     doGet(request,response);

}
}

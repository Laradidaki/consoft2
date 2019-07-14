package servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.FilmDao;
import model.Film;


/**
 * Servlet implementation class MovieController
 */
@WebServlet("*.do")
public class MovieController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private FilmDao dao=new FilmDao();
	 


	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String url=request.getRequestURI();
			String action=request.getRequestURI().substring(url.lastIndexOf('/')+1, url.lastIndexOf('.'));
			
			if("list".equals(action)){
				List<Film> movies=dao.getAllFilm();
				request.setAttribute("movies", movies);
				request.getRequestDispatcher("/listaFilm.jsp").forward(request, response);
			}
			else if("add".equals(action)){
				Film film= new Film();
				 film.setNomeFilm(request.getParameter("nomeFilm"));
			     film.setDurataFilm(request.getParameter("durataFilm"));
			     film.setAnnoFilm(Integer.parseInt(request.getParameter("annoFilm")));
			     film.setCostoFilm(Double.parseDouble(request.getParameter("costoFilm")));
				dao.addFilm(film);
				response.sendRedirect("list.do");
			}else if("delete".equals(action)){
				int idFilm=Integer.parseInt(request.getParameter("idFilm"));
				dao.deleteFilm(idFilm);
				response.sendRedirect("list.do");
			}else if("load".equals(action)){
				Film film=dao.getFilmById(Integer.parseInt(request.getParameter("idFilm")));
				request.setAttribute("film", film);
				request.getRequestDispatcher("/film.jsp").forward(request, response);
			}else if("update".equals(action)){
				Film film= new Film();
				film.setIdFilm(Integer.parseInt(request.getParameter("idFilm")));
				 film.setNomeFilm(request.getParameter("nomeFilm"));
			        film.setDurataFilm(request.getParameter("durataFilm"));
			        film.setAnnoFilm(Integer.parseInt(request.getParameter("annoFilm")));
			        film.setCostoFilm(Double.parseDouble(request.getParameter("costoFilm")));
				dao.updateFilm(film);
				response.sendRedirect("list.do");
			}
		}

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     doGet(request,response);

}
}
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActorDAO;
import model.ActorVO;
import model.DirectorDAO;
import model.DirectorVO;
import model.GenreDAO;
import model.GenreVO;
import model.MovieDAO;
import model.MovieVO;
import model.RecommendationDAO;
import model.RecommendationVO;

/**
 * Servlet implementation class movieDetailServlet
 */
@WebServlet("/movieDetailServlet")
public class movieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public movieDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id = request.getParameter("m_id");
		MovieDAO mdao = new MovieDAO();
		ActorDAO adao = new ActorDAO();
		DirectorDAO ddao = new DirectorDAO();
		GenreDAO gdao = new GenreDAO();
		RecommendationDAO rdao = new RecommendationDAO();
		MovieVO movie = mdao.selectIdSql(m_id);
		ActorVO actor1 = adao.selectIdSql(movie.getA1_id()); 
		ActorVO actor2 = adao.selectIdSql(movie.getA2_id());
		ActorVO actor3 = adao.selectIdSql(movie.getA3_id());
		
		List<ActorVO> actorlist = new ArrayList<>();
		actorlist.add(actor1);
		actorlist.add(actor2);
		actorlist.add(actor3);
		DirectorVO director = ddao.selectIdSql(movie.getD_id());
		String genre = gdao.selectIdSql(movie.getG_id());
		
		request.setAttribute("movie", movie);
		request.setAttribute("actorlist", actorlist);
		request.setAttribute("director", director);
		request.setAttribute("genre", genre);
		
		if(rdao.selectIdSql(m_id) != null) {
			RecommendationVO recommendation = rdao.selectIdSql(m_id);
			MovieVO recommMovie1 = mdao.selectIdSql(recommendation.getR1_id());
			MovieVO recommMovie2 = mdao.selectIdSql(recommendation.getR2_id());
			MovieVO recommMovie3 = mdao.selectIdSql(recommendation.getR3_id());
			ActorVO recommMovie1_actor = adao.selectIdSql(recommMovie1.getA1_id());
			ActorVO recommMovie2_actor = adao.selectIdSql(recommMovie2.getA1_id());
			ActorVO recommMovie3_actor = adao.selectIdSql(recommMovie3.getA1_id());
			DirectorVO recommMovie1_director = ddao.selectIdSql(recommMovie1.getD_id());
			DirectorVO recommMovie2_director = ddao.selectIdSql(recommMovie2.getD_id());
			DirectorVO recommMovie3_director = ddao.selectIdSql(recommMovie3.getD_id());
			String recommMovie1_genre = gdao.selectIdSql(recommMovie1.getG_id());
			String recommMovie2_genre = gdao.selectIdSql(recommMovie2.getG_id());
			String recommMovie3_genre = gdao.selectIdSql(recommMovie3.getG_id());
					
			List<MovieVO> recommMovielist = new ArrayList<>();
			recommMovielist.add(recommMovie1);
			recommMovielist.add(recommMovie2);
			recommMovielist.add(recommMovie3);
			List<ActorVO> recommMovieActorlist = new ArrayList<>();
			recommMovieActorlist.add(recommMovie1_actor);
			recommMovieActorlist.add(recommMovie2_actor);
			recommMovieActorlist.add(recommMovie3_actor);
			List<DirectorVO> recommMovieDirectorlist = new ArrayList<>();
			recommMovieDirectorlist.add(recommMovie1_director);
			recommMovieDirectorlist.add(recommMovie2_director);
			recommMovieDirectorlist.add(recommMovie3_director);
			List<String> recommMovieGenrelist = new ArrayList<>();
			recommMovieGenrelist.add(recommMovie1_genre);
			recommMovieGenrelist.add(recommMovie2_genre);
			recommMovieGenrelist.add(recommMovie3_genre);
			
			request.setAttribute("recommMovielist", recommMovielist);
			request.setAttribute("recommMovieActorlist", recommMovieActorlist);
			request.setAttribute("recommMovieDirectorlist", recommMovieDirectorlist);
			request.setAttribute("recommMovieGenrelist", recommMovieGenrelist);
			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("moviedetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id = request.getParameter("m_id");
		MovieDAO mdao = new MovieDAO();
		MovieVO movie = mdao.selectIdSql(m_id);
		request.setAttribute("movie", movie);
		RequestDispatcher rd = request.getRequestDispatcher("moviedetail.jsp");
		rd.forward(request, response);
	}

}

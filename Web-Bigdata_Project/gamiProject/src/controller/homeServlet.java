package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ActorDAO;
import model.ActorVO;
import model.DirectorDAO;
import model.DirectorVO;
import model.GenreDAO;
import model.MovieDAO;
import model.MovieVO;
import model.SearchDAO;
import model.SearchVO;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/homeServlet")
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null && session.getAttribute("id") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("login_home.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchVO search = makeSearch(request);
		SearchDAO sdao = new SearchDAO();
		MovieDAO mdao = new MovieDAO();
		ActorDAO adao = new ActorDAO();
		DirectorDAO ddao = new DirectorDAO();
		GenreDAO gdao = new GenreDAO();
		
		sdao.searchInsert(search);
		List<MovieVO> movielist = mdao.selectNameSql(request.getParameter("search_contents"));
		List<ActorVO> actorlist = new ArrayList<ActorVO>();
		List<DirectorVO> directorlist = new ArrayList<DirectorVO>();
		List<String> genrelist = new ArrayList<String>();
		
		for(int i = 0; i < movielist.size(); i++) {
			actorlist.add(adao.selectIdSql(movielist.get(i).getA1_id()));
			directorlist.add(ddao.selectIdSql(movielist.get(i).getD_id())); 
			genrelist.add(gdao.selectIdSql(movielist.get(i).getG_id()));
		}
		
		request.setAttribute("movielist", movielist);
		request.setAttribute("actorlist", actorlist);
		request.setAttribute("directorlist", directorlist);
		request.setAttribute("genrelist", genrelist);
		RequestDispatcher rd = request.getRequestDispatcher("movielist.jsp");
		rd.forward(request, response);
	}
	
	private SearchVO makeSearch(HttpServletRequest request) throws UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8");
		SearchDAO dao = new SearchDAO();
		HttpSession session = request.getSession();
		long search_id = dao.searchCount();
		String search_contents = request.getParameter("search_contents");
		Date search_date = null;
		String c_id = (String) session.getAttribute("id");
		SearchVO search;
		if (c_id == null)
			search = new SearchVO(search_id + 1, search_contents, search_date, "null");
		else
			search = new SearchVO(search_id + 1, search_contents, search_date, c_id);
		return search;
	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerDAO;
import model.CustomerVO;

/**
 * Servlet implementation class checkIdServlet
 */
@WebServlet("/checkId")
public class checkIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_id = request.getParameter("c_id");
		CustomerDAO dao = new CustomerDAO();
		CustomerVO customer = dao.selectIdSql(c_id);
		String check = "";
		if(customer == null) {
			check = "가능한 아이디입니다.";
			request.setAttribute("check", check);
		}else {
			check = "중복된 아이디가 있습니다.";
			request.setAttribute("check", check);
		}
		request.setAttribute("check_id", c_id);
		RequestDispatcher rd = request.getRequestDispatcher("signing.jsp");
		rd.forward(request, response);
	}

}

package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import model.SearchDAO;
import model.SearchVO;
import model.StaffDAO;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("login_id");
		String password = request.getParameter("login_password");
		
		CustomerDAO customer = new CustomerDAO();
		StaffDAO staff = new StaffDAO();
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		
		if(staff.staffSearch(id, password) == 1) {
			
			session.setAttribute("staff", id);
			RequestDispatcher rd = request.getRequestDispatcher("login_home.jsp");
			rd.forward(request, response);
		}else if(customer.customerSearch(id, password) == 1) {
			
			session.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("login_home.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		//System.out.println(session.getAttribute("id"));
		//System.out.println(result);
	
	}

	
}

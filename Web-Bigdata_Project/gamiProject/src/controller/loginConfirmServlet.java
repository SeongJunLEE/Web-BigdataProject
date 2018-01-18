package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import model.CustomerVO;

/**
 * Servlet implementation class loginConfirmServlet
 */
@WebServlet("/loginconfirm")
public class loginConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		CustomerDAO dao = new CustomerDAO();
		String c_id = (String)session.getAttribute("id");
		if(c_id==null){
			response.sendRedirect(request.getContextPath()+"/customerlogin.jsp");
		}else{
			CustomerVO customer = dao.selectIdSql(c_id);
			System.out.println(customer);
			session.setAttribute("customerInfo", customer);
			response.sendRedirect(request.getContextPath()+"/customerinfo.jsp");
		}
		
	}

}

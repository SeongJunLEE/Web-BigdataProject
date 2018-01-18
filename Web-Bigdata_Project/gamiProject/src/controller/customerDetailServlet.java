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
 * Servlet implementation class CustomerDetail
 */
@WebServlet("/customerDetail")
public class customerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String c_id = (String) session.getAttribute("id");
		CustomerDAO dao = new CustomerDAO();
		CustomerVO customer = dao.selectIdSql(c_id);
		request.setAttribute("customerInfo", customer);
		RequestDispatcher rd = request.getRequestDispatcher("customerinfo.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDAO dao = new CustomerDAO();
		CustomerVO customer = new CustomerVO();
		customer.setC_id((String) session.getAttribute("id"));
		String c_password = request.getParameter("c_password");
		customer.setC_password(c_password);
		
		String c_phone = request.getParameter("c_phone");
		customer.setC_phone(c_phone);
		
		int result = dao.updateSql(customer);
		session.setAttribute("result", result);
		String msg = result>0?"수정성공":"수정실패";
		request.setAttribute("msg", msg);
		/*RequestDispatcher rd = request.getRequestDispatcher("customerinfo.jsp");
		rd.forward(request, response);*/
		
		response.sendRedirect("customerDetail");	
	}

}

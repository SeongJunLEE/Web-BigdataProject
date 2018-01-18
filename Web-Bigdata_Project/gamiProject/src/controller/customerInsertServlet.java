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

import model.CustomerDAO;
import model.CustomerVO;
import model.SearchDAO;
import model.SearchVO;
import util.DateUtil;

/**
 * Servlet implementation class customerInsertServlet
 */
@WebServlet("/customerInsert")
public class customerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("signing.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerVO customer = makeCustomer(request);
		CustomerDAO dao = new CustomerDAO();
		int result = dao.insertSql(customer);
		
		if(result == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("signing.jsp");
			rd.forward(request, response);
		}
	}

	private CustomerVO makeCustomer(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		String c_id = request.getParameter("c_id");
		String c_password = request.getParameter("c_password");
		String c_name = request.getParameter("c_name");
		String gend = request.getParameter("gender");
		char gender = gend.charAt(0);
	
		String bir = request.getParameter("birth");
		Date birth = DateUtil.toSqlDate(bir);
		
		String c_phone = request.getParameter("c_phone");
		
		CustomerVO customer = new  CustomerVO(c_id, c_password, c_name, gender, birth, c_phone, null);

		return customer;
	}
	
}

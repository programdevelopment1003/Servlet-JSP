package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import dao.OrderdetailDAO;
import model.OrderBean;
import model.OrderdetailBean;
import model.UserBean;

/**
 * Servlet implementation class GetOrderdetail
 */
@WebServlet("/GetOrderdetail")
public class GetOrderdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		String day = request.getParameter("day");
		session.setAttribute("orderday", day);
		
		ArrayList<OrderdetailBean> arrayorderdetail = new ArrayList<OrderdetailBean>();
		OrderdetailDAO orderdetaildao = new OrderdetailDAO();
		
		arrayorderdetail = orderdetaildao.getOrderdetail(id);
		
		//OrderdetailBean or = new OrderdetailBean();
		//or = arrayorderdetail.get(0);
		//System.out.println(or.getSuryo());
		
		session.setAttribute("userorderdetail", arrayorderdetail);
		
		request.getRequestDispatcher("G801.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

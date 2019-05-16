package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.CartDAO;
import model.BookBean;
import model.CartBean;
import model.UserBean;

/**
 * Servlet implementation class CartInsert
 */
@WebServlet("/CartInsert")
public class CartInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int b_id = Integer.parseInt(request.getParameter("id"));
		BookBean book = new BookBean();
		BookDAO bookdao = new BookDAO();
		book = bookdao.getBooks(b_id);
		
		UserBean user = (UserBean)session.getAttribute("user");
		
		CartDAO cartdao = new CartDAO();
		CartBean cartbean = new CartBean();
		
		cartbean = cartdao.CartSearch(user.getM_add(),b_id);
		
		
		if(cartbean==null){
			cartdao.CartInsert(user.getM_add(),b_id);
			
		}else{
			cartdao.CartSuryoadd(cartbean);
		}
		
		request.getRequestDispatcher("GetCart").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

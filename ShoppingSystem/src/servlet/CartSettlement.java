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
import dao.OrderDAO;
import dao.OrderdetailDAO;
import model.BookBean;
import model.CartBean;
import model.UserBean;

/**
 * Servlet implementation class CartSettlement
 */
@WebServlet("/CartSettlement")
public class CartSettlement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartSettlement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserBean userbean = new UserBean();
		userbean = (UserBean)session.getAttribute("user");
		
		CartDAO cartdao = new CartDAO();
		BookDAO bookdao = new BookDAO();
		OrderDAO orderdao = new OrderDAO();
		OrderdetailDAO orderdetaildao = new OrderdetailDAO();
		
		ArrayList<CartBean> arraycart = new ArrayList<CartBean>();
		arraycart = (ArrayList<CartBean>)session.getAttribute("usercart");
		 
		ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
		arraybook = (ArrayList<BookBean>)session.getAttribute("userbooks");
		 
		int bookstock;
		int cartsuryo;
		int price = 0;
		int count = 0;
		for(BookBean book:arraybook){
			CartBean cartbean = new CartBean();
			cartbean = arraycart.get(count);
			bookstock = book.getStock();
			bookstock = bookstock - cartbean.getSuryo();
			book.setStock(bookstock);
			 
			price = price + book.getPrice()*cartbean.getSuryo();
		}
		
		bookdao.BookStock(arraybook);
		orderdao.Orderinsert(userbean.getM_add(), price);
		int lastid = orderdao.getlastOrderid();
		orderdetaildao.detailInsert(lastid,arraycart,arraybook);
		
		cartdao.cartSettlement(userbean.getM_add());
		
		
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

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
 * Servlet implementation class GetCart
 */
@WebServlet("/GetCart")
public class GetCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("user");
		
		CartDAO cartdao = new CartDAO();
		
		ArrayList<CartBean> arraycart = new ArrayList<CartBean>();
		arraycart = cartdao.getCart(user.getM_add());
		
		ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
		BookDAO bookdao = new BookDAO();
		ArrayList<String> cartmsg = new ArrayList<String>();
		
		for(CartBean cart:arraycart){
			BookBean bookbean = new BookBean();
			
			bookbean = bookdao.getBooks(cart.getB_id());
			if(bookbean.getStock()<cart.getSuryo()){
				cartmsg.add("書籍ID"+cart.getB_id()+"は数量が在庫数を超過しています。削除してください。");
			}
			arraybook.add(bookbean);
		}
		session.setAttribute("cartmsg", cartmsg);
		session.setAttribute("usercart", arraycart);
		session.setAttribute("userbooks", arraybook);
		request.getRequestDispatcher("G601.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

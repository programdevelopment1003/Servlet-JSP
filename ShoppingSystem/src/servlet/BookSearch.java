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
import model.BookBean;
import model.UserBean;

/**
 * Servlet implementation class BookSearch
 */
@WebServlet("/BookSearch")
public class BookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearch() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); 
		String path ="";
		
		String books = request.getParameter("books");
		ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
		BookDAO bookdao = new BookDAO();
		UserBean user = (UserBean)session.getAttribute("user");
		
		arraybook = bookdao.getKyewordBook(books);
		
		session.setAttribute("arraybook", arraybook);
		
		if(user.getAuthority()==null){
			request.getRequestDispatcher("G401.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("G402.jsp").forward(request, response);
		}
	}

}

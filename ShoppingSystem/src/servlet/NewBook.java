package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.Blob;

import dao.BookDAO;
import dao.PasswordDAO;
import dao.UserDAO;
import model.BookBean;
import model.PasswordBean;
import model.UserBean;

/**
 * Servlet implementation class NewBook
 */

@WebServlet("/NewBook")
@MultipartConfig(maxFileSize = 2147483647)
public class NewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDAO bookdao = new BookDAO();
		int lastid = bookdao.BookLast();
		
		lastid++;
		
		HttpSession session = request.getSession();
		
		session.setAttribute("lastid", lastid);
		
		request.getRequestDispatcher("G301.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String b_name = request.getParameter("book");
		String b_namey = request.getParameter("booky");
		System.out.println(request.getParameter("booky"));
		System.out.println(request.getParameter("price"));
		int price = Integer.parseInt(request.getParameter("price"));
		int a_id = Integer.parseInt(request.getParameter("author"));
		int g_id = Integer.parseInt(request.getParameter("genre"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("picture");
		if (filePart != null) {
			is = filePart.getInputStream();
		}
		
		BookDAO bookdao = new BookDAO();
		bookdao.BookInsert(b_name,b_namey,price,a_id,g_id,stock,is);
		
		request.getRequestDispatcher("G202.jsp").forward(request, response);
	}

}

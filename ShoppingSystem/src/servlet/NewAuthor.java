package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.AuthorDAO;
import dao.BookDAO;
import model.AuthorBean;

/**
 * Servlet implementation class NewAuthor
 */
@WebServlet("/NewAuthor")
public class NewAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthorDAO authordao = new AuthorDAO();
		int lastid = authordao.AuthorLast();
		
		lastid++;
		
		HttpSession session = request.getSession();
		
		session.setAttribute("a_lastid", lastid);
		
		request.getRequestDispatcher("G302.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String a_name = request.getParameter("a_name");
		
		AuthorDAO authordao = new AuthorDAO();
		authordao.AuthorInsert(a_name);
		
		ArrayList<AuthorBean> arrayauthor = new ArrayList<AuthorBean>();
		arrayauthor = authordao.getAllauthor();
		session.setAttribute("arrayauthor", arrayauthor);
		
		request.getRequestDispatcher("G202.jsp").forward(request, response);
	}

}

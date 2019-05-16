package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AuthorDAO;
import dao.GenreDAO;
import model.AuthorBean;
import model.GenreBean;

/**
 * Servlet implementation class NewGenre
 */
@WebServlet("/NewGenre")
public class NewGenre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewGenre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GenreDAO genredao = new GenreDAO();
		int lastid = genredao.GenreLast();
		
		lastid++;
		
		HttpSession session = request.getSession();
		
		session.setAttribute("g_lastid", lastid);
		
		request.getRequestDispatcher("G303.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String g_name = request.getParameter("g_name");
		
		GenreDAO genredao = new GenreDAO();
		genredao.GenreInsert(g_name);
		
		ArrayList<GenreBean> arraygenre = new ArrayList<GenreBean>();
		arraygenre = genredao.getAllgenre();
		session.setAttribute("arraygenre", arraygenre);
		
		request.getRequestDispatcher("G202.jsp").forward(request, response);
	}

}

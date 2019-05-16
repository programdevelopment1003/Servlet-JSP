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
import dao.BookDAO;
import dao.CartDAO;
import dao.GenreDAO;
import dao.PasswordDAO;
import dao.UserDAO;
import model.AuthorBean;
import model.BookBean;
import model.CartBean;
import model.GenreBean;
import model.PasswordBean;
import model.UserBean;
import sec.SafePassword;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("G101.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); 
		String path ="";
		SafePassword safepass = new SafePassword();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String hashpass = safepass.getStretchedPassword(password, id);
		
		PasswordBean passbean = new PasswordBean();
		PasswordDAO passdao = new PasswordDAO();
		
		passbean = passdao.searchUser(id, hashpass);
		//ユーザ検索
		
		if(passbean != null){//検索したユーザがいるか判定
			UserBean userbean = new UserBean();
			UserDAO userdao = new UserDAO();
			userbean = userdao.getUser(id);
			path="G202.jsp";
			session.setAttribute("user", userbean);
			
			if(userbean.getAuthority()==null){
				path = "G201.jsp";
			}
			
			ArrayList<GenreBean> arraygenre = new ArrayList<GenreBean>();
			GenreDAO genredao = new GenreDAO();
			arraygenre = genredao.getAllgenre();
			session.setAttribute("arraygenre", arraygenre);
			
			ArrayList<AuthorBean> arrayauthor = new ArrayList<AuthorBean>();
			AuthorDAO authordao = new AuthorDAO();
			arrayauthor = authordao.getAllauthor();
			session.setAttribute("arrayauthor", arrayauthor);
		}else{
			session.setAttribute("login", "IDとパスワードを正しく入力してください");
			path="G101.jsp";
			//いなければログイン画面へ遷移
		}
		
		session.setAttribute("path", path);
		request.getRequestDispatcher(path).forward(request, response);
	}

}

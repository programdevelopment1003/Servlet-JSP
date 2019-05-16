package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PasswordDAO;
import dao.UserDAO;
import model.UserBean;

/**
 * Servlet implementation class UserDelete2
 */
@WebServlet("/UserDelete2")
public class UserDelete2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("selectuser");
		
		UserDAO userdao = new UserDAO();
		PasswordDAO passdao = new PasswordDAO();
		
		userdao.userDelete(user.getM_add());
		passdao.passDelete(user.getM_add());
		
		request.getRequestDispatcher("UserAllOut").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

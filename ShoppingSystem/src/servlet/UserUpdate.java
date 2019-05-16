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
import model.PasswordBean;
import model.UserBean;



/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserBean user = new UserBean();
		user = (UserBean)session.getAttribute("user");
		
		PasswordDAO passdao = new PasswordDAO();
		PasswordBean passbean = new PasswordBean();
		
		passbean = passdao.getPassword(user.getM_add());
		session.setAttribute("passbean", passbean);
		
		request.getRequestDispatcher("G501.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserBean user = new UserBean();
		UserDAO userdao = new UserDAO();
		user = (UserBean)session.getAttribute("user");
		
		String name = request.getParameter("name");
		String name_y = request.getParameter("name_y");
		int p_code = Integer.parseInt(request.getParameter("p_code"));
		String s_add = request.getParameter("s_add");
		String t_code = request.getParameter("t_code");
		
		userdao.userUpdate(user.getM_add(),p_code,s_add,t_code,name,name_y);
		
		request.getRequestDispatcher("G901.jsp").forward(request, response);
	}

}

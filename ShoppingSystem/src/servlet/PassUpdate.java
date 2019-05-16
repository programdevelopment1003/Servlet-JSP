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
import sec.SafePassword;

/**
 * Servlet implementation class PassUpdate
 */
@WebServlet("/PassUpdate")
public class PassUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("G504.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		SafePassword safepass = new SafePassword();
		UserBean user = new UserBean();
		PasswordDAO passdao = new PasswordDAO();
		PasswordBean passbean = new PasswordBean();
		user = (UserBean)session.getAttribute("user");
		
		String pass = request.getParameter("password");
		String hashpass = safepass.getStretchedPassword(pass, user.getM_add());
		passbean = passdao.getPassword(user.getM_add());
		
		if(passbean.getPassword().equals(hashpass)){
			String newpass = request.getParameter("newpass");
			String newhashpass = safepass.getStretchedPassword(newpass, user.getM_add());
			passdao.passUpdate(user.getM_add(),newhashpass);
		}else{
			session.setAttribute("passnot", "現在のパスワードが違います。");
			request.getRequestDispatcher("G504.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("G901.jsp").forward(request, response);
	}

}

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
 * Servlet implementation class UserUpdate2
 */
@WebServlet("/UserUpdate2")
public class UserUpdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		
		PasswordDAO passdao = new PasswordDAO();
		PasswordBean passbean = new PasswordBean();
		UserDAO userdao = new UserDAO();
		UserBean userbean = new UserBean();
		
		userbean = userdao.getUser(id);
		passbean = passdao.getPassword(id);
		
		session.setAttribute("selectpass", passbean);
		session.setAttribute("selectuser", userbean);
		
		request.getRequestDispatcher("G503.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserBean user = new UserBean();
		UserDAO userdao = new UserDAO();
		PasswordDAO passdao = new PasswordDAO();
		PasswordBean passbean = new PasswordBean();
		SafePassword safepass = new SafePassword();
		user = (UserBean)session.getAttribute("selectuser");
		passbean = (PasswordBean)session.getAttribute("selectpass");
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String name = request.getParameter("name");
		String name_y = request.getParameter("name_y");
		int p_code = Integer.parseInt(request.getParameter("p_code"));
		String s_add = request.getParameter("s_add");
		String t_code = request.getParameter("t_code");
		String auth = request.getParameter("authority");
		
		if(id==user.getM_add()){
			userdao.userUpdate(user.getM_add(),p_code,s_add,t_code,name,name_y);
			userdao.userAuthUpdate(user.getM_add(),auth);
			
			if(passbean.getPassword().equals(pass)){
				request.getRequestDispatcher("UserAllOut").forward(request, response);
			}else{
				String hashpass = safepass.getStretchedPassword(pass, user.getM_add());
				passdao.passUpdate(user.getM_add(),hashpass);
			}
		}else{
			userdao.userUpdate2(user.getM_add(),id,p_code,s_add,t_code,name,name_y);
			userdao.userAuthUpdate(id,auth);
			
			if(passbean.getPassword()!=pass){
				request.getRequestDispatcher("UserAllOut").forward(request, response);
			}else{
				String hashpass = safepass.getStretchedPassword(pass, id);
				passdao.passUpdate2(user.getM_add(),id,hashpass);
			}
		}
		request.getRequestDispatcher("UserAllOut").forward(request, response);
	}

}

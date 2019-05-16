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
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		SafePassword safepass = new SafePassword();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		String sadd = request.getParameter("sadd");
		String tcode = request.getParameter("tcode");
		String name = request.getParameter("name");
		String namey = request.getParameter("namey");
		
		int passl = pass.length();
		if(passl>12 || passl<8){
			String msg2 = "パスワードは半角英数8字以上12字以内です";
			session.setAttribute("msg2", msg2);
			request.getRequestDispatcher("G102.jsp").forward(request, response);
		}
		
		UserDAO userdao = new UserDAO();
		UserBean userbean = new UserBean(id,pcode,sadd,tcode,name,namey);
		String hash = safepass.getStretchedPassword(pass, id);
		PasswordBean passbean = new PasswordBean(id,hash);
		PasswordDAO passdao = new PasswordDAO();
		
		String check = userdao.CheckUser(id);
		if(check.equals(id)){
			String msg3 = "＊このID(メールアドレス)はすでに使用されています";
			session.setAttribute("msg3", msg3);
			request.getRequestDispatcher("G102.jsp").forward(request, response);
		}
		userdao.Userinsert(userbean);
		passdao.PasswordInsert(passbean);
		
		request.getRequestDispatcher("G101.jsp").forward(request, response);
	}

}

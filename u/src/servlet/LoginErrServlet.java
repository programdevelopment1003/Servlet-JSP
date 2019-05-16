package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.LoginDto;
import model.LoginManage;

/**
 * Servlet implementation class LoginErrServlet
 */
@WebServlet("/LoginErrServlet")
public class LoginErrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginErrServlet() {
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
		HttpSession session = request.getSession();
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");


		//モデルを呼び出し、ログイン実行
		LoginManage loginmanage = new LoginManage();

		LoginDto dto = loginmanage.login(mail,pass);
		System.out.println(dto+"*dtol");
		if( dto != null){
			//ログイン成功
		    String au =dto.getAuthority();
		    int id =dto.getId();
		    session.setAttribute("login", dto);
		    session.setAttribute("userId", id);
		    session.setAttribute("name",dto.getName());
		    session.setAttribute("logindto",dto);


		    if(au.equals("A")){
		    	request.getRequestDispatcher("G203.jsp").forward(request, response);
		    }else{
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("G201.jsp");
				dispatcher.forward(request, response);
		    }



		}else{
			//ログイン失敗
			int count = (int)session.getAttribute("count");
		   if(count<2){
			   count++;
			   session.setAttribute("count", count);
			   request.getRequestDispatcher("G101-2.jsp").forward(request, response);
		   }else{
			   request.getRequestDispatcher("G101-3.jsp").forward(request, response);
		   }
		}
	}

}

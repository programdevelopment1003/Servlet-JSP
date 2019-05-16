package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDto;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String name = request.getParameter("pass");
		String pass = request.getParameter("name");
		String userId = request.getParameter("userId");
		int userId2=Integer.parseInt(userId);

		List<String> errMsgList = new ArrayList<String>();

		if(name.length() > 100 || name.length() <= 0) {
			//エラー時の処理
			errMsgList.add("ユーザー名はaaaaaaaで入力してください");
		}
		if( pass.length() > 100 || pass.length() <= 0) {
			//エラー時の処理
			errMsgList.add("パスワードはssssssで入力してください");
		}
		if( mail.length() > 300 || mail.length() <= 0) {
			//エラー時の処理
			errMsgList.add("メールアドレスはaaaaaで入力してください");
		}

		UserDto userDto = new UserDto();
		userDto.setuserId(userId2);
		userDto.setpass(pass);
		userDto.setname(name);
		userDto.setmail(mail);

		if( errMsgList.size() > 0) {
			//入力画面へ画面遷移
			request.setAttribute("errMsgList", errMsgList);
			request.setAttribute("userDto", userDto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("G106.jsp");
			dispatcher.forward(request,response);
			return;
		}


		HttpSession session = request.getSession(true);
		session.setAttribute("userDto", userDto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("G106-2.jsp");
		dispatcher.forward(request,response);

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

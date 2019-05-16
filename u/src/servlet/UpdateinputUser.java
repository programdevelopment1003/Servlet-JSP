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

import dao.UserDao;
import dto.LoginDto;
import dto.UserDto;
import model.UserManage;

/**
 * Servlet implementation class UpdateinputUser
 */
@WebServlet("/UpdateinputUser")
public class UpdateinputUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateinputUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		int userid =(int)session.getAttribute("userId");

		UserDao userdao=new UserDao();
		userdao.delete(userid);

		RequestDispatcher dispatcher = request.getRequestDispatcher("G101.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		LoginDto login = (LoginDto)session.getAttribute("login");

		//String mail1 = login.getmaile(); 　←いらない！！！


		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		int userId = (int)session.getAttribute("userId");


		System.out.println("id");
		System.out.println(userId);



		List<String> errMsgList = new ArrayList<String>();


		if( pass.length() > 100 || pass.length() <= 0) {
			//エラー時の処理
			errMsgList.add("パスワードはssssssで入力してください");
		}
		if( mail.length() > 300 || mail.length() <= 0) {
			//エラー時の処理
			errMsgList.add("メールアドレスはaaaaaで入力してください");
		}


		UserDto userDto = new UserDto();
		userDto.setuserId(userId);
		userDto.setpass(pass);
		userDto.setname(name);
		userDto.setmail(mail);



		UserDao userdao=new UserDao();
		userdao.update(userDto);

		if( errMsgList.size() > 0) {
			//入力画面へ画面遷移
			request.setAttribute("errMsgList", errMsgList);
			request.setAttribute("userDto", userDto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("G104.jsp");
			dispatcher.forward(request,response);
			return;
		}





		//2.モデルの呼び出し（DBへの登録）
		UserManage usermanage = new UserManage();

		usermanage.update(userDto);

		//3.セッションのデータの削除
		session.removeAttribute("userDto");

		//4.画面呼び出し
		RequestDispatcher dispatcher = request.getRequestDispatcher("G201.jsp");
		dispatcher.forward(request, response);
	}

}

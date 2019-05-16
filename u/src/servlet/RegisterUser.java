package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.UserDto;
import model.UserManage;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDto userDto = null;
		HttpSession session = request.getSession();

		userDto = (UserDto)session.getAttribute("userDto");

		//2.モデルの呼び出し（DBへの登録）
		UserManage usermanage = new UserManage();
		UserDao userdao = new UserDao();
		try {
			userdao.insert(userDto);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//3.セッションのデータの削除
		session.removeAttribute("userDto");

		//4.画面呼び出し
		RequestDispatcher dispatcher = request.getRequestDispatcher("G101.jsp");
		dispatcher.forward(request, response);
	}

}

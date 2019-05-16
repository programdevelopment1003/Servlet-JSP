package servet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.InformationBean;
import model.ScheduleDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Loin")
public class Loin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータ受け取り
		String mail=request.getParameter("mail");
		String pass=request.getParameter("pass");

		//DAOファイルとBeanファイルをインスタンス化
		ScheduleDAO ScheduleDAO=new ScheduleDAO();
		InformationBean informationBean=new InformationBean();

		//ユーザ情報取得
		informationBean=ScheduleDAO.getLogin(mail,pass);
		System.out.println(informationBean.getId());

		HttpSession session = request.getSession();
		String path = null;
		if(informationBean==null){
			request.setAttribute("login","NG");
			//ログイン画面に飛ぶ
			path="Loin.jsp";

		}
		if(informationBean !=null){
			//LoginOK
			//ここでログインのユーザ情報などをsessionに保存する
			session.setAttribute("informationBean", informationBean);
			if(informationBean.getAuthority().equals("A")){
				//管理者スケジュール画面に飛ぶ
				path="Management.jsp";
			}else{
			//ユーザースケジュール画面に飛ぶ
			path="top.jsp";
			session.setAttribute("ok", "ok");
		}
		}
		//フォワード
		request.getRequestDispatcher(path).forward(request,response);

}



	}


package servet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.InformationBean;
import model.ScheduleDAO;
import model.UserBean;

/**
 * Servlet implementation class Alluser
 */
@WebServlet("/Alluser")
public class Alluser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alluser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScheduleDAO ScheduleDAO=new ScheduleDAO();
		InformationBean informationBean=new InformationBean();

		//ArrayList作成
		ArrayList<UserBean>user=new ArrayList<UserBean>();
		user=ScheduleDAO.getuser();

		//リクエストスコープへ飛ばす
		HttpSession session = request.getSession();
		session.setAttribute("user",user);

		//飛ばす
		request.getRequestDispatcher("Alluser.jsp").forward(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

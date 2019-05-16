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
import model.UserBean;

/**
 * Servlet implementation class Tochange
 */
@WebServlet("/Tochange")
public class Tochange extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tochange() {
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
		String username=request.getParameter("username");
		String mail=request.getParameter("mail");
		String name=request.getParameter("name");
		String post=request.getParameter("post");
		String address=request.getParameter("address");
		System.out.println(username);

		ScheduleDAO ScheduleDAO=new ScheduleDAO();
		InformationBean informationBean=new InformationBean();
		UserBean userbean=new UserBean();

		HttpSession session = request.getSession();
		InformationBean id = (InformationBean)session.getAttribute("informationBean");
		System.out.println("d");

		ScheduleDAO.Change(username,mail,name,post,address,id.getId());

		request.getRequestDispatcher("top.jsp").forward(request,response);

	}

}

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
 * Servlet implementation class Passchange
 */
@WebServlet("/Passchange")
public class Passchange extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Passchange() {
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
		String pass=request.getParameter("pass");

		//DAOファイルとBeanファイルをインスタンス化
		ScheduleDAO ScheduleDAO=new ScheduleDAO();

		HttpSession session = request.getSession();
		InformationBean id = (InformationBean)session.getAttribute("user");

		ScheduleDAO.PassChange(pass,id.getId());

		request.getRequestDispatcher("top.jsp").forward(request,response);

	}

}

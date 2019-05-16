package servet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddtoBean;
import model.ScheduleDAO;

/**
 * Servlet implementation class Addto
 */
@WebServlet("/Addto")
public class Addto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addto() {
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
		String name=request.getParameter("name");
		String Descr=request.getParameter("Descr");
		String price=request.getParameter("price");
		String Description=request.getParameter("Description");

		ScheduleDAO ScheduleDAO=new ScheduleDAO();
		AddtoBean addtobean=new AddtoBean(name,Descr,price,Description);

		request.setAttribute("name", addtobean);




		ScheduleDAO.Addto(name,Descr,price,Description);

		request.getRequestDispatcher("Management.jsp").forward(request,response);
		doGet(request, response);
	}

}

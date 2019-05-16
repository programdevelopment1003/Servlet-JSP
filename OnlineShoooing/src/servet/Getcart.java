package servet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartBean;
import model.InformationBean;
import model.ScheduleDAO;

/**
 * Servlet implementation class Getcart
 */
@WebServlet("/Getcart")
public class Getcart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getcart() {
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
		HttpSession session = request.getSession();
		InformationBean sess = (InformationBean)session.getAttribute("informationBean");
		int id;
		id=sess.getId();
		ArrayList<CartBean> cart=new ArrayList<CartBean>();
		cart=ScheduleDAO.getcart(id);
		session.setAttribute("cart",cart);
		request.getRequestDispatcher("cart.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

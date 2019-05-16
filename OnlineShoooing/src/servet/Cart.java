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
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
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
		String ption=request.getParameter("ption");
		String Product=request.getParameter("Product");
		String produ=request.getParameter("produ");
		System.out.println(name);
		System.out.println(ption);
		System.out.println(Product);
		System.out.println(produ);




		ScheduleDAO ScheduleDAO=new ScheduleDAO();
		InformationBean informationBean=new InformationBean();
		HttpSession session = request.getSession();
		InformationBean sess = (InformationBean)session.getAttribute("informationBean");
		int id=sess.getId();
		System.out.println(id);
		ScheduleDAO.Cart(name,ption,Product,produ,id);
		request.getRequestDispatcher("search results.jsp").forward(request,response);

		doGet(request, response);
	}

}

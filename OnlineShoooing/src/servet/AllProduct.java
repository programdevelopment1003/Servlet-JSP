package servet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProduBean;
import model.ScheduleDAO;

/**
 * Servlet implementation class AllProduct
 */
@WebServlet("/AllProduct")
public class AllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAOファイルとBeanファイルをインスタンス化
				ScheduleDAO ScheduleDAO=new ScheduleDAO();

				ArrayList<ProduBean> Produ=new ArrayList<ProduBean>();
				Produ=ScheduleDAO.AllProduct();
				HttpSession session = request.getSession();
				session.setAttribute("Produ", Produ);
				//フォワード
				request.getRequestDispatcher("search results.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

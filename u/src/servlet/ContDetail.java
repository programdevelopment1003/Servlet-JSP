package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContDetailDao;
import model.DetailBean;

/**
 * Servlet implementation class ContDetail
 */
@WebServlet("/ContDetail")
public class ContDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path;//移動先
		String contid = request.getParameter("contId");
		int contId = Integer.parseInt(contid);
		//AllayListの宣言
        ArrayList<DetailBean> dlist = new ArrayList<DetailBean>();
        //ItemDaoとDAOファイルをインスタンス化
        ContDetailDao ddao = new ContDetailDao();

        request.setAttribute("dlist",ddao.getCont(contId));

        HttpSession session = request.getSession();
        session.setAttribute("contId",contId);

        System.out.println("*detail.java");
        	//次のページ
        path = "G202.jsp";
        //response.sendRedirect("B-Servlet"); サーブレットからサーブレットへ移動できる
        request.getRequestDispatcher(path).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doGet(request, response);
	}

}

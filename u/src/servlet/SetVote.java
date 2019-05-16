package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContDao;
import dao.ContDetailDao;
import model.DetailBean;

/**
 * Servlet implementation class SetVote
 */
@WebServlet("/SetVote")
public class SetVote extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetVote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("*SetVote");
		String path;//移動先
		String contid = request.getParameter("contId");
		String detailid = request.getParameter("detailId");
		int contId = Integer.parseInt(contid);
		int detailId = Integer.parseInt(detailid);
		System.out.println("setvote* "+detailId);
		//AllayListの宣言
        ArrayList<DetailBean> dlist = new ArrayList<DetailBean>();
        //ItemDaoとDAOファイルをインスタンス化
        ContDetailDao ddao = new ContDetailDao();
        int vote = ddao.Vote(contId, detailId);
        vote = vote +1;
        ddao.setVote(contId, detailId,vote);

        ContDao cdao = new ContDao();
        request.setAttribute("clist",cdao.getCont());
     	//次のページ
        path = "G201.jsp";
        //response.sendRedirect("B-Servlet"); サーブレットからサーブレットへ移動できる
        request.getRequestDispatcher(path).forward(request,response);
	}

}

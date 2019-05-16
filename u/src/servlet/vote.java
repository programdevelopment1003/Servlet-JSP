package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContDao;
import model.ContBean;
import model.VoteDTO;
import model.VoteSQL;

/**
 * Servlet implementation class vote
 */
@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public vote() {
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
		response.setContentType("text/html;charset=UTF-8");
		 request.setCharacterEncoding("UTF-8");
		//値の習得取得
		String dId = request.getParameter("radio");
		System.out.println(dId);
		int did = Integer.parseInt(dId);
		int vote = 0;
		boolean Boolean = false;

		HttpSession session = request.getSession();



		int coId=(int)session.getAttribute("contId");
		System.out.println(coId);
		int uId=(int)session.getAttribute("userId");
		System.out.println(uId);

		VoteSQL sql = new VoteSQL();
		System.out.println("4");
		VoteDTO dto = new VoteDTO();
		System.out.println("3");

		dto.votedto(uId, coId, did);
		vote=sql.getvote(dto.getDetailId());
		System.out.println("1");

		vote++;
		Boolean =sql.setvote(vote,dto.getDetailId());
		System.out.println(Boolean);

		if(Boolean) {
			sql.sethistory(dto.getUserId(),dto.getContId());
		} else {
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}

		 //ContDaoとDAOファイルをインスタンス化
        ContDao cdao = new ContDao();
    	ArrayList<ContBean> clist = new ArrayList<ContBean>();
       clist=cdao.getCont();
        request.setAttribute("clist",clist);
        
        
        request.getRequestDispatcher("G201.jsp").forward(request,response);
	}

}

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
import dto.LoginDto;
import model.ContBean;
import model.LoginManage;

/**
 * Servlet implementation class Cont
 */
@WebServlet("/Cont")
public class Cont extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cont() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path;//移動先

		HttpSession session = request.getSession();
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		//モデルを呼び出し、ログイン実行
		LoginManage loginmanage = new LoginManage();

		LoginDto dto = loginmanage.login(mail,pass);
		if( dto != null){
			//ログイン成功
		    String au =dto.getAuthority();
		    int id =dto.getId();
		    session.setAttribute("login", dto);
		    session.setAttribute("userId", id);
		    session.setAttribute("name",dto.getName());
		    session.setAttribute("logindto",dto);

		    //ContDaoとDAOファイルをインスタンス化
	        ContDao cdao = new ContDao();
	    	ArrayList<ContBean> clist = new ArrayList<ContBean>();
	    	clist =cdao.getCont();
	        request.setAttribute("clist",clist);

		    if(au.equals("A")){
		    		path="G203.jsp";
    System.out.println("*AA");
		    }else{
		    		path="G201.jsp";
    System.out.println("*UU");
		    }

		}else{
			//ログイン失敗
			int count = (int)session.getAttribute("count");
		   if(count<2){
			   count++;
			   session.setAttribute("count", count);
			   path="G101-2.jsp";
		   }else{
			   path="G101-3.jsp";
		   }
		}
		System.out.println(path);

        //response.sendRedirect("B-Servlet"); サーブレットからサーブレットへ移動できる
        request.getRequestDispatcher(path).forward(request,response);
	}

}

package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.BlobDao;
import dao.ContDao;
import dao.ContDetailDao;

/**
 * Servlet implementation class DetailChange
 */
@WebServlet("/DetailChange")
public class DetailChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailChange() {
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
		System.out.println("*contchange");

		String contid = request.getParameter("contId");
	    String detailid = request.getParameter("detailId");
        String vote2 = request.getParameter("vote");
		String note2 = request.getParameter("note2");
		String imagId=request.getParameter("imageId");


		int contId = Integer.parseInt(contid);
		int detailId =Integer.parseInt(detailid);
		int vote = Integer.parseInt(vote2);
		int imageId=Integer.parseInt(imagId);

		InputStream is =null;
		Part filePart =request.getPart("file");
		System.out.println("*file*"+filePart);
		if(filePart !=null) {
			is = filePart.getInputStream();


System.out.println("*blob");
			//画像の処理をやる
			BlobDao blob = new BlobDao();
			blob.boleSQLcha(imageId,is);
		}

System.out.println("*update");
		String path;//移動先
        //ContDaoとDAOファイルをインスタンス化
        ContDetailDao ddao = new ContDetailDao();
        //contentの変更
        ddao.update(contId, detailId, vote, imageId, note2);
        //contentの一覧
        ContDao cdao =new ContDao();
        request.setAttribute("clist",cdao.getCont());
        //response.sendRedirect("B-Servlet"); サーブレットからサーブレットへ移動できる
  System.out.println("*end");
        path ="G203.jsp";
        request.getRequestDispatcher(path).forward(request,response);
	}

}

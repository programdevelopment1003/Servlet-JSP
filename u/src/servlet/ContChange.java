package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.BlobDao;
import dao.ContDao;


/**
 * Servlet implementation class ContChange
 */
@WebListener
@WebServlet("/ContChange")
@MultipartConfig (maxFileSize = 2147483647)
public class ContChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContChange() {
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
	    String contName = request.getParameter("contName");
		String start =(String)request.getParameter("start");
		String end = (String)request.getParameter("end");
		String note = request.getParameter("note");
		String imagId=request.getParameter("imageId");


		int contId = Integer.parseInt(contid);
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
        ContDao cdao = new ContDao();
        //contentの変更
        cdao.update(contId, contName, start, end, note, imageId);
        //contentの一覧
        request.setAttribute("clist",cdao.getCont());
        //response.sendRedirect("B-Servlet"); サーブレットからサーブレットへ移動できる
  System.out.println("*end");

        path ="G203.jsp";
        request.getRequestDispatcher(path).forward(request,response);
	}

}

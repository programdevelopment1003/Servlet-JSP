package servlet;


import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.G205sql;

/**
 * Servlet implementation class G205
 */
@WebServlet("/G205")
@WebListener
@MultipartConfig (maxFileSize = 2147483647)

public class G205 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public G205() {
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
		 System.out.println("G205とに入った");
		response.setContentType("text/html;charset=UTF-8");
		 request.setCharacterEncoding("UTF-8");
		//値の習得取得
		String name = request.getParameter("name");
		Part img = request.getPart("img");
		String Descripion = request.getParameter("Description");
		String stat = request.getParameter("start");
		String end = request.getParameter("end");
		String number = request.getParameter("number");
		InputStream is = null;
		Date statDate = null;
		Date endDate = null;

		//開始日と終了日を曜日型に変換
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		try {
			statDate = sdf.parse(stat);
			endDate = sdf.parse(end);
		} catch (ParseException e) {
			e.printStackTrace();
			//曜日でエラーが出たときの処理
			request.setAttribute("error","曜日の入力形式が間違っています。");
			request.getRequestDispatcher("G205.jsp").forward(request,response);
		}

		if(img != null){
			is = img.getInputStream();
		}
 		G205sql g205sql = new G205sql();
			g205sql.setimg(name,is);
			int cont=g205sql.content(name,end,Descripion,stat,is);
			System.out.println(cont+"wwww");
			String contId = String.valueOf(cont);



		//numberをセッションとして送る
			HttpSession session = request.getSession();
			session.setAttribute("number",number);
			session.setAttribute("contId",contId);
		//詳細画面に飛ぶ
		request.getRequestDispatcher("G206.jsp").forward(request,response);



		doGet(request, response);
	}

}

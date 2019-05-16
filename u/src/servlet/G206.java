package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ContDao;
import model.ContBean;
import model.G206sql;

/**
 * Servlet implementation class G206
 */
@WebServlet("/G206")
@WebListener
@MultipartConfig (maxFileSize = 2147483647)
public class G206 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public G206() {
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
		response.setContentType("text/html;charset=UTF-8");
		 request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String imgsd =(String)session.getAttribute("number");
		int imgsuu = Integer.parseInt(imgsd);
		String cont =(String)session.getAttribute("kanncontId");
		int contId = Integer.parseInt(cont);
		//a=Integer.parseInt(imgsuu);
		ArrayList<Part>imgs = new ArrayList<Part>();
		ArrayList<String>Des = new ArrayList<String>();
		ArrayList<String>names = new ArrayList<String>();
		InputStream is = null;
		int getsql = 0;
		String s  =  null;
		String name = null;
		String img = null;
		String De = null;

		G206sql g206sql =new G206sql();

		for(int i = 0;i<imgsuu;i++){
			s = String.valueOf(i);
			name ="name"+s;
			img="img"+s;
			De="De"+s;

			imgs.add(request.getPart(img));
			Des.add(request.getParameter(De));
			names.add(request.getParameter(name));
		}

		for(Part o : imgs) {
			is = o.getInputStream();
			g206sql.setimg(names.get(getsql),is);
			g206sql.setDetails(Des.get(getsql),names.get(getsql),contId);
			getsql++;
			System.out.println(getsql+"11111");
		}
		ContDao cdao = new ContDao();
    	ArrayList<ContBean> clist = new ArrayList<ContBean>();
       clist=cdao.getCont();
        request.setAttribute("clist",clist);
        System.out.println(cdao.getCont());
		request.getRequestDispatcher("G203.jsp").forward(request,response);
	}

}

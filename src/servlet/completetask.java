package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.Task;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class completetask
 */
@WebServlet("/completetask")
public class completetask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public completetask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String keyword=request.getParameter("key");
        HttpSession session = request.getSession(); 
 		int k=Integer.parseInt(keyword);
 		System.out.println(k);
		int uid=(int)session.getAttribute("uid");
	
		Task s=new Task();
		 List<String> listcompletetask=s.selectcompletetask(uid,k);
			
		 System.out.println(listcompletetask);
		response.getWriter().write(JSONArray.fromObject(listcompletetask).toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

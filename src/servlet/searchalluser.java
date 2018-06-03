package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.task;
import dao.Task;
import dao.User;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class searchalluser
 */
@WebServlet("/searchalluser")
public class searchalluser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchalluser() {
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
        
         String keyword=request.getParameter("keyword");
         HttpSession session = request.getSession(); 
 		
         User s=new User();
 		if(s.selectsimilar(keyword,session)!=0)
 		{
 			List<String> listsearchuser=(List<String>) session.getAttribute("listsearchuser");
 			System.out.println(listsearchuser);
 			response.getWriter().write(JSONArray.fromObject(listsearchuser).toString());
 		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
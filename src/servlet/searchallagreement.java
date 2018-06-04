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
import dao.Agreement;
import dao.Task;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class searchallagreement
 */
@WebServlet("/searchallagreement")
public class searchallagreement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchallagreement() {
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
         System.out.println(keyword);
         Agreement s=new Agreement();
 		 if(s.selectsimilar(keyword,session)!=0)
 		{
 			List<String> listsearchagreement=(List<String>) session.getAttribute("listsearchagreement");
 			System.out.println(listsearchagreement);
 			response.getWriter().write(JSONArray.fromObject(listsearchagreement).toString());
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

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Completetask;
import dao.Task;

/**
 * Servlet implementation class searchcompletetask
 */
@WebServlet("/searchcompletetask")
public class searchcompletetask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchcompletetask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(); 
	    String username=null;
	     username=(String) session.getAttribute("username");
	     int uid=0;
	     if(username!=null) {
	        	
	    		uid=(int)session.getAttribute("uid");
	        }
	       
		String keyword=request.getParameter("keyword");
		
	   if(uid!=0) {

			Task s=new Task();
			if( s.selectsimilarcompletetask(uid,keyword,session)!=0) {
				
				response.sendRedirect(request.getContextPath()+"/completetask.jsp");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/selectcompletetask_failure.jsp");
			}
	   }
	   else
	   {
		   Task s=new Task();
			if( s.selectallsimilarcompletetask(keyword,session)!=0) {
				
				response.sendRedirect(request.getContextPath()+"/checkcompletetaskbyuser.jsp");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/checkcompletetaskbyuser_failure.jsp");
			}
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

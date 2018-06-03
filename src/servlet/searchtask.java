package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.task;
import dao.Task;

/**
 * Servlet implementation class searchtask
 */
@WebServlet("/searchtask")
public class searchtask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchtask() {
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
		task t=new task();
		String keyword=request.getParameter("keyword");
        HttpSession session = request.getSession(); 
        String username=null;
	     username=(String) session.getAttribute("username");
	     int uid=0;
	     if(username!=null) {
	        	
	    		uid=(int)session.getAttribute("uid");
	        }
        System.out.println(keyword);
		Task s=new Task();
		
		if(s.selectsimilartask(keyword,session)!=0)
		{
		    
			if(uid!=0) {
				response.sendRedirect(request.getContextPath()+"/task.jsp");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/checktaskbyuser.jsp");
			}
			
		}
		else
		{
			
			if(uid!=0) {
				response.sendRedirect(request.getContextPath()+"/task_failure.jsp");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/checktaskbyuser_failure.jsp");
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

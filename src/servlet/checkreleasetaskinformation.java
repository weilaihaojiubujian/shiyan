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

/**
 * Servlet implementation class checkreleasetaskinformation
 */
@WebServlet("/checkreleasetaskinformation")
public class checkreleasetaskinformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkreleasetaskinformation() {
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
		String list = request.getParameter("list");
		HttpSession session = request.getSession(); 
		System.out.println(list);
		task n=new task();
		List<task> q=null;
		Task s=new Task();
		q=(List<task>)session.getAttribute("listreleasetask");
		 for(task t:q)
		 {
			 String h=t.toString();
			 if(h.equals(list)) {
				 int tid=t.getTid();
				 if(tid!=0)
				 {
					 session.setAttribute("tid", tid);
				 }
				
				
			
	
				 if(s.selecttid(tid, session)==1)
				 {
					 response.sendRedirect(request.getContextPath()+"/taskinformation.jsp");
				 }
				
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

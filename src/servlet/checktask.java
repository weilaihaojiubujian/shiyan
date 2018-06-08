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
import dao.Alreadytask;
import dao.Task;

/**
 * Servlet implementation class checktask
 */
@WebServlet("/checktask")
public class checktask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checktask() {
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
		int tid= Integer.parseInt(list);
		System.out.println(tid);
	
				
				
		session.setAttribute("tid", tid);	
		int uid=(int)session.getAttribute("uid");
			
		Alreadytask k=new Alreadytask();
		Agreement a=new Agreement();
		if(k.selectall(uid)==1 && a.selectagreement(tid, session)==1)
				 {
					 response.sendRedirect(request.getContextPath()+"/signagreement.jsp");
				 }
		else
				 {
					 response.sendRedirect(request.getContextPath()+"/accepttask_failure.jsp");
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

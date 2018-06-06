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
import dao.Signagreement;
import dao.Task;
import bean.agreement;
/**
 * Servlet implementation class checkagreement
 */
@WebServlet("/checkagreement")
public class checkagreement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkagreement() {
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
		int aid= Integer.parseInt(list);
		System.out.println(aid);
				
				
		int tid=(int)session.getAttribute("tid");
		int uid=(int)session.getAttribute("uid");
				
				
		Agreement w=new Agreement();
		if(w.insertsameagreement(aid,tid,session)==1)
					{
						
				
					
						response.sendRedirect(request.getContextPath()+"/releaseagreement_success.jsp");
					}
		else
					{
						response.sendRedirect(request.getContextPath()+"/releaseagreement_failure.jsp");
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

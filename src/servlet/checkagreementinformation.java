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
import bean.agreement;
/**
 * Servlet implementation class checkagreementinformation
 */
@WebServlet("/checkagreementinformation")
public class checkagreementinformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkagreementinformation() {
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
		String list = request.getParameter("lis");
		HttpSession session = request.getSession(); 
		System.out.println(list);
		
        if(!list.equals(1)) {
        	int aid= Integer.parseInt(list);
    		System.out.println(aid);
    		Agreement s=new Agreement();		
    			
    	
    		if(s.selectagreementintroduce(aid, session)==1)
    				 {
    					 
    					 response.sendRedirect(request.getContextPath()+"/agreementinformation.jsp");
    				}
    				
    		
    		 
        }
        else
        {
        	Agreement s=new Agreement();
        	task t=(task)session.getAttribute("task");
        	 int tid=t.getTid();
        	 System.out.println(tid);
			 if(s.selectoneagreementintroduce(tid, session)==1)
			 {
				 
				 response.sendRedirect(request.getContextPath()+"/agreementinformation.jsp");
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

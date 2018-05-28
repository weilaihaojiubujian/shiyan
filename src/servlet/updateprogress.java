package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Alreadytask;
import dao.Completetask;
import dao.Task;

/**
 * Servlet implementation class updateprogress
 */
@WebServlet("/updateprogress")
public class updateprogress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateprogress() {
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
		String p = request.getParameter("progress");
		double progress=Double.parseDouble(p);
		
		Alreadytask x=new Alreadytask();
		HttpSession session = request.getSession(); 
		int tid=(int)session.getAttribute("tid");
		int uid=(int)session.getAttribute("uid");
		if(progress==100)
		{
			Completetask c=new Completetask();
			Task t=new Task();
			if(c.insertcompletetask( tid, uid)==1 && x.delete(tid, uid)==1 && t.updatestate(tid)==1) {
				response.sendRedirect(request.getContextPath()+"/yonghu.jsp");
			}
			else {
				response.sendRedirect(request.getContextPath()+"/updateprogress_failure.jsp");
			}
			
		}
		else
		{
			if(x.updateprogress(progress, tid, uid)==1) {
				response.sendRedirect(request.getContextPath()+"/user.jsp");
			}
			else {
				response.sendRedirect(request.getContextPath()+"/updateprogress_failure.jsp");
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

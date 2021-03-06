package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Alreadytask;

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
		double progress1=(double)session.getAttribute("progress");
		int tid=(int)session.getAttribute("tid");
		int uid=(int)session.getAttribute("uid");
	    int a;
		if(progress<=progress1) {
			response.sendRedirect(request.getContextPath()+"/updateprogress.jsp?a=0");
		}
		else
		{
			if(x.updateprogress(progress, tid, uid)==1) {
				response.sendRedirect(request.getContextPath()+"/updateprogress.jsp?a=1");
			}
			else {
				response.sendRedirect(request.getContextPath()+"/updateprogress.jsp?a=2");
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

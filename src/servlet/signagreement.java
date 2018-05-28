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
 * Servlet implementation class signagreement
 */
@WebServlet("/signagreement")
public class signagreement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signagreement() {
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
		String agreement=(String)session.getAttribute("agreement");
		int tid=(int)session.getAttribute("tid");
		int uid=(int)session.getAttribute("uid");
		Agreement a=new Agreement();
		Alreadytask k=new Alreadytask();
		Task s=new Task();
		if(a.insertagreement(tid, uid, agreement)==1 &&s.updateaccept(tid)==1 && k.insertalreadytask(tid, uid)==1) {
			response.sendRedirect(request.getContextPath()+"/user.jsp");
			
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

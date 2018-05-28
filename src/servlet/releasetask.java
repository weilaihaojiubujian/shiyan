package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.task;
import dao.Task;

/**
 * Servlet implementation class releasetask
 */
@WebServlet("/releasetask")
public class releasetask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public releasetask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 try {
		request.setCharacterEncoding("UTF-8");
		task t=new task();
		String taskname = request.getParameter("taskname");
		String introduce = request.getParameter("introduce");
		String p = request.getParameter("price");
		String d = request.getParameter("date");
		
		double price=Double.parseDouble(p);
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date = dateFormat.parse(d); 
	
		t.setDate(date);
		t.setIntroduce(introduce);
		t.setPrice(price);
		t.setTaskname(taskname);
		HttpSession session = request.getSession(); 
		int uid=(int)session.getAttribute("uid");
		Task s=new Task();
		if(s.inserttask(t,uid,session)==0)
		{
			session.setAttribute("taskname",taskname);
			session.setAttribute("introduce",introduce);
			session.setAttribute("price",price);
			session.setAttribute("date",date);
		
			response.sendRedirect(request.getContextPath()+"/releasetask_success.jsp");
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/releasetask_failure.jsp");
		}
		 }catch (ParseException e) {
            e.printStackTrace();
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

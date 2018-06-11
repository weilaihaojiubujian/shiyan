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
import net.sf.json.JSONArray;

/**
 * Servlet implementation class searchreleasetask
 */
@WebServlet("/searchreleasetask")
public class searchreleasetask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchreleasetask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        task t=new task();
		String key=request.getParameter("key");
		int k=Integer.parseInt(key);
		String keyvalue=request.getParameter("keyvalue");
		
        HttpSession session = request.getSession(); 
        
        Task s=new Task();
	    
	        	
	    int uid=(int)session.getAttribute("uid");
	     
	    List<String> listtask=(List<String>)s.selectsimilarreleasetask(uid,keyvalue,k);
	    System.out.println(listtask);
		
		response.getWriter().write(JSONArray.fromObject(listtask).toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

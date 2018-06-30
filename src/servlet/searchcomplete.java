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
 * Servlet implementation class searchcomplete
 */
@WebServlet("/searchcomplete")
public class searchcomplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchcomplete() {
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
        String keyword=request.getParameter("keyword");
        System.out.println(keyword);
        HttpSession session = request.getSession(); 
        String username=null;
        username=(String) session.getAttribute("username");
        int uid=0;
        if(username!=null) {
        	
    		uid=(int)session.getAttribute("uid");
        }
       
       
		System.out.println(uid);
		
		Task s=new Task();
			
		List<String> listsearchcompletetask=(List<String>) s.selectsimilarcomplete(uid,keyword);
		System.out.println(listsearchcompletetask);
		response.getWriter().write(JSONArray.fromObject(listsearchcompletetask).toString());
			
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

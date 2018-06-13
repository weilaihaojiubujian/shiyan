package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.Task;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class searchcompletetask
 */
@WebServlet("/searchcompletetask")
public class searchcompletetask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchcompletetask() {
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
        String key=request.getParameter("key");
		int k=Integer.parseInt(key);
		String keyvalue=request.getParameter("keyvalue");
		HttpSession session = request.getSession(); 
	    String username=null;
	     username=(String) session.getAttribute("username");
	     int uid=0;
	     if(username!=null) {
	        	
	    		uid=(int)session.getAttribute("uid");
	        }
	       
	
		
	   if(uid!=0) {

		   Task s=new Task();
			List<String> listcompletetask=s.selectsimilarcompletetask(uid,keyvalue,k);
				
			System.out.println(listcompletetask);
			
			response.getWriter().write(JSONArray.fromObject(listcompletetask).toString());
			
	   }
	   else
	   {
		   Task s=new Task();
			List<String> listcompletetask=s.selectallsimilarcompletetask(keyvalue,k);
			 
					
			System.out.println(listcompletetask);
			
			response.getWriter().write(JSONArray.fromObject(listcompletetask).toString());
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

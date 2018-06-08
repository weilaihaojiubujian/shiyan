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
 * Servlet implementation class checkalreadytaskbyuser
 */
@WebServlet("/checkalreadytaskbyuser")
public class checkalreadytaskbyuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkalreadytaskbyuser() {
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
        String keyword=request.getParameter("key");
        HttpSession session = request.getSession(); 
 		int k=Integer.parseInt(keyword); 
		Task s=new Task();
		List<String> listalreadytask=s.selectalreadytask(k);
		System.out.println(listalreadytask);
		response.getWriter().write(JSONArray.fromObject(listalreadytask).toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

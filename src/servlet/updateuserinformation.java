package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.User;

/**
 * Servlet implementation class updateuserinformation
 */
@WebServlet("/updateuserinformation")
public class updateuserinformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuserinformation() {
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
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String bankaccount = request.getParameter("bankaccount");
		String card = request.getParameter("card");
		HttpSession session = request.getSession(); 
		int uid=(int)session.getAttribute("uid");
		User a=new User();
		if(a.updateuserinformation(username, address, bankaccount, card, uid)==1) {
			response.sendRedirect(request.getContextPath()+"/user.jsp?a=5");
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

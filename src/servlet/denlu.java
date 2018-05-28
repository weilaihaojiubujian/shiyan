package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Administrator;
import dao.User;
import bean.user;

/**
 * Servlet implementation class denlu
 */
@WebServlet("/denlu")
public class denlu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public denlu() {
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
		user u = new user();
		String user = request.getParameter("user");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		u.setUsername(username);
		u.setPassword(password);
		HttpSession session = request.getSession(); 
		
		User h=new User();
		if(user.equals("”√ªß")) {
			if(h.selectusername(u.getUsername(),u.getPassword(),session)==1)
			{
				session.setAttribute("username",username);
				session.setAttribute("password",password);
				response.sendRedirect(request.getContextPath()+"/denlu_success.jsp");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/denlu_failure.jsp");
			}
		}
		else
		{
			Administrator a=new Administrator();
			if(a.selectusername(u.getUsername(),u.getPassword(),session)==1)
			{
				session.setAttribute("ausername",username);
				session.setAttribute("apassword",password);
				response.sendRedirect(request.getContextPath()+"/administratordenlu_success.jsp");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/denlu_failure.jsp");
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

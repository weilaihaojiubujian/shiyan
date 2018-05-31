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
 * Servlet implementation class addmoney
 */
@WebServlet("/addmoney")
public class addmoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addmoney() {
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
		String p = request.getParameter("addmoney");
		double addmoney=Double.parseDouble(p);
		HttpSession session = request.getSession(); 
		int uid=(int)session.getAttribute("uid");
		double money=(double)session.getAttribute("money");
		addmoney+=money;
		User u=new User();
		if(u.updateaddmoney(uid,addmoney,session)==1) {
			response.sendRedirect(request.getContextPath()+"/addmoney_success.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/addmoney_failure.jsp");
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

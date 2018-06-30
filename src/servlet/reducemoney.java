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
 * Servlet implementation class reducemoney
 */
@WebServlet("/reducemoney")
public class reducemoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reducemoney() {
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
		String p = request.getParameter("reducemoney");
		double reducemoney=Double.parseDouble(p);
		HttpSession session = request.getSession(); 
		int uid=(int)session.getAttribute("uid");
		double money=(double)session.getAttribute("money");
		money-=reducemoney;
		User u=new User();
		int b;
		if(u.updatereducemoney(uid,money,session)==1) {
			response.sendRedirect(request.getContextPath()+"/userinformation.jsp?b=1");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/userinformation.jsp?b=0");
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

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Sign;

/**
 * Servlet implementation class endsignin
 */
@WebServlet("/endsignin")
public class endsignin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public endsignin() {
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
		HttpSession session = request.getSession(); 
		int uid=(int)session.getAttribute("uid");
		int tid=(int)session.getAttribute("tid");
		Sign a=new Sign();
		int b;
		if(a.updateendsignin(tid, uid)==1) {
			response.sendRedirect(request.getContextPath()+"/signin.jsp?b=2");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/signin.jsp?b=3");
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

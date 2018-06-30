package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.agreement;
import dao.Agreement;

/**
 * Servlet implementation class releaseagreement
 */
@WebServlet("/releaseagreement")
public class releaseagreement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public releaseagreement() {
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
		String agreementname = request.getParameter("agreementname");
		String agreementintroduce = request.getParameter("agreementintroduce");
		agreement a=new agreement();
		a.setAgreementintroduce(agreementintroduce);
		a.setAgreementname(agreementname);
		
		HttpSession session = request.getSession(); 
		int tid=(int)session.getAttribute("tid");
		int b;
		Agreement q=new Agreement();
		if(q.insertagreement(a,tid)==1)
		{
			session.setAttribute("agreementname",agreementname);
			session.setAttribute("agreementintroduce",agreementintroduce);
	
		
			response.sendRedirect(request.getContextPath()+"/agreement.jsp?b=1");
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/agreement.jsp?b=0");
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

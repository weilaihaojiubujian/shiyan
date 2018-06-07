package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener implements HttpSessionListener {

	  private int count = 0; //������  
	       
	   /** 
	     * session���󴴽�֮�����������HttpSessionEvent�� 
	     * ����Ȼ�����sessionCreated������ 
	     */  
	    public void sessionCreated(HttpSessionEvent arg0) {  
	       System.out.println("sessionCreated start ...");  
	         count ++;  
	         //ͨ���¼�����(HttpSessionEvent)�ҵ�session  
	        HttpSession session = arg0.getSession();  
	        ServletContext sctx = session.getServletContext();  
	       //������count�󶨵�servletContext��������������ʱ���ʡ�  
	         sctx.setAttribute("count",count);  
	     }  
	 
	     /** 
	     * ����������session����֮�󣬻����sessionDestroyed�� 
	     * ���� 
	    */  
	     public void sessionDestroyed(HttpSessionEvent arg0) {  
	        System.out.println("sessionDestoyed start ...");  
	        count --;  
	        //ͨ���¼�����(HttpSessionEvent)�ҵ�session  
	        HttpSession session = arg0.getSession();  
	        ServletContext sctx = session.getServletContext();  
	       //������count�󶨵�servletContext��������������ʱ���ʡ�  
	        sctx.setAttribute("count",count);  
	   }  



}

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

	  private int count = 0; //计数器  
	       
	   /** 
	     * session对象创建之后，容器会产生HttpSessionEvent事 
	     * 件，然后调用sessionCreated方法。 
	     */  
	    public void sessionCreated(HttpSessionEvent arg0) {  
	       System.out.println("sessionCreated start ...");  
	         count ++;  
	         //通过事件对象(HttpSessionEvent)找到session  
	        HttpSession session = arg0.getSession();  
	        ServletContext sctx = session.getServletContext();  
	       //将人数count绑定到servletContext，这样，可以随时访问。  
	         sctx.setAttribute("count",count);  
	     }  
	 
	     /** 
	     * 容器在销毁session对象之后，会调用sessionDestroyed方 
	     * 法。 
	    */  
	     public void sessionDestroyed(HttpSessionEvent arg0) {  
	        System.out.println("sessionDestoyed start ...");  
	        count --;  
	        //通过事件对象(HttpSessionEvent)找到session  
	        HttpSession session = arg0.getSession();  
	        ServletContext sctx = session.getServletContext();  
	       //将人数count绑定到servletContext，这样，可以随时访问。  
	        sctx.setAttribute("count",count);  
	   }  



}

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

public class Administrator {
	private static Connection conn = null;
	 private static Statement stmt = null;
	 private static  ResultSet rs=null;

	 
	 //����Ա�ĵ�½��֤
	public int selectusername(String name,String pass,HttpSession session) {
		
		 
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "SELECT username,password,id FROM administrator where username='"+name+"' and password='"+pass+"'" ;
			      rs = stmt.executeQuery(sql);
			    
			   
			      int i=0;
			      if(rs.next())
			      {
			    	  i=1;
			    	  int aid=rs.getInt("id");
			    	  System.out.println("����Ա��½�ɹ�");
			    	  session.setAttribute("aid", aid);	
				         
			          return i;
			      }
			      else
					{
						 System.out.println("û���˺ţ��޷���½");
						 
						 return i;
					}
			  
			 
		      
	  }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
		   
		   Catch c=new Catch();
		   c.close(rs, stmt);
	   }//end try
			return 0;
	  }
}

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

public class Administrator {

	public int selectusername(String name,String pass,HttpSession session) {
		
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs =null;	
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
			    	  System.out.println("管理员登陆成功");
			    	  session.setAttribute("aid", aid);	
				         
			          return i;
			      }
			      else
					{
						 System.out.println("没有账号，无法登陆");
						 
						 return i;
					}
			  
			 
		      
	  }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
		   
	      //finally block used to close resources
		   if (rs!= null) {
				try {
					rs.close();
					rs= null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}//end finally try
	   }//end try
			return 0;
	  }
}

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import bean.task;
import bean.user;

public class Sign {

	public int insertbeginsignin(int tid,int uid) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			   
			    
				  java.util.Date day=new java.util.Date();    

				  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				  System.out.println(df.format(day));   
				
			      int i=0;
			    
			      String sql_1="INSERT INTO sign(tid,uid,start)" +
			                   " VALUES ('"+tid+"', '"+uid+"','"+df.format(day)+"')";//插入操作...
			      stmt.executeUpdate(sql_1); 
			      i=1;
			      return i;
			  
			    
			   

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
			}
	   }//end try
			return 0;
	}
	public int updateendsignin(int tid,int uid) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			   
			    
				  java.util.Date day=new java.util.Date();    

				  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				  System.out.println(df.format(day));   
				
			      int i=0;
			      String sql_2="UPDATE sign SET stop='"+df.format(day)+"' WHERE tid='"+tid+"' and uid='"+uid+"' and stop is null and start is not null ";
		
			      stmt.executeUpdate(sql_2); 
			      i=1;
			      return i;
			  
			    
			   

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
			}
	   }//end try
			return 0;
	}
	 public int selectalluid(HttpSession session) {
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "SELECT * FROM sign where stop is null and start is not null  ";
			      rs = stmt.executeQuery(sql);
			    
			      int i=0;
			      List listuid=new ArrayList();
			      while(rs.next()) {
			     
		              int uid=rs.getInt("uid");
		       
			          System.out.println(uid);
		              listuid.add(uid);
			          i++;
			          
			      }
			      session.setAttribute("listuid", listuid);	
			      return i;

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
			}
	   }//end try
			return 0;
			
	}
}

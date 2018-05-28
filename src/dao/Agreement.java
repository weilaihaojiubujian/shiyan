package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import bean.agreement;

public class Agreement {

	public int insertagreement(agreement a,int tid) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			      String agreementname = a.getAgreementname();
				  String agreementintroduce = a.getAgreementintroduce();
			      sql = "INSERT INTO agreement(agreementname,tid,agreementintroduce)" +
		                   " VALUES ('"+agreementname+"', '"+tid+"','"+agreementintroduce+"')";//插入操作...
			      stmt.executeUpdate(sql); 
			     
			      int i=1;
			  
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
	
	public int selectagreement(int tid,HttpSession session) {
		
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs =null;	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "SELECT * FROM agreement where tid='"+tid+"'" ;
			      rs = stmt.executeQuery(sql);
			    
			   
			      int i=0;
			      if(rs.next())
			      {
			    	  i=1;
			    	  int aid=rs.getInt("id");
			    	  String agreementname = rs.getString("agreementname");
					  String agreementintroduce = rs.getString("agreementintroduce");
			    	  session.setAttribute("aid",aid);	
			    	  session.setAttribute("agreementname",agreementname);	
			    	  session.setAttribute("agreementintroduce",agreementintroduce);	
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

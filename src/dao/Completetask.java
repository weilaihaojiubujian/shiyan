package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import bean.task;

public class Completetask {

	public int insertcompletetask(int tid,int uid) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			 
			    
			     
			    
			      String sql_1="INSERT INTO completetask(u_id,t_id)" +
		                   " VALUES ('"+uid+"', '"+tid+"')";//�������...
		          stmt.executeUpdate(sql_1); 
		 
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
			// �ͷ�������
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
	public int selecttid(int uid,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			    
			      sql = "SELECT t_id FROM completetask where u_id='"+uid+"'  ";
			      rs = stmt.executeQuery(sql);
			      List listtid=new ArrayList();
			      int i=0;
			
			      while(rs.next()) {
			    	  int tid=rs.getInt("t_id");
			    	  listtid.add(tid);
			    	 
			          i++;
			      }
			      if(i!=0)
			      {
			    	  session.setAttribute("listtid", listtid);
			      }
			     
			  
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
			// �ͷ�������
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
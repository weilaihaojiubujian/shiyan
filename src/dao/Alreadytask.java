package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import bean.task;

public class Alreadytask {
	 private static Connection conn = null;
	 private static Statement stmt = null;
	 private static  ResultSet rs=null;
	 
	 //�û��������񣬲��뵽�ѽ����������
	public int insertalreadytask(int tid,int uid) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			 
			    
			     
			    
			      String sql_1="INSERT INTO alreadytask(u_id,t_id,progress)" +
		                   " VALUES ('"+uid+"', '"+tid+"',0)";//�������...
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
		   
		   Catch c=new Catch();
		   c.close(rs, stmt);
	   }//end try
			return 0;
	}
	
	//�û������������
	public int updateprogress(double progress,int tid,int uid) {
		
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			    
			     sql="UPDATE alreadytask SET progress='"+progress+"' WHERE u_id='"+uid+"'and t_id='"+tid+"' ";
                  
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
		   
		   Catch c=new Catch();
		   c.close(rs, stmt);
	   }//end try
			return 0;
	}
	
	//�鿴�û��Ƿ��Ѿ�����������
	public int selectall(int uid) {
		
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			    
			      sql = "SELECT * FROM alreadytask where u_id='"+uid+"' and progress<100 ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			
			      if(!rs.next()) {
			    	 
			          i=1;
			          return i;
			      }
			      else
			      {
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

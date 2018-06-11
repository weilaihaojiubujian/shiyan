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
	 private static Connection conn = null;
	 private static Statement stmt = null;
	 private static  ResultSet rs=null;

	 //用户完成任务
	public int insertcompletetask(int tid,int uid) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			 
			    
			     
			    
			      String sql_1="INSERT INTO completetask(u_id,t_id)" +
		                   " VALUES ('"+uid+"', '"+tid+"')";//插入操作...
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
	

}

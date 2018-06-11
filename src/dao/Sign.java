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
	private static Connection conn = null;
	 private static Statement stmt = null;
	 private static  ResultSet rs=null;
	 
	 //开始签到，开始时间
	public int insertbeginsignin(int tid,int uid) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			   
			    
				  java.util.Date day=new java.util.Date();    

				  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				  System.out.println(df.format(day));   
				  String sql;
			      sql = "SELECT * FROM sign where tid='"+tid+"' and uid='"+uid+"' and stop is null and start is not null";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      if(!rs.next())
			      {
			    	 String sql_1="INSERT INTO sign(tid,uid,start)" +
			                   " VALUES ('"+tid+"', '"+uid+"','"+df.format(day)+"')";//插入操作...
			         stmt.executeUpdate(sql_1); 
			         i=1;
			      }
			      
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
	
	
	//结束签到，更新结束时间
	public int updateendsignin(int tid,int uid) {
	
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
		   
		   Catch c=new Catch();
		   c.close(rs, stmt);
	   }//end try
			return 0;
	}
	
}

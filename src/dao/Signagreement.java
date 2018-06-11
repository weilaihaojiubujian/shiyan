package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Statement;

public class Signagreement {
	 private static Connection conn = null;
	 private static Statement stmt = null;
	 private static  ResultSet rs=null;

	 
	 //用户签订合同
	public int insertsignagreement (int uid,int aid) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			   
		
				
			      int i=0;
			    
			      String sql_1="INSERT INTO signagreement(uid,aid)" +
			                   " VALUES ('"+uid+"', '"+aid+"')";//插入操作...
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
		   
		   Catch c=new Catch();
		   c.close(rs, stmt);
	   }//end try
			return 0;
	}
}

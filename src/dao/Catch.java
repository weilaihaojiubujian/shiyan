package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Catch {


	 public  void close(ResultSet rs,Statement stmt){
	        if(rs!=null){
	            try {
	            	rs.close();
	            	
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            rs= null;
	        }
	        if(stmt!=null){
	            try {
	            	stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            stmt=null;
	        }
	       
	          
	                try {
						connection.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           
	        
	      
}
}
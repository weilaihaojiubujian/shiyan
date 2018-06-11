package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.sql.*;
import com.mysql.jdbc.Statement;

import bean.task;

public class Task {
	 private static Connection conn = null;
	 private static Statement stmt = null;
	 private static  ResultSet rs=null;

	 
	 //用户发布任务
	public int inserttask(task t,int uid,HttpSession session) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      String taskname = t.getTaskname();
				  String introduce = t.getIntroduce();
				
				  double price=t.getPrice();
				  java.util.Date dat = new java.util.Date();
			      SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
			      java.util.Date d=dateFormat.parse(dateFormat.format(dat)); 
			      
				
				  long q = d.getTime();
				  java.sql.Date date = new java.sql.Date(q);
			      sql = "SELECT * FROM task where taskname='"+taskname+"' and introduce='"+introduce+"'and price='"+price+"' and releaseid='"+uid+"' ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      if(!rs.next()) {
			    	  String sql_1="INSERT INTO task(taskname,introduce,price,date,releaseid)" +
			                   " VALUES ('"+taskname+"', '"+introduce+"','"+price+"','"+date+"','"+uid+"')";//插入操作...
			          stmt.executeUpdate(sql_1); 
			          String sql_2 = "SELECT * FROM task where taskname='"+taskname+"' and introduce='"+introduce+"'and price='"+price+"' ";
				      rs = stmt.executeQuery(sql_2);
				      rs.next();
				      int tid=rs.getInt("id");
				      session.setAttribute("tid",tid);
			          return i;
			      }
			      else
					{
						 System.out.println("有相同的任务存在，无法发布");
						i=1;
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
	
	
	
	//用户或管理员查看未接受的任务
	public List<String> selectaccept1(int k) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      int x=(k-1)*4;
				
				 String sql_1 = "SELECT COUNT(*) FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask) ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			     
			      
			      sql = "SELECT taskname,task.id FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask) limit "+x+",4 ";
			      rs = stmt.executeQuery(sql);
			    
			      String m=String.valueOf(max);
			      List<String> listtask=new ArrayList<String>();
			      listtask.add(m);
			      while(rs.next()) {
			    	
			    	  String taskname =rs.getString("taskname");
					
					
					  int tid=rs.getInt("id");
					  String t=String.valueOf(tid);
					
				
					
					
					  listtask.add(t);
					  listtask.add(taskname);
				
			          
			      }
			     
			      return listtask;
			    
			   

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
			return null;
	}
	
	//查看已接受任务的信息
	public int selecttall(int uid,HttpSession session) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			      sql = "SELECT task.*,progress FROM task,alreadytask where task.id=t_id and u_id='"+uid+"'  ";
			      rs = stmt.executeQuery(sql);
			    
			      task h=new task();
			      if(rs.next()) {
			    	
			    	  
			    	  int tid=rs.getInt("id");
			    	  String taskname =rs.getString("taskname");
					  String introduce = rs.getString("introduce");
					  double progress=rs.getDouble("progress");
					  double price=rs.getDouble("price");
					
					  java.util.Date date=rs.getDate("date");
					  
					  h.setDate(date);
					  h.setIntroduce(introduce);
					  h.setPrice(price);
					  h.setTaskname(taskname);
					  h.setTid(tid);
					 
					  session.setAttribute("progress", progress);
					  h.setProgress(progress);
					 
					  session.setAttribute("tid", tid);
					  session.setAttribute("alreadytask", h);
			       
			          return 1;
			      }
			      else
			      {
			    	  return 0;
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
	
	//用户查看第几页的已完成任务
	public List<String> selectcompletetask(int uid,int k) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      int x=(k-1)*4;
					
					 String sql_1 = "SELECT COUNT(*) FROM task,completetask where task.id=t_id and u_id='"+uid+"' ";
				      rs = stmt.executeQuery(sql_1);
				      rs.next();
				      int size=rs.getInt("COUNT(*)");
				      System.out.println(size);
				      int pageSize=4;
				      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
				  
			     
			      
			      List<String> listcompletetask=new ArrayList<String>();
			     
			      sql = "SELECT task.id,task.taskname FROM task,completetask where task.id=t_id and u_id='"+uid+"' limit "+x+",4 ";
			      rs = stmt.executeQuery(sql);
			      String m=String.valueOf(max);
			      listcompletetask.add(m);
			    
			    	  
				  while(rs.next()) {
				    	  
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
				    	  String t=String.valueOf(tid);
				
						
						
				    	  listcompletetask.add(t);
				    	  listcompletetask.add(taskname);
						
				          
				  }
			    
			     
			    
			  
			      return listcompletetask;
			    
			   

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
			return null;
	}
	
	
	//用户查看第几页的发布的任务
	public List<String> selectreleasetask(int k,int uid) {
		
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  int x=(k-1)*4;
				  String sql_1 = "SELECT COUNT(*) FROM task where  releaseid='"+uid+"' ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			     
			    
			     
			      sql = "SELECT id,taskname FROM task where  releaseid='"+uid+"' limit "+x+",4 ";
			      rs = stmt.executeQuery(sql);
			      String m=String.valueOf(max);
			    
			   
			      List<String> listtask=new ArrayList<String>();
			      listtask.add(m);
			      while(rs.next()) {
			    	
			    	  String taskname =rs.getString("taskname");
					
					
					  int tid=rs.getInt("id");
					  String t=String.valueOf(tid);
					
				
					
					
					  listtask.add(t);
					  listtask.add(taskname);
					
			          
			      }
			    
			      return listtask;
			    
			   

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
			return null;
	}
	
	//管理员查看第几页的已完成任务
	public List<String> selectallcompletetask(int k) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;

				  int x=(k-1)*4;
				  String sql_1 = "SELECT COUNT(*) FROM task,completetask where task.id=t_id ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			     
			    
			      sql = "SELECT task.id,task.taskname FROM task,completetask where task.id=t_id limit "+x+",4 ";
			      rs = stmt.executeQuery(sql);
			      
			      List<String> listcompletetask=new ArrayList<String>();
			      String m=String.valueOf(max);
			      listcompletetask.add(m);  
				  while(rs.next()) {
				    	  
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
				    	  String t=String.valueOf(tid);
							
							
							
				    	  listcompletetask.add(t);
				    	  listcompletetask.add(taskname);
						
				          
				  }
			  
			 
			     
			    
			  
			      return listcompletetask;
			    
			   

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
			return null;
	}
	
	//管理员查看第几页的已完成的任务
	public List<String> selectalreadytask(int k) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      int x=(k-1)*4;
				
				 String sql_1 = "SELECT COUNT(*) FROM task where id in (SELECT t_id FROM alreadytask ) ";
				 rs = stmt.executeQuery(sql_1);
				 rs.next();
				 int size=rs.getInt("COUNT(*)");
				 System.out.println(size);
				 int pageSize=4;
				 int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
				  
			    
			      sql = "SELECT id,taskname FROM task where id in (SELECT t_id FROM alreadytask ) limit "+x+",4 ";
			      rs = stmt.executeQuery(sql);
			    
			      String m=String.valueOf(max);
			      List<String> listalreadytask=new ArrayList<String>();
			      listalreadytask.add(m);
			      while(rs.next()) {
			    	 
			    	  String taskname =rs.getString("taskname");
				
					
					  int tid=rs.getInt("id");
					 
				
					  String t=String.valueOf(tid);
						
						
						
						
					  listalreadytask.add(t);
					  listalreadytask.add(taskname);
					
			          
			      }
			      
			      return listalreadytask;
			    
			   

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
			return null;
	}
	
	//用户查看任务的信息
	public int selecttid(int tid,HttpSession session) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT * FROM task where id='"+tid+"' ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			     
			      task h=new task();
			      while(rs.next()) {
			    	
			    	  String taskname =rs.getString("taskname");
					  String introduce = rs.getString("introduce");
					 
					 
					  double price=rs.getDouble("price");
				
					  java.util.Date date=rs.getDate("date");
					
					  h.setDate(date);
					  h.setIntroduce(introduce);
					  h.setPrice(price);
					  h.setTaskname(taskname);
					  h.setTid(tid);
					
					
					  i++;
					
			      }
			      
			      session.setAttribute("task",h);
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
	
	//管理员查看相似的未接受的任务名
	public List<String> selectsimilar(String keyword) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask) and task.taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      
			      List<String> listsearchtask=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	 
			    	  String taskname =rs.getString("taskname");
					
					
					
					
					
				
				
					
					  listsearchtask.add(taskname );
				
			          
			      }
			      
			      return listsearchtask;
			    
			   

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
			return null;
	}
	
	//用户查看自己相似的发布的任务
	public List<String> selectsimilarrelease(int uid,String keyword) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task where releaseid='"+uid+"' and taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			
			      List<String> listsearchreleasetask=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	 
			    	  String taskname =rs.getString("taskname");
				
					
			    	  listsearchreleasetask.add(taskname );
				
			          
			      }
			      
			      return listsearchreleasetask;
			    
			   

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
			return null;
	}
	
	//用户查看相似的第几页的发布的任务
	public List<String> selectsimilarreleasetask(int uid,String keyword,int k) {
		
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      int x=(k-1)*4;
			      String sql_1 = "SELECT COUNT(*) FROM task where  releaseid='"+uid+"' and task.taskname like '%"+keyword+"%'  ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			  
			    
			      sql = "SELECT taskname,id FROM task where  releaseid='"+uid+"' and task.taskname like '%"+keyword+"%'  limit "+x+",4  ";
			      rs = stmt.executeQuery(sql);
			     
			      List<String> listtask=new ArrayList<String>();
			      String m=String.valueOf(max);
			      listtask.add(m);
			      while(rs.next()) {
			    	
			    	  String taskname =rs.getString("taskname");
					
					
					  int tid=rs.getInt("id");
					  String t=String.valueOf(tid);
					
				
					
					
					  listtask.add(t);
					  listtask.add(taskname);
				
			          
			      }
			     
			      return listtask;
			    
			   

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
			return null;
	}
	
	//管理员查看相似的第几页的未接受的任务
	public List<String> selectsimilartask(String keyvalue,int key) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      String sql_1 = "SELECT COUNT(*) FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask) and task.taskname like '%"+keyvalue+"%'  ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			    
				  
			     int x=(key-1)*4;
			      sql = "SELECT taskname,id FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask) and task.taskname like '%"+keyvalue+"%'  limit "+x+",4  ";
			      rs = stmt.executeQuery(sql);
			    
			  
			      String m=String.valueOf(max);  
			      List<String> listtask=new ArrayList<String>();
			      listtask.add(m);  
			      while(rs.next()) {
			    	
			    	  String taskname =rs.getString("taskname");
					
					
					  int tid=rs.getInt("id");
					  String t=String.valueOf(tid);
					
				
					
					
					  listtask.add(t);
					  listtask.add(taskname);
					
			          
			      }
			      
			      return listtask;
			    
			   

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
			return null;
	}
	
	//用户查看相似的已完成任务名
	public List<String> selectsimilarcomplete(int uid,String keyword) {
		
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task,completetask where task.id=t_id and u_id='"+uid+"' and task.taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			     
			      List<String> listsearchcompletetask=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	
			    	  String taskname =rs.getString("taskname");
		
				
					
			    	  listsearchcompletetask.add(taskname );
				
			          
			      }
			     
			      return listsearchcompletetask;
			    
			   

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
			return null;
	}
	
	//管理员查看相似的已完成的任务名
	public  List<String> selectallsimilarcomplete(String keyword) {

			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task,completetask where task.id=t_id  and task.taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			   
			      List<String> listsearchcompletetask=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	
			    	  String taskname =rs.getString("taskname");
					
			listsearchcompletetask.add(taskname );
					
			          
			      }
			     
			      return listsearchcompletetask;
			    
			   

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
			return null;
	}
	
	//用户查看自己的相似的第几页的已完成任务
	public List<String> selectsimilarcompletetask(int uid,String keyword,int k) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      String sql_1 = "SELECT COUNT(*)  FROM task,completetask where task.id=t_id and u_id='"+uid+"' and task.taskname like '%"+keyword+"%'   ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			    
				  
			     int x=(k-1)*4;
				  
			    
			      sql = "SELECT taskname,task.id  FROM task,completetask where task.id=t_id and u_id='"+uid+"' and task.taskname like '%"+keyword+"%'  limit "+x+",4  ";
			      rs = stmt.executeQuery(sql);
			   
			      List<String> listcompletetask=new ArrayList<String>();
			      String m=String.valueOf(max);
			      listcompletetask.add(m);
				  while(rs.next()) {
				    	
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
						
				    	  String t=String.valueOf(tid);
							
							
							
				    	  listcompletetask.add(t);
				    	  listcompletetask.add(taskname);
					
				          
				  }
			      
			      
			     
			    
			  
			      return listcompletetask;
			    
			   

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
			return null;
	}
	
	//管理员查看自己的相似的第几页的已完成任务
	public  List<String> selectallsimilarcompletetask(String keyword,int k) {
		
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      int x=(k-1)*4;
				  String sql_1 = "SELECT COUNT(*) FROM task,completetask where task.id=t_id  and task.taskname like '%"+keyword+"%' ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
				  
			    
			      sql = "SELECT taskname,task.id  FROM task,completetask where task.id=t_id  and task.taskname like '%"+keyword+"%'  limit "+x+",4  ";
			      rs = stmt.executeQuery(sql);
			  
			      List<String> listcompletetask=new ArrayList<String>();
			      String m=String.valueOf(max);
			      listcompletetask.add(m);  
			 	  
				  while(rs.next()) {
				    	 
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
						
				    	  String t=String.valueOf(tid);
							
							
							
				    	  listcompletetask.add(t);
				    	  listcompletetask.add(taskname);
						
				          
				  }
			      
			      
			     
			    
			  
			      return listcompletetask;
			    
			   

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
			return null;
	}
	
	//管理员通过搜索框查看相似的任务名
	public List<String> selectsimilaralready(String keyword) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task,alreadytask where task.id=t_id  and task.taskname like '%"+keyword+"%'  ";
			      rs = stmt.executeQuery(sql);
			     
			      List<String> listsearchalready=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	
			    	  String taskname =rs.getString("taskname");
		
					
			    	  listsearchalready.add(taskname );
				
			          
			      }
			      
			      return listsearchalready;
			    
			   

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
			return null;
	}
	
	//管理员查看相似的第几页的已接受任务
	public List<String> selectsimilaralreadytask(String keyword,int k) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      int x=(k-1)*4;
					
				 String sql_1 = "SELECT COUNT(*) FROM task,alreadytask where task.id=t_id  and task.taskname like '%"+keyword+"%' ";
				 rs = stmt.executeQuery(sql_1);
				 rs.next();
				 int size=rs.getInt("COUNT(*)");
				 System.out.println(size);
				 int pageSize=4;
				 int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
				  
			    
			      sql = "SELECT taskname,task.id FROM task,alreadytask where task.id=t_id  and task.taskname like '%"+keyword+"%' limit "+x+",4 ";
			      rs = stmt.executeQuery(sql);
			     
			      String m=String.valueOf(max);
			      List<String> listalreadytask=new ArrayList<String>();
			      listalreadytask.add(m);
				  while(rs.next()) {
				    	
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
						

						  String t=String.valueOf(tid);
							
							
							
							
						  listalreadytask.add(t);
						  listalreadytask.add(taskname);
						
				          
				  }
			      
			    return listalreadytask;
			   

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
			return null;
	}
}

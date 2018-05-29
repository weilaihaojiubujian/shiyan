package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.sql.*;
import com.mysql.jdbc.Statement;

import bean.task;

public class Task {

	public int inserttask(task t,int uid,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      String taskname = t.getTaskname();
				  String introduce = t.getIntroduce();
				
				  double price=t.getPrice();
				  java.util.Date da =t.getDate();
				  long q = da.getTime();
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
	public int selectaccept(HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT * FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask)";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<task> listtask=new ArrayList<task>();
			    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
					
					
					  int tid=rs.getInt("id");
					
					
				
					  h.setTaskname(taskname);
					  h.setTid(tid);
				
					
					  listtask.add(h);
					  i++;
			          
			      }
			      session.setAttribute("listtask", listtask);
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
	
	public int updateaccept(int tid) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			    
		          String sql_2="UPDATE task SET accept=1 WHERE id='"+tid+"' ";
                  
		          stmt.executeUpdate(sql_2); 
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
	public int selecttall(int uid,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			      sql = "SELECT task.*,progress FROM task,alreadytask where task.id=t_id and u_id='"+uid+"'  ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<task> alreadytask=new ArrayList<task>();
			      if(rs.next()) {
			    	  task h=new task();
			    	  
			    	  int tid=rs.getInt("id");
			    	  String taskname =rs.getString("taskname");
					  String introduce = rs.getString("introduce");
					  double progress=rs.getDouble("progress");
					  double price=rs.getDouble("price");
					  int accept=rs.getInt("accept");
					  java.util.Date date=rs.getDate("date");
					  
					  h.setDate(date);
					  h.setIntroduce(introduce);
					  h.setPrice(price);
					  h.setTaskname(taskname);
					  h.setTid(tid);
					  h.setAccept(accept);
					
					  h.setProgress(progress);
					  alreadytask.add(h);
					  session.setAttribute("tid", tid);
					  session.setAttribute("alreadytask", alreadytask);
			          i=1;
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
	public int selectcompletetask(int uid,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			     
			      List<task> listcompletetask=new ArrayList<task>();
			      int j=0;
			      sql = "SELECT task.id,task.taskname FROM task,completetask where task.id=t_id and u_id='"+uid+"' ";
			      rs = stmt.executeQuery(sql);
			      
			    
			    	  
				  while(rs.next()) {
				    	  task h=new task();
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
						
				
						  h.setTaskname(taskname);
						  h.setTid(tid);
						
						  listcompletetask.add(h);
						  j++;
				          
				  }
			      session.setAttribute("listcompletetask",listcompletetask);
			 
			     
			    
			  
			      return j;
			    
			   

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
	public int updatestate(int tid) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			    
		          String sql_2="UPDATE task SET state=1 WHERE id='"+tid+"' ";
                  
		          stmt.executeUpdate(sql_2); 
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
	public int selectalreadytask(HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT id,taskname FROM task where id in (SELECT t_id FROM alreadytask )";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<task> listalreadytask=new ArrayList<task>();
			    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
				
					
					  int tid=rs.getInt("id");
					 
				
					  h.setTaskname(taskname);
					  h.setTid(tid);
					
				
					  listalreadytask.add(h);
					  i++;
			          
			      }
			      session.setAttribute("listalreadytask", listalreadytask);
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
	public int selecttid(int tid,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT * FROM task where id='"+tid+"'  ";
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

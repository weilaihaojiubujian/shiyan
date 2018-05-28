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

	public int inserttask(task t,int uid) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      String taskname = t.getTaskname();
				  String introduce = t.getIntroduce();
				  String agreement =t.getAgreement();
				  double price=t.getPrice();
				  java.util.Date da =t.getDate();
				  long q = da.getTime();
				  java.sql.Date date = new java.sql.Date(q);
			      sql = "SELECT * FROM task where taskname='"+taskname+"' and introduce='"+introduce+"'and agreement='"+agreement+"'and price='"+price+"' ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      if(!rs.next()) {
			    	  String sql_1="INSERT INTO task(taskname,introduce,agreement,price,date,uid)" +
			                   " VALUES ('"+taskname+"', '"+introduce+"','"+agreement+"','"+price+"','"+date+"','"+uid+"')";//插入操作...
			          stmt.executeUpdate(sql_1); 
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
			    
				  
			    
			      sql = "SELECT * FROM task where accept=0";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<task> listtask=new ArrayList<task>();
			    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
					  String introduce = rs.getString("introduce");
					  String agreement =rs.getString("agreement");
					  int tid=rs.getInt("id");
					  double price=rs.getDouble("price");
					  int accept=rs.getInt("accept");
					  java.util.Date date=rs.getDate("date");
					
					  h.setDate(date);
					  h.setIntroduce(introduce);
					  h.setPrice(price);
					  h.setTaskname(taskname);
					  h.setTid(tid);
					  h.setAccept(accept);
					  h.setAgreement(agreement);
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
	public int selecttall(HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			      int tid=(int)session.getAttribute("tid");
		    	  double progress=(double)session.getAttribute("progress");
			      sql = "SELECT * FROM task where id='"+tid+"'  ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<task> alreadytask=new ArrayList<task>();
			      if(rs.next()) {
			    	  task h=new task();
			    	  
			    	
			    	  String taskname =rs.getString("taskname");
					  String introduce = rs.getString("introduce");
					  String agreement =rs.getString("agreement");
					  double price=rs.getDouble("price");
					  int accept=rs.getInt("accept");
					  java.util.Date date=rs.getDate("date");
					  
					  h.setDate(date);
					  h.setIntroduce(introduce);
					  h.setPrice(price);
					  h.setTaskname(taskname);
					  h.setTid(tid);
					  h.setAccept(accept);
					  h.setAgreement(agreement);
					  h.setProgress(progress);
					  alreadytask.add(h);
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
	public int selectcompletetask(HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			      List listtid=(List) session.getAttribute("listtid");
			      List<task> listcompletetask=new ArrayList<task>();
			      int j=0;
			      for(int i=0;i<listtid.size();i++)
			      {
			    	  int tid=(int) listtid.get(i);
			    	  sql = "SELECT * FROM task where id='"+tid+"'";
				      rs = stmt.executeQuery(sql);
				      if(rs.next()) {
				    	  task h=new task();
				    	  String taskname =rs.getString("taskname");
						  String introduce = rs.getString("introduce");
						  String agreement =rs.getString("agreement");
						
						  double price=rs.getDouble("price");
						
						  java.util.Date date=rs.getDate("date");
						
						  h.setDate(date);
						  h.setIntroduce(introduce);
						  h.setPrice(price);
						  h.setTaskname(taskname);
						  h.setTid(tid);
						 
						  h.setAgreement(agreement);
						  listcompletetask.add(h);
						  j++;
				          
				      }
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
			    
				  
			    
			      sql = "SELECT * FROM task where accept=1 and state=0";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<task> listalreadytask=new ArrayList<task>();
			    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
					  String introduce = rs.getString("introduce");
					  String agreement =rs.getString("agreement");
					  int tid=rs.getInt("id");
					  double price=rs.getDouble("price");
					  int accept=rs.getInt("accept");
					  java.util.Date date=rs.getDate("date");
					
					  h.setDate(date);
					  h.setIntroduce(introduce);
					  h.setPrice(price);
					  h.setTaskname(taskname);
					  h.setTid(tid);
					  h.setAccept(accept);
					  h.setAgreement(agreement);
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
}

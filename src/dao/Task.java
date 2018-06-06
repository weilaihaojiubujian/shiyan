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
	public List<String> selectaccept1(int k,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      int x=(k-1)*4;
				 int y=4;
			    
			      sql = "SELECT taskname,task.id FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask) limit "+x+",4 ";
			      rs = stmt.executeQuery(sql);
			      
			      int i=0;
			      List<String> listtask=new ArrayList<String>();
			    
			      while(rs.next()) {
			    	
			    	  String taskname =rs.getString("taskname");
					
					
					  int tid=rs.getInt("id");
					  String t=String.valueOf(tid);
					
				
					
					
					  listtask.add(t);
					  listtask.add(taskname);
					  i++;
			          
			      }
			      String sql_1 = "SELECT COUNT(*) FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask) ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			      session.setAttribute("max", max);
			      return listtask;
			    
			   

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
			return null;
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
					
					  java.util.Date date=rs.getDate("date");
					  
					  h.setDate(date);
					  h.setIntroduce(introduce);
					  h.setPrice(price);
					  h.setTaskname(taskname);
					  h.setTid(tid);
					 
					  session.setAttribute("progress", progress);
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
	public int selectreleasetask(int uid,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			     
			      List<task> listreleasetask=new ArrayList<task>();
			      int j=0;
			      sql = "SELECT id,taskname FROM task where  releaseid='"+uid+"' ";
			      rs = stmt.executeQuery(sql);
			      
			    
			    	  
				  while(rs.next()) {
				    	  task h=new task();
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
						
				
						  h.setTaskname(taskname);
						  h.setTid(tid);
						
						  listreleasetask.add(h);
						  j++;
				          
				  }
			      session.setAttribute("listreleasetask",listreleasetask);
			 
			     
			    
			  
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
	public int selectallcompletetask(HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			     
			      List<task> listcompletetask=new ArrayList<task>();
			      int j=0;
			      sql = "SELECT task.id,task.taskname FROM task,completetask where task.id=t_id  ";
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
	public List<String> selectsimilar(String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask) and task.taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<String> listsearchtask=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
					
					
					
					
					
				
				
					
					  listsearchtask.add(taskname );
					  i++;
			          
			      }
			      
			      return listsearchtask;
			    
			   

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
			return null;
	}
	public int selectsimilarrelease(int uid,String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task where releaseid='"+uid+"' and taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<String> listsearchreleasetask=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
					
					
					
					
					
				
				
					
			    	  listsearchreleasetask.add(taskname );
					  i++;
			          
			      }
			      session.setAttribute("listsearchreleasetask", listsearchreleasetask);
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
	public int selectsimilarreleasetask(int uid,String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname,id FROM task where  releaseid='"+uid+"' and task.taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<task> listreleasetask=new ArrayList<task>();
				    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
					
					
					  int tid=rs.getInt("id");
					
					
				
					  h.setTaskname(taskname);
					  h.setTid(tid);
				
					
					  listreleasetask.add(h);
					  i++;
			          
			      }
			     
			      session.setAttribute("listreleasetask", listreleasetask);
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
	public int selectsimilartask(String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname,id FROM task where task.id!=all(SELECT t_id FROM alreadytask) and id!=all(SELECT t_id FROM completetask) and task.taskname like '%"+keyword+"%'    ";
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
	public int selectsimilarcomplete(int uid,String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task,completetask where task.id=t_id and u_id='"+uid+"' and task.taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<String> listsearchcompletetask=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
					
					
					
					
					
				
				
					
			    	  listsearchcompletetask.add(taskname );
					  i++;
			          
			      }
			      session.setAttribute("listsearchcompletetask", listsearchcompletetask);
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
	public int selectallsimilarcomplete(String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task,completetask where task.id=t_id  and task.taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<String> listsearchcompletetask=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
					
					
					
					
					
				
				
					
			    	  listsearchcompletetask.add(taskname );
					  i++;
			          
			      }
			      session.setAttribute("listsearchcompletetask", listsearchcompletetask);
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
	public int selectsimilarcompletetask(int uid,String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname,task.id  FROM task,completetask where task.id=t_id and u_id='"+uid+"' and task.taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<task> listcompletetask=new ArrayList<task>();
			 	  
				  while(rs.next()) {
				    	  task h=new task();
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
						
				
						  h.setTaskname(taskname);
						  h.setTid(tid);
						
						  listcompletetask.add(h);
						  i++;
				          
				  }
			      session.setAttribute("listcompletetask",listcompletetask);
			      
			     
			    
			  
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
	public int selectallsimilarcompletetask(String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname,task.id  FROM task,completetask where task.id=t_id  and task.taskname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<task> listcompletetask=new ArrayList<task>();
			 	  
				  while(rs.next()) {
				    	  task h=new task();
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
						
				
						  h.setTaskname(taskname);
						  h.setTid(tid);
						
						  listcompletetask.add(h);
						  i++;
				          
				  }
			      session.setAttribute("listcompletetask",listcompletetask);
			      
			     
			    
			  
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
	public int selectsimilaralready(String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname FROM task,alreadytask where task.id=t_id  and task.taskname like '%"+keyword+"%'  ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<String> listsearchalready=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	  task h=new task();
			    	  String taskname =rs.getString("taskname");
					
					
					
					
					
				
				
					
			    	  listsearchalready.add(taskname );
					  i++;
			          
			      }
			      session.setAttribute("listsearchalready", listsearchalready);
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
	public int selectsimilaralreadytask(String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT taskname,task.id FROM task,alreadytask where task.id=t_id  and task.taskname like '%"+keyword+"%' ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
                   List<task> listalreadytask=new ArrayList<task>();
			 	  
				  while(rs.next()) {
				    	  task h=new task();
				    	  int tid=rs.getInt("id");
				    	  String taskname =rs.getString("taskname");
						
				
						  h.setTaskname(taskname);
						  h.setTid(tid);
						
						  listalreadytask.add(h);
						  i++;
				          
				  }
			      session.setAttribute("listalreadytask",listalreadytask);
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

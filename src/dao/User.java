package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import dao.connection;
import bean.task;
import bean.user;


public class User {
  public int insertuser(user u) {
	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs=null;
		try {
			String name=u.getUsername();
			String pass=u.getPassword();
			String address=u.getAddress();
			String bankaccount=u.getBankaccount();
			String card=u.getCard();
			conn = connection.getConnection();
			 stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "SELECT username,password FROM user where username='"+name+"' and password='"+pass+"'  ";
		      rs = stmt.executeQuery(sql);
		      int i=0;
		      if(!rs.next()) {
		    	  String sql_1="INSERT INTO user(username,password,address,bankaccount,card)" +
		                   " VALUES ('"+name+"', '"+pass+"','"+address+"','"+bankaccount+"','"+card+"')";//插入操作...
		          stmt.executeUpdate(sql_1); 
		          return i;
		      }
		      else
				{
					 System.out.println("用户名和密码相同，无法注册");
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
  public int selectusername(String name,String pass,HttpSession session) {
	
	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs =null;	
		try {
			conn = connection.getConnection();
			 stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "SELECT username,password,id,money FROM user where username='"+name+"' and password='"+pass+"'" ;
		      rs = stmt.executeQuery(sql);
		    
		   
		      int i=0;
		      if(rs.next())
		      {
		    	  i=1;
		    	  int uid=rs.getInt("id");
		    	  double money=rs.getDouble("money");
		    	  System.out.println("登陆成功");
		    	  session.setAttribute("uid", uid);	
		    	  session.setAttribute("money",money);   
		          return i;
		      }
		      else
				{
					 System.out.println("没有账号，无法登陆");
					 
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
		}//end finally try
   }//end try
		return 0;
  }
  public int selectall(String name,String pass,HttpSession session) {
	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs=null;
		try {
			conn = connection.getConnection();
			 stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM user where username='"+name+"' and password='"+pass+"'  ";
		      rs = stmt.executeQuery(sql);
		      user u = new user();
		      int i=0;
		      if(rs.next()) {
		    	  String address=rs.getString("address");
	              String bankaccount=rs.getString("bankaccount"); 
	              String card=rs.getString("card"); 
	              double money=rs.getDouble("money");
	              session.setAttribute("address",address);
	              session.setAttribute("bankaccount",bankaccount);
	              session.setAttribute("card",card);
	              session.setAttribute("money",money);
		          System.out.println("查看用户信息成功");
		          return i;
		      }
		      else
				{
					 
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
  public int selectallinformation(HttpSession session) {
	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs=null;
		try {
			conn = connection.getConnection();
			 stmt = (Statement) conn.createStatement();
		      String sql;
		  
		      List<user> listuserinformation=new ArrayList<user>();
		      
		      sql = "SELECT * FROM user where id in (SELECT uid FROM sign where stop is null and start is not null)  ";
		      rs = stmt.executeQuery(sql);
		      int j=0;
		
		    	  
		       while(rs.next()) {
		    	  user u = new user();
		    	  int uid=rs.getInt("id");
		    	  String username=rs.getString("username");
		    	  String address=rs.getString("address");
	              String bankaccount=rs.getString("bankaccount"); 
	              String card=rs.getString("card"); 
	              u.setAddress(address);
	              u.setBankaccount(bankaccount);
	              u.setCard(card);
	              u.setUsername(username);
	              u.setUid(uid);
	          
		        
	              listuserinformation.add(u);
	              j++;
		          }
		    
		      session.setAttribute("listuserinformation",listuserinformation);
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
  public int selectalluser(HttpSession session) {
	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs=null;
		try {
			conn = connection.getConnection();
			 stmt = (Statement) conn.createStatement();
		      String sql;
		     
		      List<user> listalluser=new ArrayList<user>();
		      sql = "SELECT * FROM user  ";
			   rs = stmt.executeQuery(sql);
		      
		  
		    	
		      int i=0;	
		      while(rs.next()) {
		    	  user u = new user();
		    	  int uid=rs.getInt("id");
		    	  String username=rs.getString("username");
		    	  String address=rs.getString("address");
	              String bankaccount=rs.getString("bankaccount"); 
	              String card=rs.getString("card"); 
	              u.setAddress(address);
	              u.setBankaccount(bankaccount);
	              u.setCard(card);
	              u.setUsername(username);
	              u.setUid(uid);
	          
		        
	              listalluser.add(u);
	              i++;
		      }
		   
		      session.setAttribute("listalluser",listalluser);
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
	public int deleteuser(int uid) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			    
		          String sql_2="DELETE  FROM user WHERE id='"+uid+"' ";
                  
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
	public int updateaddmoney(int uid,double addmoney,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			   
			    
				
				
			      int i=0;
			      String sql_2="UPDATE user SET money='"+addmoney+"' WHERE  id='"+uid+"'  ";
			      
			      stmt.executeUpdate(sql_2); 
			      session.setAttribute("money",addmoney);
			      i=1;
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
	public int updatereducemoney(int uid,double money,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			   
			    
				
				
			      int i=0;
			      String sql_2="UPDATE user SET money='"+money+"' WHERE  id='"+uid+"'  ";
			      
			      stmt.executeUpdate(sql_2); 
			      session.setAttribute("money",money);
			      i=1;
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
	public int selectsimilar(String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT username FROM user where username like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<String> listsearchuser=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	  user u = new user();
			    	  
			    	  String username=rs.getString("username");
					
					
					
					
					
				
				
					
			    	  listsearchuser.add(username);
					  i++;
			          
			      }
			      session.setAttribute("listsearchuser", listsearchuser);
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
	public int selectsimilaruser(String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT * FROM user where username like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			    
			      List<user> listalluser=new ArrayList<user>();
			      int i=0;	
			      while(rs.next()) {
			    	  user u = new user();
			    	  int uid=rs.getInt("id");
			    	  String username=rs.getString("username");
			    	  String address=rs.getString("address");
		              String bankaccount=rs.getString("bankaccount"); 
		              String card=rs.getString("card"); 
		              u.setAddress(address);
		              u.setBankaccount(bankaccount);
		              u.setCard(card);
		              u.setUsername(username);
		              u.setUid(uid);
		          
			        
		              listalluser.add(u);
		              i++;
			      }
			   
			      session.setAttribute("listalluser",listalluser);
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

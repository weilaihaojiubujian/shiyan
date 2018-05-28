package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		                   " VALUES ('"+name+"', '"+pass+"','"+address+"','"+bankaccount+"','"+card+"')";//�������...
		          stmt.executeUpdate(sql_1); 
		          return i;
		      }
		      else
				{
					 System.out.println("�û�����������ͬ���޷�ע��");
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
		// �ͷ�������
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
		      sql = "SELECT username,password,id FROM user where username='"+name+"' and password='"+pass+"'" ;
		      rs = stmt.executeQuery(sql);
		    
		   
		      int i=0;
		      if(rs.next())
		      {
		    	  i=1;
		    	  int uid=rs.getInt("id");
		    	  System.out.println("��½�ɹ�");
		    	  session.setAttribute("uid", uid);	
			         
		          return i;
		      }
		      else
				{
					 System.out.println("û���˺ţ��޷���½");
					 
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
		// �ͷ�������
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
	             
	              session.setAttribute("address",address);
	              session.setAttribute("bankaccount",bankaccount);
	              session.setAttribute("card",card);
		        
		          System.out.println("�鿴�û���Ϣ�ɹ�");
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
		// �ͷ�������
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
		      List listuid=(List) session.getAttribute("listuid");
		      List<user> listuserinformation=new ArrayList<user>();
		      
		      
		      int j=0;
		      for(int i=0;i<listuid.size();i++)
		      {
		    	  int uid=(int) listuid.get(i);
		    	  sql = "SELECT * FROM user where id='"+uid+"'  ";
			      rs = stmt.executeQuery(sql);
		          if(rs.next()) {
		    	  user u = new user();
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
		// �ͷ�������
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
		// �ͷ�������
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
			// �ͷ�������
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
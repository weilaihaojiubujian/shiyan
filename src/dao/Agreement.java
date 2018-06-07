package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import bean.agreement;
import bean.task;

public class Agreement {

	public int insertagreement(agreement a,int tid) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
			     
			      String agreementname = a.getAgreementname();
				  String agreementintroduce = a.getAgreementintroduce();
			      sql = "INSERT INTO agreement(agreementname,tid,agreementintroduce)" +
		                   " VALUES ('"+agreementname+"', '"+tid+"','"+agreementintroduce+"')";//插入操作...
			      stmt.executeUpdate(sql); 
			     
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
	public int insertsameagreement(int aid,int tid,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
				 String sql;
			      sql = "SELECT * FROM agreement where id='"+aid+"'" ;
			      rs = stmt.executeQuery(sql);
			      rs.next();
			      
			      String agreementname = rs.getString("agreementname");
				  String agreementintroduce = rs.getString("agreementintroduce");
				  String  sql1 = "INSERT INTO agreement(agreementname,tid,agreementintroduce)" +
		                   " VALUES ('"+agreementname+"', '"+tid+"','"+agreementintroduce+"')";//插入操作...
			      stmt.executeUpdate(sql1); 
			      
			      session.setAttribute("agreementname",agreementname);
				  session.setAttribute("agreementintroduce",agreementintroduce);
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
	public int selectagreement(int tid,HttpSession session) {
		
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs =null;	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "SELECT * FROM agreement where tid='"+tid+"'" ;
			      rs = stmt.executeQuery(sql);
			    
			   
			      int i=0;
			      if(rs.next())
			      {
			    	  i=1;
			    	  agreement a=new agreement();
			    	  int aid=rs.getInt("id");
			    	  String agreementname = rs.getString("agreementname");
					  String agreementintroduce = rs.getString("agreementintroduce");
					  a.setAgreementintroduce(agreementintroduce);
					  a.setAgreementname(agreementname);
					  a.setAid(aid);
			    	  session.setAttribute("aid",aid);	
			    	  session.setAttribute("agreementname",agreementname);	
			    	  session.setAttribute("agreementintroduce",agreementintroduce);
			    	  session.setAttribute("agreement",a);
			          return i;
			      }
			      else
					{
						 
						 
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
	public List<String> selectallagreement(int k) {
		
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs =null;	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      String sql_1 = "SELECT COUNT(*) FROM agreement ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			      int x=(k-1)*4;
			      sql = "SELECT id,agreementname FROM agreement limit "+x+",4 " ;
			      rs = stmt.executeQuery(sql);
			    
			      String m=String.valueOf(max);
			      List<String> listagreement=new ArrayList<String>();
			      listagreement.add(m);
			      int i=0;
			      while(rs.next())
			      {
			    	 
			    	  i=1;
			    	  int aid=rs.getInt("id");
			    	  String agreementname = rs.getString("agreementname");
			    	  String ab=String.valueOf(aid);
			    	  listagreement.add(ab);
			    	  listagreement.add(agreementname);
			          i++;
			      }
			 
			      return listagreement;
			  
			 
		      
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
			return null;
	  }
	public int selectagreementintroduce(int aid,HttpSession session) {
		
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs =null;	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "SELECT * FROM agreement where id='"+aid+"' " ;
			      rs = stmt.executeQuery(sql);
			     
			      agreement a=new agreement();
			      int i=0;
			      if(rs.next())
			      {
			    	
			    	  i=1;
			    	 
			    	  String agreementname = rs.getString("agreementname");
			    	  String agreementintroduce = rs.getString("agreementintroduce");
			    	  
			    	  a.setAid(aid);
			    	  a.setAgreementname(agreementname);
			    	  a.setAgreementintroduce(agreementintroduce);
			    	  session.setAttribute("agreement",a);	
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
	public int selectoneagreementintroduce(int tid,HttpSession session) {
		
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs =null;	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "SELECT * FROM agreement where tid='"+tid+"' " ;
			      rs = stmt.executeQuery(sql);
			     
			      agreement a=new agreement();
			      int i=0;
			      if(rs.next())
			      {
			    	
			    	  i=1;
			    	 int aid=rs.getInt("id");
			    	  String agreementname = rs.getString("agreementname");
			    	  String agreementintroduce = rs.getString("agreementintroduce");
			    	  
			    	  a.setAid(aid);
			    	  a.setAgreementname(agreementname);
			    	  a.setAgreementintroduce(agreementintroduce);
			    	  session.setAttribute("agreement",a);	
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
	public int selectsimilar(String keyword,HttpSession session) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT agreementname FROM agreement where  agreementname like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			      int i=0;
			      List<String> listsearchagreement=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	 
			    	  String agreementname =rs.getString("agreementname");
					
					
					
					
					
				
				
					
			    	  listsearchagreement.add(agreementname);
					  i++;
			          
			      }
			      session.setAttribute("listsearchagreement", listsearchagreement);
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
	public  List<String> selectsimilaragreement(String keyword,int k) {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs=null;
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      String sql_1 = "SELECT COUNT(*) FROM agreement where  agreementname like '%"+keyword+"%' ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			      int x=(k-1)*4;
				  
			    
			      sql = "SELECT id,agreementname FROM agreement where  agreementname like '%"+keyword+"%' limit "+x+",4   ";
			      rs = stmt.executeQuery(sql);
			 
			      String m=String.valueOf(max);
			      List<String> listagreement=new ArrayList<String>();
			      listagreement.add(m);
			      int i=0;
			      while(rs.next())
			      {
			    	 
			    	  i=1;
			    	  int aid=rs.getInt("id");
			    	  String agreementname = rs.getString("agreementname");
			    	  String ab=String.valueOf(aid);
			    	  listagreement.add(ab);
			    	  listagreement.add(agreementname);
			          i++;
			      }
			 
			      return listagreement;
			    
			   

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
}

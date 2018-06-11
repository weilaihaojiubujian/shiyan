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
	 private static Connection conn = null;
	 private static Statement stmt = null;
	 private static  ResultSet rs=null;
	 
	 
	 //�û�ע����֤
  public int insertuser(user u) {

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
	   
	   Catch c=new Catch();
	   c.close(rs, stmt);
	  
		
   }//end try
		return 0;
		
}
  
  //�û���¼��֤
  public int selectusername(String name,String pass,HttpSession session)  {
	

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
		    	  System.out.println("��½�ɹ�");
		    	  session.setAttribute("uid", uid);	
		    	  session.setAttribute("money",money);   
		    	  
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
	   
	   Catch c=new Catch();
	   c.close(rs, stmt);
	   

   }//end try
		return 0;
  }
  
  //�û��鿴�Լ�����Ϣ
  public int selectall(int uid,HttpSession session) {
	
		try {
			conn = connection.getConnection();
			 System.out.println(conn);
			 stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM user where id='"+uid+"'   ";
		      rs = stmt.executeQuery(sql);
		      
		      int i=0;
		      if(rs.next()) {
		    	  String username=rs.getString("username");
		    	  String password=rs.getString("password");
		    	  String address=rs.getString("address");
	              String bankaccount=rs.getString("bankaccount"); 
	              String card=rs.getString("card"); 
	              double money=rs.getDouble("money");
	              session.setAttribute("username",username);
	              session.setAttribute("password",password);
	              session.setAttribute("address",address);
	              session.setAttribute("bankaccount",bankaccount);
	              session.setAttribute("card",card);
	              session.setAttribute("money",money);
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
	   
	   Catch c=new Catch();
	   c.close(rs, stmt);
	 
   }//end try
		return 0;
		
}
  //����Ա�鿴�����û�
  public List<String> selectallinformation(int k) {
	
		try {
			conn = connection.getConnection();
			 stmt = (Statement) conn.createStatement();
		      String sql;
		  
		      String sql_1 = "SELECT COUNT(*) FROM user where id in (SELECT uid FROM sign where stop is null and start is not null)";
		      rs = stmt.executeQuery(sql_1);
		      rs.next();
		      int size=rs.getInt("COUNT(*)");
		      System.out.println(size);
		      int pageSize=4;
		      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
		      int x=(k-1)*4;
		      
		      sql = "SELECT id,username FROM user where id in (SELECT uid FROM sign where stop is null and start is not null) limit "+x+",4 ";
		      rs = stmt.executeQuery(sql);
		   
		      String m=String.valueOf(max);
			   List<String> listuser=new ArrayList<String>();
			   listuser.add(m);
		  
		    	  
		       while(rs.next()) {
		    	
		    	  int uid=rs.getInt("id");
		    	  String username=rs.getString("username");
		    	  String u=String.valueOf(uid);
		    	  listuser.add(u);
		    	  listuser.add(username);
	          
		        
	           
		          }
		       String s=String.valueOf(size);
		       listuser.add(s);
		      
		      return listuser;
		   

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
  
  //�鿴�û���Ϣ
  public int selectuid(int uid,HttpSession session) {
	 
		try {
			conn = connection.getConnection();
			 stmt = (Statement) conn.createStatement();
		      String sql;
		     
		     
		      sql = "SELECT * FROM user where id='"+uid+"' ";
			   rs = stmt.executeQuery(sql);
		      
		  
		    	
		      int i=0;	
		      while(rs.next()) {
		    	 
		    	  
		    	  String username=rs.getString("username");
		    	  String address=rs.getString("address");
	              String bankaccount=rs.getString("bankaccount"); 
	              String card=rs.getString("card"); 
	              double money=rs.getDouble("money");
	              session.setAttribute("username",username);
	              session.setAttribute("address",address);
	              session.setAttribute("bankaccount",bankaccount);
	              session.setAttribute("card",card);
	              session.setAttribute("uid",uid);
	              session.setAttribute("money",money);
	              i++;
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
  
  //����Ա��ʾ�ڼ�ҳ���û�
  public List<String> selectalluser(int k) {
	
		try {
			conn = connection.getConnection();
			 stmt = (Statement) conn.createStatement();
		      String sql;
		      
		      String sql_1 = "SELECT COUNT(*) FROM user ";
		      rs = stmt.executeQuery(sql_1);
		      rs.next();
		      int size=rs.getInt("COUNT(*)");
		      System.out.println(size);
		      int pageSize=4;
		      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
		      int x=(k-1)*4;
		    
		      sql = "SELECT id,username FROM user limit "+x+",4 ";
			   rs = stmt.executeQuery(sql);
			   String m=String.valueOf(max);
			   List<String> listuser=new ArrayList<String>();
			   listuser.add(m);
		  
		    	
		 
		      while(rs.next()) {
		    	 
		    	  int uid=rs.getInt("id");
		    	  String username=rs.getString("username");
		    	  String u=String.valueOf(uid);
		        
		    	  listuser.add(u);
		    	  listuser.add(username);
	           
		      }
		   
		 
		      return listuser;
		   

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
  
  //����Աɾ���û�
	public int deleteuser(int uid) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			    
			    
			     
			    
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
		   
		   Catch c=new Catch();
		   c.close(rs, stmt);
	   }//end try
			return 0;
	}
	
	//�û���ֵ
	public int updateaddmoney(int uid,double addmoney,HttpSession session) {
	
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
		   
		   Catch c=new Catch();
		   c.close(rs, stmt);
	   }//end try
			return 0;
	}
	
	//�û�����
	public int updatereducemoney(int uid,double money,HttpSession session) {
	
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
		   
		   Catch c=new Catch();
		   c.close(rs, stmt);
	   }//end try
			return 0;
	}
	
	
	public List<String> selectsimilar(String keyword) {
	
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			    
				  
			    
			      sql = "SELECT username FROM user where username like '%"+keyword+"%'    ";
			      rs = stmt.executeQuery(sql);
			 
			      List<String> listuser=new ArrayList<String>();
				    
			      while(rs.next()) {
			    	
			    	  
			    	  String username=rs.getString("username");
					
					
					
					
					
				
				
					
			    	  listuser.add(username);
				
			          
			      }
			      
			      return listuser;
			    
			   

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
	
	//����Աͨ��������õ����û�
	public  List<String> selectsimilaruser(String keyword,int k) {
		
			try {
				conn = connection.getConnection();
				 stmt = (Statement) conn.createStatement();
			      String sql;
			      
			      String sql_1 = "SELECT COUNT(*) FROM user where username like '%"+keyword+"%' ";
			      rs = stmt.executeQuery(sql_1);
			      rs.next();
			      int size=rs.getInt("COUNT(*)");
			      System.out.println(size);
			      int pageSize=4;
			      int max=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			      int x=(k-1)*4;
			    
				  
			    
			      sql = "SELECT id,username FROM user where username like '%"+keyword+"%' limit "+x+",4   ";
			      rs = stmt.executeQuery(sql);
			    
			      String m=String.valueOf(max);
				   List<String> listuser=new ArrayList<String>();
				   listuser.add(m);
			  
			    	
			     
			      while(rs.next()) {
			    	 
			    	  int uid=rs.getInt("id");
			    	  String username=rs.getString("username");
			    	  String u=String.valueOf(uid);
			        
			    	  listuser.add(u);
			    	  listuser.add(username);
		         
			      }
			   
			 
			      return listuser;
			   

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

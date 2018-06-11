package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



public class connection {


    private static final String driver ="com.mysql.jdbc.Driver";  //数据库驱动
	//连接数据库的URL地址
	private static final String url="jdbc:mysql://localhost/outsourcing?useUnicode=true&characterEncoding=utf-8&useSSL=false";

	private static final String username="root";//数据库的用户名
	private static final String password="1004758012";//数据库的密码
    
	private static Connection conn=null;
	
	//静态代码块负责加载驱动
	static 
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("数据库连接正常！");
			return conn;
		}
		System.out.println("数据库正常连接！");
		return conn;
	}
	
	public static void close() throws Exception
	{
		if (conn!=null){
            try {
            	conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn=null;
        }
	}
	
	public static void main(String[] args) {
		
		try
		{
		   Connection conn = connection.getConnection();
		   if(conn!=null)
		   {
			   System.out.println("数据库连接正常！");
		   }
		   else
		   {
			   System.out.println("数据库连接异常！");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}

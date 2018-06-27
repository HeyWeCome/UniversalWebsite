package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static Connection getConnection() throws Exception{
		String driverName = "com.mysql.jdbc.Driver";
		//数据库URL
		String url = "jdbc:mysql://localhost:3306/questionnaire?useUnicode=true&characterEncoding=UTF-8";//使数据库存入中文时不乱码
		String userName = "root";
		String userPWD = "";
		
		Class.forName(driverName);//启动
		
		Connection connection = DriverManager.getConnection(url,userName,userPWD);//获得连接
		
		return connection;
	}
	
	public static boolean execute(String sql) throws Exception{
		Connection connection = getConnection();
		
		Statement  statement =  connection.createStatement();
		
		return statement.execute(sql);
	}
	
	public static ResultSet list(String sql) throws Exception{
		Connection connection = getConnection();
		ResultSet result = null;	
		
		/*try {
			Statement statement = connection.createStatement();
			statement.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		try {
			PreparedStatement preparedStatement =  connection.prepareStatement(sql);
			result = preparedStatement.executeQuery();//得到数据库中所有的数据
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		/*finally{
			try {
					connection.close();
	             } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }

		}*/
		return result;
	}
}

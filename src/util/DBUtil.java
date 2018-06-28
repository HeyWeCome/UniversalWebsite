package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	// 连接数据库
	public static Connection getConnection() throws Exception{
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/universalwebsite?useUnicode=true&characterEncoding=UTF-8";
		
		// 换成你们各自对应的账号密码
		String userName = "root";
		String userPWD = "";

		Class.forName(driverName);

		Connection conn = DriverManager.getConnection(url,userName,userPWD);

		return conn;
	}

	public static boolean execute(String sql) throws Exception{
		Connection connection = getConnection();

		Statement statement = connection.createStatement();

		return statement.execute(sql);

	}
	
	public static ResultSet returnList(String sql) throws Exception{
		Connection connection = getConnection();
		ResultSet result = null;	
		
		try {
			PreparedStatement preparedStatement =  connection.prepareStatement(sql);
			result = preparedStatement.executeQuery();//得到数据库中所有的数据
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return result;
	}
}

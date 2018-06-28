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
		String url = "jdbc:mysql://localhost:3306/universalwebsite";
		
		// 换成你们各自对应的账号密码
		String userName = "root";
		String userPWD = "123456";

		Class.forName(driverName);

		Connection conn = DriverManager.getConnection(url,userName,userPWD);

		return conn;
	}

	public static boolean execute(String sql) throws Exception{
		Connection connection = getConnection();

		Statement statement = connection.createStatement();

		return statement.execute(sql);

	}
	
	/**
	 * 
	 * @Title:        findAccount  
	 * @Description:  查询搜索账号密码后的结果:1就是找到了，0没找到
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       int     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 上午9:59:46
	 */
	public static int findAccount(String sql) throws Exception{
		Connection connection = getConnection();
		int flag = 0;	//	用来记录是否找到找到了账号
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		if(resultSet.next()){
			flag = 1;
		}

		if(flag == 1){
			// 关闭相应的链接
			statement.close();
			connection.close();
			return 1;
		}else{
			// 关闭相应的链接
			statement.close();
			connection.close();
			return 0;
		}

	}
}

/**
 * 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/** 
 * @ClassName:     UpdateDBUtil.java 
 * @Description:   修改数据库工具类
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午4:07:33  
 */
public class UpdateDBUtil {
	// 连接数据库
	public static Connection getConnection() throws Exception{
		String driverName = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3306/universalwebsite?useUnicode=true&characterEncoding=UTF-8";

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
	
	public static Integer updateArticleStatus(String sql) throws Exception{
		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		// 删除成功返回1 否则返回0
		if(statement.executeUpdate(sql) == 1){
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

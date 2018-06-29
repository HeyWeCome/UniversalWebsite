/**
 * 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/** 
 * @ClassName:     DeleteDBUtil.java 
 * @Description:   删除工具类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午5:25:13  
 */
public class DeleteDBUtil {
	// 连接数据库
	public static Connection getConnection() throws Exception{
		String driverName = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3306/universalwebsite";

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
	
	/**
	 * 
	 * @Title:        deleteArticle  
	 * @Description:  删除文章  
	 * @param:        @param sql
	 * @param:        @return     
	 * @return:       Integer     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午5:26:31
	 */
	public static Integer deleteArticle(String sql) throws Exception{
		Connection connection = getConnection();
		Statement statement = connection.createStatement();

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

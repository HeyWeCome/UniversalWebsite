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
	
	/**
	 * 
	 * @Title:        deleteRole  
	 * @Description:  执行删除角色  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       Integer     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午6:12:58
	 */
	public static Integer deleteRole(String sql) throws Exception{
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
	
	/**
	 * 
	 * @Title:        deleteEmployee  
	 * @Description:  删除员工 
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       Integer     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午1:05:21
	 */
	public static Integer deleteEmployee(String sql) throws Exception{
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
	
	/**
	 * 
	 * @Title:        deleteExistingPermission  
	 * @Description:  删除一个角色已有的权限 
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       Integer     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午1:41:18
	 */
	public static Integer deleteExistingPermission(String sql) throws Exception{
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

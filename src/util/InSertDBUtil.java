/**
 * 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Article;

/** 
 * @ClassName:     InSertDBUtil.java 
 * @Description:   用来执行操作操作的工具类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午4:34:24  
 */
public class InSertDBUtil {
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

	/**
	 * 
	 * @Title:        insertArticle  
	 * @Description:  插入文章  
	 * @param:        @param article
	 * @param:        @return     
	 * @return:       int     
	 * @throws Exception 
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午4:38:10
	 */
	public static int insertArticle(String sql) throws Exception{
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
	 * @Title:        insertPermission  
	 * @Description:  插入权限
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       int     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午10:49:59
	 */
	public static int insertPermission(String sql) throws Exception{
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
	 * @Title:        insertRole  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       int     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午11:12:17
	 */
	public static int insertRole(String sql) throws Exception{
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

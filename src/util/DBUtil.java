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
	
	
	/**
	 * 
	 * @Title:        findAllModule  
	 * @Description:  找到所有的模块 
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午2:37:38
	 */
	public static String findAllModule(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String id = result.getString("id");
			String name = result.getString("name");
			String status = result.getString("status");

			returnResult += "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"status\":\""+status+"\"},";
		}

		returnResult = returnResult.substring(0,returnResult.length()-1);
		returnResult += "]";
		// 关闭相应的链接
		result.close();
		statement.close();
		connection.close();

		return returnResult;
	}

	/**  
	 * @Title:        findAllSonModule  
	 * @Description:  找到所有的字模块 
	 * @param:        @param sql
	 * @param:        @return     
	 * @return:       String     
	 * @throws Exception 
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午3:07:18  
	 */  
	public static String findAllSonModule(String sql) throws Exception {
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String id = result.getString("id");
			String name = result.getString("name");
			String status = result.getString("status");
			String parentModuleID = result.getString("parentModuleID");
			
			returnResult += "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"status\":\""+status+"\",\"parentModuleID\":\""+parentModuleID+"\"},";
		}

		returnResult = returnResult.substring(0,returnResult.length()-1);
		returnResult += "]";
		// 关闭相应的链接
		result.close();
		statement.close();
		connection.close();

		return returnResult;
	}
	
	/**
	 * 
	 * @Title:        findAllArticle  
	 * @Description:  从数据库中读出所有文章  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午3:53:22
	 */
	public static String findAllArticle(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		try {
			// 相对应的读出文章每一行的所有元素内容
			while(result.next()){
				String id = result.getString("id");
				String title = result.getString("title");
				String employeeID = result.getString("employeeID");
				String columnID = result.getString("columnID");
				String content = result.getString("content");
				String createTime = result.getString("createTime");
				String whetherTop = result.getString("whetherTop");
				String status = result.getString("status");
				
				returnResult += "{\"id\":\""+id+"\",\"title\":\""+title+"\",\"employeeID\":\""+employeeID
						+"\",\"columnID\":\""+columnID+"\",\"content\":\""+content
						+"\",\"createTime\":\""+createTime
						+"\",\"whetherTop\":\""+whetherTop
						+"\",\"status\":\""+status
						+"\"},";
			}

			returnResult = returnResult.substring(0,returnResult.length()-1);
			returnResult += "]";
			// 关闭相应的链接
			result.close();
			statement.close();
			connection.close();

			return returnResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

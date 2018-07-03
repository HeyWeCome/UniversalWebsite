package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.Employee;

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
	 * @Title:        findUserName  
	 * @Description:  找到用户名  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       int     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午9:05:08
	 */
	public static String findUserName(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String name = result.getString("name");


			returnResult += "{\"name\":\""+name+"\"},";
		}

		returnResult = returnResult.substring(0,returnResult.length()-1);
		returnResult += "]";
		// 关闭相应的链接
		result.close();
		statement.close();
		connection.close();

		return returnResult;

	}
	
	public static String findFilePath(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String path = result.getString("path");


			return path;
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
			String parentModuleID = result.getString("parentModuleID");
			
			returnResult += "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"parentModuleID\":\""+parentModuleID+"\"},";
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
		//System.out.println("sql:"+sql);
		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		try {
			// 相对应的读出文章每一行的所有元素内容
			while(result.next()){
				String title = result.getString("title");
				String author = result.getString("roleName");
				String columnName = result.getString("columnsName");
				String createTime = result.getString("createTime");
				String whetherTop = result.getString("whetherTop");
				
				if(whetherTop.equals("1")){
					whetherTop = "是";
				}else{
					whetherTop = "否";
				}
				
				returnResult += "{\"title\":\""+title
						+"\",\"author\":\""+author
						+"\",\"columnName\":\""+columnName
						+"\",\"createTime\":\""+createTime
						+"\",\"whetherTop\":\""+whetherTop
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
	
	public static String findAllHomePageArticleContent(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		try {
			// 相对应的读出文章每一行的所有元素内容
			while(result.next()){
				String title = result.getString("title");
				String content = result.getString("content");
				
				returnResult += "{\"title\":\""+title
						+"\",\"content\":\""+content
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
	
	/**
	 * 
	 * @Title:        findAllAuditArticle  
	 * @Description:  找到所有未审核的文章 
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午1:29:45
	 */
	public static String findAllAuditArticle(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		try {
			// 相对应的读出文章每一行的所有元素内容
			while(result.next()){
				String title = result.getString("title");
				String author = result.getString("roleName");
				String columnName = result.getString("columnsName");
				String createTime = result.getString("createTime");
				String whetherTop = result.getString("whetherTop");
				String status = result.getString("status");
				
				if(whetherTop.equals("1")){
					whetherTop = "是";
				}else{
					whetherTop = "否";
				}
				
				if(status.equals("0")){
					status = "未审核";
				}else if(status.equals("1")){
					status = "审核通过";
				}else{
					status = "审核不通过";
				}
				
				returnResult += "{\"title\":\""+title
						+"\",\"author\":\""+author
						+"\",\"columnName\":\""+columnName
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
	
	/**
	 * 
	 * @Title:        findAllColumns  
	 * @Description:  找到所有的栏目 
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午4:42:32
	 */
	public static String findAllColumns(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		try {
			// 相对应的读出文章每一行的所有元素内容
			while(result.next()){
				String id = result.getString("id");
				String name = result.getString("name");
				String level = result.getString("level");
				
				returnResult += "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"level\":\""+level+"\"},";
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
	
	/**
	 * 
	 * @Title:        findAllSonColumns  
	 * @Description:  搜索所有的子栏目  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午4:52:59
	 */
	public static String findAllSonColumns(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		try {
			// 相对应的读出文章每一行的所有元素内容
			while(result.next()){
				String id = result.getString("id");
				String name = result.getString("name");
				String level = result.getString("level");
				String parentID = result.getString("parentID");
				returnResult += "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"level\":\""+level+"\",\"parentID\":\""+parentID+"\"},";
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
	
	
	
	/**
	 * 
	 * @Title:        findAllRoles  
	 * @Description:  找到所有的角色  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午2:54:47
	 */
	public static String findAllRoles(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		try {
			// 相对应的读出文章每一行的所有元素内容
			while(result.next()){
				String id = result.getString("id");
				String name = result.getString("name");
				String createTime = result.getString("createTime");
				String description = result.getString("description");
				returnResult += "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"createTime\":\""+createTime
						+"\",\"description\":\""+description+"\"},";
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
	
	/**
	 * 
	 * @Title:        findID  
	 * @Description:  从指定表中找到ID  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午4:26:15
	 */
	public static Integer findID(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		try {
			// 相对应的读出每一行的所有元素内容
			while(result.next()){
				/*Integer id = result.getInt("id");
				return id;*/
				int id = result.getInt("id");
				System.out.println("DButil返回的id:"+id);
				return id;
			}

			//returnResult = returnResult.substring(0,returnResult.length()-1);
			// 关闭相应的链接
			result.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @Title:        findAllEmployee  
	 * @Description:  查询所有的人员 
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午9:16:40
	 */
	public static String findAllEmployee(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		try {
			// 相对应的读出文章每一行的所有元素内容
			while(result.next()){
				String name = result.getString("name");
				String sex = result.getString("sex");
				String account = result.getString("account");
				String passWord = result.getString("passWord");
				String roleName = result.getString("roleName");
				
				returnResult += "{\"name\":\""+name
						+"\",\"sex\":\""+sex
						+"\",\"account\":\""+account
						+"\",\"passWord\":\""+passWord
						+"\",\"roleName\":\""+roleName
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
	
	/**
	 * 
	 * @Title:        findArticleContent  
	 * @Description:  找到指定文章内容
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午9:52:51
	 */
	public static String findArticleContent(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);


		try {
			// 相对应的读出文章每一行的所有元素内容
			while(result.next()){
				String content = result.getString("content");
				return content;
			}
			// 关闭相应的链接
			result.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @Title:        findEmployee  
	 * @Description:  查看员工是否存在 
	 * @param:        @param employee
	 * @param:        @return     
	 * @return:       Integer     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午12:41:58
	 */
	public static Integer findEmployee(Employee employee) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery("select * from employee where account = '"+employee.getAccount()+"';");
		try {
			// 相对应的读出每一行的所有元素内容
			while(result.next()){
				return 1;
			}
			// 关闭相应的链接
			result.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	/**
	 * 
	 * @Title:        findExistingPermission  
	 * @Description:  找到已有的权限  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午2:17:18
	 */
	public static String findExistingPermission(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			int moduleID = result.getInt("moduleID");
			returnResult += "{\"moduleID\":\""+moduleID+"\"},";
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
	 * @Title:        findAllMessage  
	 * @Description:  找到所有的留言
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午4:31:22
	 */
	public static String findAllMessage(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String content = result.getString("content");
			String createTime = result.getString("createTime");
			String reply = result.getString("reply");
			String replyTime = result.getString("replyTime");
			String replyEmployee = result.getString("replyEmployee");
			String status = result.getString("status");

			if(status.equals("0")){
				status = "未回复";
				replyEmployee = "待回复";
				replyTime = "待回复";
			}else if(status.equals("1")){
				status = "已回复";
			}

			returnResult += "{\"content\":\""+content
					+"\",\"createTime\":\""+createTime
					+"\",\"reply\":\""+reply
					+"\",\"replyTime\":\""+replyTime
					+"\",\"replyEmployee\":\""+replyEmployee
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
	}
	
	/**
	 * 
	 * @Title:        findAllPASColumns  
	 * @Description:  找到所有父模块和关联的子模块  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午3:59:53
	 */
	public static String findAllPASColumns(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String name = result.getString("name");
			String parentName = result.getString("parentName");
			String level = result.getString("level");

			
			returnResult += "{\"name\":\""+name
					+"\",\"parentName\":\""+parentName					
					+"\",\"level\":\""+level
					+"\"},";
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
	 * @Title:        findAllCourse  
	 * @Description:  找到所有的课程  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午7:59:51
	 */
	public static String findAllCourse(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			int id = result.getInt("id");
			String name = result.getString("name");
			String introduction = result.getString("introduction");
			String principal = result.getString("principal");
			

			returnResult += "{\"id\":\""+id
					+"\",\"name\":\""+name					
					+"\",\"introduction\":\""+introduction
					+"\",\"principal\":\""+principal
					+"\"},";
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
	 * @Title:        findAllPASModule  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @param:        @param sql
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午11:56:59  
	 */  
	public static String findAllPASModule(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String parentName = result.getString("parentName");
			String parentStatus = result.getString("parentStatus");
			String sonName = result.getString("sonName");
			String sonStatus = result.getString("sonStatus");
			
			if(parentStatus.equals("0")){
				parentStatus="废用";
			}else if(parentStatus.equals("1")){
				parentStatus="启用";
			}
			
			if(sonStatus.equals("0")){
				sonStatus="废用";
			}else if(sonStatus.equals("1")){
				sonStatus="启用";
			}

			
			returnResult += "{\"parentName\":\""+parentName
					+"\",\"parentStatus\":\""+parentStatus					
					+"\",\"sonName\":\""+sonName
					+"\",\"sonStatus\":\""+sonStatus
					+"\"},";
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
	 * @Title:        homePagefindAllSonColumns  
	 * @Description:  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 下午3:03:39
	 */
	public static String homePagefindAllSonColumns(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String id = result.getString("id");
			String name = result.getString("name");
			
			returnResult += "{\"id\":\""+id
					+"\",\"name\":\""+name					
					+"\"},";
		}

		returnResult = returnResult.substring(0,returnResult.length()-1);
		returnResult += "]";
		// 关闭相应的链接
		result.close();
		statement.close();
		connection.close();

		return returnResult;
	}
	
	public static String homePagefindAllResource(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String title = result.getString("title");
			String name = result.getString("name");
			
			returnResult += "{\"title\":\""+title
					+"\",\"name\":\""+name					
					+"\"},";
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
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @param:        @param sql
	 * @param:        @return
	 * @param:        @throws Exception     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 下午4:57:01
	 */
	public static String findhomePageAllArticle(String sql) throws Exception{
		Connection connection = getConnection();
		String returnResult = "";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);
		returnResult += "[";

		while(result.next()){
			String title = result.getString("title");
			
			returnResult += "{\"title\":\""+title			
					+"\"},";
		}

		returnResult = returnResult.substring(0,returnResult.length()-1);
		returnResult += "]";
		// 关闭相应的链接
		result.close();
		statement.close();
		connection.close();

		return returnResult;
	}
}

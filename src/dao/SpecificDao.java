package dao;

import entity.Article;

/**
 * 
 * @ClassName:     SpecificDao.java 
 * @Description:   特殊的sql语句生成类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:53:23
 */
public class SpecificDao {
	/**
	 * 
	 * @Title:        whetherAccountInTable  
	 * @Description:  判断账号是否存在  
	 * @param:        @param account
	 * @param:        @param passWord
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午2:53:43
	 */
	public static String whetherAccountInTable(String account, String passWord, String tableName){
		return "select * from "+tableName+" where account = '"+account+"' and passWord = '"+passWord+"';";
	}

	/**
	 * 
	 * @Title:        selectAllFromTable  
	 * @Description:  返回指定table所有的内容 
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午2:53:59
	 */
	public static String selectAllFromTable(String tableName){
		return "select * from "+tableName+";";
	}

	/**
	 * 
	 * @Title:        selectAllArticle  
	 * @Description:  选择所有的文章,按照前台指定格式返回
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午3:00:43
	 */
	public static String selectAllArticle(){
		String sql = "SELECT" +
				"	article.title," +
				"	employee.NAME AS roleName," +
				"	sonColumns.NAME AS columnsName," +
				"	article.createTime," +
				"	article.whetherTop " +
				"FROM " +
				"	article," +
				"	sonColumns," +
				"	employee " +
				"WHERE " +
				"article.columnID = sonColumns.id " +
				"AND article.employeeID = employee.id";

		return sql;

	}

	/**
	 * 
	 * @Title:        selectAllArticle  
	 * @Description:  选择所有的文章,按照前台指定格式返回
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午3:00:43
	 */
	public static String selectAllAuditArticle(){
		String sql = "SELECT" +
				"	article.title," +
				"	employee.NAME AS roleName," +
				"	sonColumns.NAME AS columnsName," +
				"	article.createTime," +
				"	article.whetherTop, " +
				"	article.status " +
				"FROM " +
				"	article," +
				"	sonColumns," +
				"	employee " +
				"WHERE " +
				"article.columnID = sonColumns.id " +
				"AND article.employeeID = employee.id;";

		return sql;

	}


	/**
	 * 
	 * @Title:        findUserName  
	 * @Description:  根据账号密码找到用户名
	 * @param:        @param account
	 * @param:        @param passWord
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午1:26:44
	 */
	public static String findUserName(String account, String passWord){
		// 生成sql
		return "select name from employee where account = '"+account+"' and passWord = '"+passWord+"';";

	}


	/**
	 * 
	 * @Title:        findIDFromTable  
	 * @Description:  根据名称从指定表中返回ID
	 * @param:        @param name
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午4:23:36
	 */
	public static String findIDFromTable(String name,String tableName){
		// 生成sql
		String sql = "select id from "+tableName+" where name = '"+name+"'";

		return sql;
	}

	/**
	 * 
	 * @Title:        deleteArticle  
	 * @Description:  删除文章对象 
	 * @param:        @param articleName
	 * @param:        @param authorID
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午5:16:10
	 */
	public static String deleteArticle(Integer authorID, String title){
		String sql = "delete from article where employeeID = "+authorID
				+" and title = '"+title+"';";
		return sql;
	}


	/**
	 * 
	 * @Title:        deletRole  
	 * @Description:  删除角色
	 * @param:        @param roleID
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午6:10:49
	 */
	public static String deletRole(Integer roleID){
		String sql = "delete from role where id = "+roleID+";";
		return sql;
	}
	/**
	 * 
	 * @Title:        passArticle  
	 * @Description:  修改文章状态的sql 
	 * @param:        @param article
	 * @param:        @param employeeID
	 * @param:        @param status
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午4:04:04
	 */
	public static String passArticle(String article, Integer employeeID, String status){
		return "update Article "+
				" SET status = '"+status+"' "+
				" where title = '"+article+"'"+
				" and employeeID = "+employeeID+";";

	}

	/**
	 * 
	 * @Title:        findAllEmployee  
	 * @Description:  查询所有的人员  
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午9:11:53
	 */
	public static String findAllEmployee(){
		return "select employee.name,employee.sex,employee.account,employee.passWord,role.name as roleName "
				+ "from employee,role "
				+ "where employee.roleID = role.id";
	}

	/**
	 * 
	 * @Title:        findArticleContent  
	 * @Description:  找寻指定文章内容
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午9:49:08
	 */
	public static String findArticleContent(String title, Integer employeeID){
		return "select article.content "
				+" from article "
				+ " where article.title = '"+title
				+ "' and article.employeeID = "+employeeID;
	}

	public static String updateArticle(Article article){
		// 获取文章标题
		String title = article.getTitle();
		// 获取作者ID
		Integer authorID = article.getEmployeeID();
		// 获取子栏目
		Integer columnID = article.getColumnID();
		// 获取是否置顶
		String whetherTop = article.getWhetherTop();
		// 获取文章内容
		String content = article.getContent();

		return "update Article"+
				" SET title = '"+title+"', "+
				" employeeID = "+authorID+", "+
				" columnID = "+columnID+", "+
				" whetherTop = '"+whetherTop+"', "+
				" content = '"+content+"' "+
				" where title = '"+title+"'"+
				" and employeeID = "+authorID+";";
	}
}

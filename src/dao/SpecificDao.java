package dao;

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
}

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
}
